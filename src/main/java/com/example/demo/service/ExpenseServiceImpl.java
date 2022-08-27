package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Expense;
import com.example.demo.repository.ExpenseRepository;


@Service
public class ExpenseServiceImpl implements ExpenseService {
    
	@Autowired
	private ExpenseRepository expenseRepo;
	
	@Override
	public Page<Expense> getAllExpenses(Pageable page) {
		return expenseRepo.findAll(page);
	}

	@Override
	public Expense getExpenseById(Long id) {
		Optional<Expense> expense = expenseRepo.findById(id);
		if(expense.isPresent())
		{
			return expense.get();
		}
		throw new RuntimeException("the Expense is not found for id" +id);
	}

	@Override
	public void deletExpenseById(Long id) {
		expenseRepo.deleteById(id);
	}

	@Override
	public Expense saveExpenseDetails(Expense expense) {
		return expenseRepo.save(expense);
		
	}

	
}
