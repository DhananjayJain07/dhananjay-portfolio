package com.dhananjay.expenseapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 120)
    private String title;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;
    @Column(nullable = false, length = 40)
    private String category;
    @Column(name = "expense_date", nullable = false)
    private LocalDate expenseDate;
    @Column(length = 500)
    private String notes;

    protected Expense() {}
    public Expense(String title, BigDecimal amount, String category, LocalDate expenseDate, String notes) {
        this.title = title; this.amount = amount; this.category = category;
        this.expenseDate = expenseDate; this.notes = notes;
    }
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public LocalDate getExpenseDate() { return expenseDate; }
    public void setExpenseDate(LocalDate expenseDate) { this.expenseDate = expenseDate; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}