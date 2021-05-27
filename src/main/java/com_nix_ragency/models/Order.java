package com_nix_ragency.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="Order")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements IEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="idClient")
    private Client client;
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name="idRieltor")
    private Rieltor rieltor;
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name="idFlat")
    private Flat flat;
}
