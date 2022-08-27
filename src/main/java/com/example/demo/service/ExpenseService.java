package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Expense;

public interface ExpenseService {

	Page<Expense> getAllExpenses(Pageable page);

	Expense getExpenseById(Long id);

	void deletExpenseById(Long id);

	Expense saveExpenseDetails(Expense expense);
	
	
}
