package dev.radicheski.expenses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Expense {
    private String description;
    private LocalDateTime datetime;
    private BigDecimal amount;
    private String category;

    public Expense(String description, LocalDateTime datetime, BigDecimal amount, String category) {
        this.description = description;
        this.datetime = datetime;
        this.amount = amount;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
