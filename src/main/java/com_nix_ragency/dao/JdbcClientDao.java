package com_nix_ragency.dao;


;

import com_nix_ragency.dao.SqlStrings.ClientStrings;
import com_nix_ragency.models.Client;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcClientDao extends JdbcGenericDao<Client> implements ClientDao {
    public JdbcClientDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected EntityMapper<Client> getEntityMapper() {
        return new EntityMapper<Client>() {

            @Override
            @SneakyThrows
            public Client fromResultSet(ResultSet resultSet) {
                return Client.builder().id(resultSet.getLong("id"))
                        .username(resultSet.getString("username"))
                        .password(resultSet.getString("password"))
                        .firstname(resultSet.getString("firstName"))
                        .lastname(resultSet.getString("lastName"))
                        .build();

            }

            @Override
            @SneakyThrows
            public void fillStatement(PreparedStatement statement,
                                      Client entity) {
                statement.setString(1, entity.getUsername());
                statement.setString(2, entity.getPassword());
                statement.setString(3, entity.getFirstname());
                statement.setString(4, entity.getLastname());

            }
        };
    }

    @Override
    protected String getUpdateSql() {
        return ClientStrings.SQL_UPDATE;
    }

    @Override
    protected String getCreateSql() {
        return ClientStrings.SQL_CREATE;
    }

    @Override
    protected String getDeleteSql() {
        return ClientStrings.SQL_DELETE;
    }

    @Override
    public String getFindAllSql() {
        return ClientStrings.SQL_FIND_ALL;
    }
    @Override
    protected String getFindByIdSql() {
        return ClientStrings.SQL_FIND_BY_ID;
    }
}
