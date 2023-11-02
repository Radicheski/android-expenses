package dev.radicheski.expenses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExpenseRepository {

    private static ExpenseRepository instance;

    private List<Expense> expenses;

    private ExpenseRepository() {
        expenses = new ArrayList<>();
        initExpenses(); //FIXME Apagar depois que CRUD estiver completo
    }

    public static ExpenseRepository getInstance() {
        if (Objects.isNull(instance))
            instance = new ExpenseRepository();
        return instance;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void removeExpense(Expense expense) {
        expenses.remove(expense);
    }

    //FIXME Apagar depois que CRUD estiver completo
    private void initExpenses() {
        Expense expense1 = new Expense("Groceries", LocalDateTime.now(), new BigDecimal("50.00"), "Food");
        expenses.add(expense1);

        Expense expense2 = new Expense("Rent", LocalDateTime.now(), new BigDecimal("1200.00"), "Rent");
        expenses.add(expense2);

        Expense expense3 = new Expense("Gas", LocalDateTime.now(), new BigDecimal("30.00"), "Gas");
        expenses.add(expense3);

        Expense expense4 = new Expense("Internet", LocalDateTime.now(), new BigDecimal("100.00"), "Internet");
        expenses.add(expense4);

        Expense expense5 = new Expense("Electricity", LocalDateTime.now(), new BigDecimal("150.00"), "Electricity");
        expenses.add(expense5);

        Expense expense6 = new Expense("Groceries", LocalDateTime.now(), new BigDecimal("50.00"), "Food");
        expenses.add(expense6);

        Expense expense7 = new Expense("Rent", LocalDateTime.now(), new BigDecimal("1200.00"), "Rent");
        expenses.add(expense7);

        Expense expense8 = new Expense("Gas", LocalDateTime.now(), new BigDecimal("30.00"), "Gas");
        expenses.add(expense8);
    }
}
