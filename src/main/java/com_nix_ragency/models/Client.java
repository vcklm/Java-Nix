package com_nix_ragency.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="Client")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client implements IEntity,IUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
}
