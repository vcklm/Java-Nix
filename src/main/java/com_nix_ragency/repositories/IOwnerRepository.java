package com_nix_ragency.repositories;

import com_nix_ragency.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOwnerRepository extends JpaRepository<Owner,Long> {
}
