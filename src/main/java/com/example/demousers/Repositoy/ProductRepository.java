package com.example.demousers.Repositoy;

import org.springframework.data.repository.CrudRepository;

import com.example.demousers.Models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}