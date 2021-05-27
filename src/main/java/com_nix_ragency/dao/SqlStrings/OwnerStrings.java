package com_nix_ragency.dao.SqlStrings;

public class OwnerStrings {
    public static final String SQL_FIND_BY_ID = "SELECT id, firstName,lastName, FROM owner WHERE id = ?";

    public static final String SQL_CREATE = "INSERT INTO owner (username, password, firstName,lastName,email) VALUES (?, ?, ?,?,?)";

    public static final String SQL_UPDATE = "UPDATE owner username = ?, password = ?, firstName =?, lastName =?,email=? WHERE id = ?";

    public static final String SQL_DELETE = "DELETE owner  WHERE id = ?";

    public static final String SQL_FIND_ALL = "SELECT id, username FROM owner";
}
