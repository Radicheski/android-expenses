package dev.radicheski.expenses.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

import dev.radicheski.expenses.Expense;

public class MockedExpenseRepository extends ExpenseRepository {

    private static MockedExpenseRepository instance;

    private MockedExpenseRepository() {
        super();
        expenses = new ArrayList<>(List.of(
                new Expense("Groceries", GregorianCalendar.getInstance().getTime(), new BigDecimal("50.00"), "Food"),
                new Expense("Rent", GregorianCalendar.getInstance().getTime(), new BigDecimal("1200.00"), "Rent"),
                new Expense("Gas", GregorianCalendar.getInstance().getTime(), new BigDecimal("30.00"), "Gas"),
                new Expense("Internet", GregorianCalendar.getInstance().getTime(), new BigDecimal("100.00"), "Internet"),
                new Expense("Electricity", GregorianCalendar.getInstance().getTime(), new BigDecimal("150.00"), "Electricity"),
                new Expense("Groceries", GregorianCalendar.getInstance().getTime(), new BigDecimal("50.00"), "Food"),
                new Expense("Rent", GregorianCalendar.getInstance().getTime(), new BigDecimal("1200.00"), "Rent"),
                new Expense("Gas", GregorianCalendar.getInstance().getTime(), new BigDecimal("30.00"), "Gas"),
                new Expense("Internet", GregorianCalendar.getInstance().getTime(), new BigDecimal("100.00"), "Internet"),
                new Expense("Electricity", GregorianCalendar.getInstance().getTime(), new BigDecimal("150.00"), "Electricity")
        ));
    }

    public static MockedExpenseRepository getInstance() {
        if (Objects.isNull(instance))
            instance = new MockedExpenseRepository();
        return instance;
    }

}
