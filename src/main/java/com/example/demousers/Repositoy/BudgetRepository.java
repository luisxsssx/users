package com.example.demousers.Repositoy;

import org.springframework.data.repository.CrudRepository;
import com.example.demousers.Models.Budget;

public interface BudgetRepository extends CrudRepository<Budget, Long> {

}