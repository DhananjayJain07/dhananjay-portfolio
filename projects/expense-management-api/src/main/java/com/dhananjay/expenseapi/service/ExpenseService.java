package com.dhananjay.expenseapi.service;

import com.dhananjay.expenseapi.dto.ExpenseRequest;
import com.dhananjay.expenseapi.exception.ExpenseNotFoundException;
import com.dhananjay.expenseapi.model.Expense;
import com.dhananjay.expenseapi.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ExpenseService {
    private final ExpenseRepository repository;
    public ExpenseService(ExpenseRepository repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Expense> list(String category, LocalDate from, LocalDate to) {
        if (from != null && to != null && from.isAfter(to))
            throw new IllegalArgumentException("'from' must be on or before 'to'");
        if (category != null && !category.isBlank() && from == null && to == null)
            return repository.findByCategoryIgnoreCase(category);
        if (from != null && to != null) return repository.findByExpenseDateBetween(from, to);
        return repository.findAll();
    }
    @Transactional(readOnly = true)
    public Expense get(Long id) { return repository.findById(id).orElseThrow(() -> new ExpenseNotFoundException(id)); }
    public Expense create(ExpenseRequest request) { return repository.save(map(request, new Expense(request.title(), request.amount(), request.category(), request.expenseDate(), request.notes()))); }
    public Expense update(Long id, ExpenseRequest request) {
        Expense existing = get(id);
        return repository.save(map(request, existing));
    }
    public void delete(Long id) { repository.delete(get(id)); }
    private Expense map(ExpenseRequest r, Expense e) {
        e.setTitle(r.title()); e.setAmount(r.amount()); e.setCategory(r.category());
        e.setExpenseDate(r.expenseDate()); e.setNotes(r.notes()); return e;
    }
}