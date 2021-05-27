package com_nix_ragency.dao;



import com_nix_ragency.dao.SqlStrings.OwnerStrings;
import com_nix_ragency.models.Owner;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcOwnerDao extends JdbcGenericDao<Owner> implements OwnerDao {

    public JdbcOwnerDao(DataSource dataSource) {
        super(dataSource);
    }

    protected EntityMapper<Owner> getEntityMapper() {
        return new EntityMapper<Owner>() {

            @Override
            @SneakyThrows
            public Owner fromResultSet(ResultSet resultSet) {
                return Owner.builder().id(resultSet.getLong("id"))
                        .username(resultSet.getString("username"))
                        .password(resultSet.getString("password"))
                        .firstname(resultSet.getString("firstname"))
                        .lastname(resultSet.getString("lastname"))

                        .build();
            }


            @SneakyThrows
            public void fillStatement(PreparedStatement statement,
                                      Owner entity) {
                statement.setString(1, entity.getUsername());
                statement.setString(2, entity.getPassword());
                statement.setString(3, entity.getFirstname());
                statement.setString(4, entity.getLastname());

            }
        };
    }


    @Override
    protected String getUpdateSql() {
        return OwnerStrings.SQL_UPDATE;
    }

    @Override
    protected String getCreateSql() {
        return OwnerStrings.SQL_CREATE;
    }

    @Override
    protected String getDeleteSql() {
        return OwnerStrings.SQL_DELETE;
    }

    @Override
    public String getFindAllSql() {
        return OwnerStrings.SQL_FIND_ALL;
    }
    @Override
    protected String getFindByIdSql() {
        return OwnerStrings.SQL_FIND_BY_ID;
    }
}
