package com_nix_ragency.repositories;

import com_nix_ragency.models.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlatRepository extends JpaRepository<Flat,Long> {
}
