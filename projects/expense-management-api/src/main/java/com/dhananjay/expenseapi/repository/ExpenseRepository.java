package com.dhananjay.expenseapi.repository;

import com.dhananjay.expenseapi.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByCategoryIgnoreCase(String category);
    List<Expense> findByExpenseDateBetween(LocalDate from, LocalDate to);
}