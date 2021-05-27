package com_nix_ragency.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name="flat")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flat implements IEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name="idOwner")
    private Owner owner;
    private String city;
    private String address;
    private BigDecimal price;
}
