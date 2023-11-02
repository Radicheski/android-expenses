package dev.radicheski.expenses;

import java.math.BigDecimal;
import java.util.Date;

public class Expense {
    private String description;
    private Date date;
    private BigDecimal amount;
    private String category;

    public Expense(String description, Date date, BigDecimal amount, String category) {
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
