package com_nix_ragency.dao.SqlStrings;

public class OrderStrings {
    public static final String SQL_FIND_BY_ID = "SELECT id,clientId  FROM order WHERE id = ?";

    public static final String SQL_CREATE = "INSERT INTO order (description,ownerId,rieltorid,flatId) VALUES (?, ?,?,?)";

    public static final String SQL_UPDATE = "UPDATE order clientId WHERE id = ?";

    public static final String SQL_DELETE = "DELETE order  WHERE id = ?";

    public static final String SQL_FIND_ALL = "SELECT id,clientId FROM order";
}
