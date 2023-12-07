package com.example.demousers.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demousers.Models.Budget;
import com.example.demousers.Repositoy.BudgetRepository;
import com.example.demousers.Service.BudgetService;

@Controller
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private BudgetService budgetService;

    @PostMapping("/add")
    public ResponseEntity<String> addNewBudgets(@RequestBody Budget budget) {
        try {
            budgetRepository.save(budget);
            return new ResponseEntity<>("Saved", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving budget", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Budget>> getAllBudget() {
        Iterable<Budget> budget = budgetRepository.findAll();
        return new ResponseEntity<>(budget, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable Long id, @RequestBody Budget BudgetClient) {
        Budget budget = budgetService.updateBudget(id, BudgetClient);
        if (budget == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(budget, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}