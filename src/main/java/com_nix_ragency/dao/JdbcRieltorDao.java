package com_nix_ragency.dao;

import com_nix_ragency.dao.SqlStrings.OwnerStrings;
import com_nix_ragency.dao.SqlStrings.RieltorStrings;
import com_nix_ragency.models.Owner;
import com_nix_ragency.models.Rieltor;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcRieltorDao extends JdbcGenericDao<Rieltor> implements RieltorDao {

    public JdbcRieltorDao(DataSource dataSource) {
        super(dataSource);
    }

    protected EntityMapper<Rieltor> getEntityMapper() {
        return new EntityMapper<Rieltor>() {

            @Override
            @SneakyThrows
            public Rieltor fromResultSet(ResultSet resultSet) {
                return Rieltor.builder().id(resultSet.getLong("id"))
                        .username(resultSet.getString("username"))
                        .password(resultSet.getString("password"))
                        .firstname(resultSet.getString("firstname"))
                        .lastname(resultSet.getString("lastname"))

                        .build();
            }


            @SneakyThrows
            public void fillStatement(PreparedStatement statement,
                                      Rieltor entity) {
                statement.setString(1, entity.getUsername());
                statement.setString(2, entity.getPassword());
                statement.setString(3, entity.getFirstname());
                statement.setString(4, entity.getLastname());

            }
        };
    }


    @Override
    protected String getUpdateSql() {
        return RieltorStrings.SQL_UPDATE;
    }

    @Override
    protected String getCreateSql() {
        return RieltorStrings.SQL_CREATE;
    }

    @Override
    protected String getDeleteSql() {
        return RieltorStrings.SQL_DELETE;
    }

    @Override
    public String getFindAllSql() {
        return RieltorStrings.SQL_FIND_ALL;
    }
    @Override
    protected String getFindByIdSql() {
        return RieltorStrings.SQL_FIND_BY_ID;
    }
}