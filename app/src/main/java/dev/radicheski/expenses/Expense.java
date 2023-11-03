package dev.radicheski.expenses;

import android.util.Log;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

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
        private static DateFormat dateFormat;
        private static NumberFormat numberFormat;

        static {
            dateFormat = DateFormat.getDateInstance();

            numberFormat = NumberFormat.getNumberInstance(Locale.US);
            numberFormat.setMinimumFractionDigits(2);
            numberFormat.setMaximumFractionDigits(2);
        }

        private final Expense expense;

        private ViewModel(Expense expense) {
            this.expense = expense;
        }


        public String getDescription() {
            return expense.getDescription();
        }

        public void setDescription(String description) {
            expense.setDescription(description);
        }

        public String getDate() {
            return dateFormat.format(expense.getDate());
        }

        public void setDate(String date) {
            try {
                Date newDate = dateFormat.parse(date);
                expense.setDate(newDate);
            } catch (ParseException e) {
                Log.e("Expense.ViewModel", "Failed to parse date",  e);
            }
        }

        public String getAmount() {
            return numberFormat.format(expense.getAmount());
        }

        public void setAmount(String amount) {
            BigDecimal newAmount = new BigDecimal(amount.replaceAll("[^0-9.]", ""));
            expense.setAmount(newAmount);
        }

        public String getCategory() {
            return expense.getCategory();
        }

        public void setCategory(String category) {
            expense.setCategory(category);
        }

    }

}
