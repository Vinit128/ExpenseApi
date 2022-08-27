package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Expense;
import com.example.demo.service.ExpenseService;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses(Pageable page) {
		return expenseService.getAllExpenses(page).toList();
	}
	
	@GetMapping("/expenses/{id}")
	public Expense getExpenseById(@PathVariable("id") Long id) {
		return expenseService.getExpenseById(id);
	}
	
	
	
	@DeleteMapping("/expenses")
	public void deletExpenseById(@RequestParam("id") Long id) {
		expenseService.deletExpenseById(id);
	}
	
	@PostMapping("/expenses")
	public Expense saveExpenseDetails(@Valid @RequestBody Expense expense) {
		
		return expenseService.saveExpenseDetails(expense);
	}
	
	
	
}


// the Get Mapping is using Path Variable - path variable is dynamic 

// the Delete mapping is using QueryString /Request Param    
// the URL is   http:localhost:8080/ExpenseManagerApi/expenses?id=2   when we are giving 2 a id  