package com_nix_ragency.dao;

import com_nix_ragency.dao.SqlStrings.FlatStrings;
import com_nix_ragency.models.Flat;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcFlatDao extends JdbcGenericDao<Flat> implements FlatDao {
    public JdbcFlatDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected EntityMapper<Flat> getEntityMapper() {
        return new EntityMapper<Flat>() {

            @Override
            @SneakyThrows
            public Flat fromResultSet(ResultSet resultSet) {
                return Flat.builder().id(resultSet.getLong("id"))
                        .address(resultSet.getString("address"))
                        .city(resultSet.getString("city"))
                        .build();

            }

            @Override
            @SneakyThrows
            public void fillStatement(PreparedStatement statement,
                                      Flat entity) {
                statement.setString(1, entity.getAddress());
                statement.setString(2, entity.getCity());
                statement.setBigDecimal(2, entity.getPrice());

            }
        };
    }

    @Override
    protected String getUpdateSql() {
        return FlatStrings.SQL_UPDATE;
    }

    @Override
    protected String getCreateSql() {
        return FlatStrings.SQL_CREATE;
    }

    @Override
    protected String getDeleteSql() {
        return FlatStrings.SQL_DELETE;
    }

    @Override
    public String getFindAllSql() {
        return FlatStrings.SQL_FIND_ALL;
    }

    @Override
    protected String getFindByIdSql() {
        return FlatStrings.SQL_FIND_BY_ID;
    }
}
