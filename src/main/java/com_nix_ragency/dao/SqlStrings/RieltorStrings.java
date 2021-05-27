package com_nix_ragency.dao.SqlStrings;

public class RieltorStrings {
    public static final String SQL_FIND_BY_ID = "SELECT id, firstName,lastName, FROM rieltor  WHERE id = ?";

    public static final String SQL_CREATE = "INSERT INTO rieltor (username, password, firstName,lastName) VALUES (?, ?, ?,?)";

    public static final String SQL_UPDATE = "UPDATE rieltor  username = ?, password = ?, firstName =?, lastName =? WHERE id = ?";

    public static final String SQL_DELETE = "DELETE rieltor  WHERE id = ?";

    public static final String SQL_FIND_ALL = "SELECT id, username FROM rieltor ";

}
