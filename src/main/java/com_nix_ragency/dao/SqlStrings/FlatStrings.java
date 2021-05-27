package com_nix_ragency.dao.SqlStrings;

public class FlatStrings {
    public static final String SQL_FIND_BY_ID = "SELECT id, address FROM flat WHERE id = ?";

    public static final String SQL_CREATE = "INSERT INTO flat (address, city, price,idOwner) VALUES (?,? ?, ?)";

    public static final String SQL_UPDATE = "UPDATE flat address = ?,  city = ?,price=?, idOwner =? WHERE id = ?";

    public static final String SQL_DELETE = "DELETE  flat WHERE id = ?";

    public static final String SQL_FIND_ALL = "SELECT id, address FROM flat";
}
