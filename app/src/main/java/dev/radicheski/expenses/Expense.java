package dev.radicheski.expenses;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

public class Expense implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public ViewModel toViewModel() {
        return new ViewModel(this);
    }

    public static class ViewModel {
        private DateFormat dateFormat = DateFormat.getDateInstance();
        private NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

        private final Expense expense;

        private ViewModel(Expense expense) {
            this.expense = expense;
        }


        public String getDescription() {
            return expense.getDescription();
        }


        public String getDate() {
            return dateFormat.format(expense.getDate());
        }


        public String getAmount() {
            return numberFormat.format(expense.getAmount());
        }

        public String getCategory() {
            return expense.getCategory();
        }

    }

}
