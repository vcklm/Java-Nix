package com_nix_ragency.dao.SqlStrings;

public class ClientStrings {
    public static final String SQL_FIND_BY_ID = "SELECT id, firstName,lastName, FROM client WHERE id = ?";

    public static final String SQL_CREATE = "INSERT INTO client (username, password, firstName,lastName) VALUES (?, ?, ?,?)";

    public static final String SQL_UPDATE = "UPDATE client username = ?, password = ?, firstName =?, lastName =? WHERE id = ?";

    public static final String SQL_DELETE = "DELETE client WHERE id = ?";

    public static final String SQL_FIND_ALL = "SELECT id, username FROM client";

}
