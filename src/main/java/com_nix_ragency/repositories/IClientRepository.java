package com_nix_ragency.repositories;

import com_nix_ragency.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client,Long> {

}
