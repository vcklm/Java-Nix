package com_nix_ragency.models;

public interface IUser {
    String getUsername();
    void setUsername(String username);

    String getPassword();
    void setPassword(String password);

    void setFirstname(String firstname);
    String getFirstname();

    void setLastname(String lastname);
    String getLastname();
}
