package com.example.demousers.Repositoy;

import org.springframework.data.repository.CrudRepository;
import com.example.demousers.Models.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
}