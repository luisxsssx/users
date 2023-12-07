package com.example.demousers.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demousers.Models.Budget;
import com.example.demousers.Repositoy.BudgetRepository;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public Budget saveBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Budget getCBudgetId(Long Id) {
        return budgetRepository.findById(Id).orElse(null);
    }

    public List<Budget> allBudget() {
        return (List<Budget>) budgetRepository.findAll();
    }

    public Budget updateBudget(Long Id, Budget updatBudget) {
        Budget budget = budgetRepository.findById(Id).orElse(null);
        if (budget == null) {
            return null;
        }

        budget.setName(updatBudget.getName());
        budget.setDescription(updatBudget.getDescription());
        budget.setCreationDate(updatBudget.getCreationDate());

        return updatBudget;
    }

    public void deleteBudget(Long Id) {
        budgetRepository.deleteById(Id);
    }
}