package com_nix_ragency.dao;

import com_nix_ragency.dao.SqlStrings.OrderStrings;
import com_nix_ragency.models.Order;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcOrderDao extends JdbcGenericDao<Order> implements OrderDao {

    public JdbcOrderDao(DataSource dataSource) {
        super(dataSource);
    }

    protected EntityMapper<Order> getEntityMapper() {
        return new EntityMapper<Order>() {
            @Override
            @SneakyThrows
            public Order fromResultSet(ResultSet resultSet) {
                return Order.builder().id(resultSet.getLong("id"))
                        .id(resultSet.getLong("clientId"))
                        .build();
            }
            @SneakyThrows
            public void fillStatement(PreparedStatement statement,
                                      Order entity) {
                statement.setLong(1, entity.getId());
            }
        };
    }

    @Override
    protected String getUpdateSql() {
        return OrderStrings.SQL_UPDATE;
    }

    @Override
    protected String getCreateSql() {
        return OrderStrings.SQL_CREATE;
    }

    @Override
    protected String getDeleteSql() {
        return OrderStrings.SQL_DELETE;
    }

    @Override
    public String getFindAllSql() {
        return OrderStrings.SQL_FIND_ALL;
    }

    @Override
    protected String getFindByIdSql() {
        return OrderStrings.SQL_FIND_BY_ID;
    }
}


