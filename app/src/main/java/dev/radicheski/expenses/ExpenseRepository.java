package dev.radicheski.expenses;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
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

    public void add(Expense expense) {
        expenses.add(expense);
    }

    public void remove(Expense expense) {
        expenses.remove(expense);
    }

    public Expense get(int index) {
        return expenses.get(index);
    }

    public int size() {
        return expenses.size();
    }

    //FIXME Apagar depois que CRUD estiver completo
    private void initExpenses() {
        Expense expense1 = new Expense("Groceries", GregorianCalendar.getInstance().getTime(), new BigDecimal("50.00"), "Food");
        expenses.add(expense1);

        Expense expense2 = new Expense("Rent", GregorianCalendar.getInstance().getTime(), new BigDecimal("1200.00"), "Rent");
        expenses.add(expense2);

        Expense expense3 = new Expense("Gas", GregorianCalendar.getInstance().getTime(), new BigDecimal("30.00"), "Gas");
        expenses.add(expense3);

        Expense expense4 = new Expense("Internet", GregorianCalendar.getInstance().getTime(), new BigDecimal("100.00"), "Internet");
        expenses.add(expense4);

        Expense expense5 = new Expense("Electricity", GregorianCalendar.getInstance().getTime(), new BigDecimal("150.00"), "Electricity");
        expenses.add(expense5);

        Expense expense6 = new Expense("Groceries", GregorianCalendar.getInstance().getTime(), new BigDecimal("50.00"), "Food");
        expenses.add(expense6);

        Expense expense7 = new Expense("Rent", GregorianCalendar.getInstance().getTime(), new BigDecimal("1200.00"), "Rent");
        expenses.add(expense7);

        Expense expense8 = new Expense("Gas", GregorianCalendar.getInstance().getTime(), new BigDecimal("30.00"), "Gas");
        expenses.add(expense8);
    }
}
