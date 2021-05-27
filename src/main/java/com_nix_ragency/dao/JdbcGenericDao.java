package com_nix_ragency.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;


import com_nix_ragency.models.IEntity;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public abstract class JdbcGenericDao<E extends IEntity> implements Dao<E> {

    protected final DataSource dataSource;

    @SneakyThrows
    @Override
    public E findById(Long id) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement st = con.prepareStatement(getFindByIdSql())) {
             st.setLong(1, id);
             ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                EntityMapper<E> entityMapper = getEntityMapper();
                return entityMapper.fromResultSet(resultSet);
            }
        }
        return null;

    }
    protected abstract String getFindAllSql();
    protected abstract String getUpdateSql();
    protected abstract String getCreateSql();
    protected abstract String getDeleteSql();
    protected abstract String getFindByIdSql();
    protected abstract EntityMapper<E> getEntityMapper();
    @Override
    @SneakyThrows
    public E create(E entity) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement st = con.prepareStatement(getCreateSql(),
                     Statement.RETURN_GENERATED_KEYS)) {

            getEntityMapper().fillStatement(st, entity);

            int rows = st.executeUpdate();
            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
                entity.setId(generatedKeys.getLong(1));
            }
            return entity;
        }
    }

    @Override
    @SneakyThrows
    public void update(E entity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getUpdateSql())) {

            getEntityMapper().fillStatement(preparedStatement, entity);
            preparedStatement.executeUpdate();

        }

    }

    @Override
    @SneakyThrows
    public void delete(E entity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getDeleteSql())) {
            preparedStatement.setLong(1,entity.getId());
            preparedStatement.execute();
        }

    }

    @Override
    @SneakyThrows
    public List<E> findAll() {
        List<E> result = new LinkedList<>();
        try (Connection con = dataSource.getConnection();
             PreparedStatement st = con.prepareStatement(getFindAllSql())) {

            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                EntityMapper<E> entityMapper = getEntityMapper();
                E e = entityMapper.fromResultSet(resultSet);
                result.add(e);
            }
        }

        return result;
    }

}