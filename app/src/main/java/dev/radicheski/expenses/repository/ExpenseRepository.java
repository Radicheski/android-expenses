package dev.radicheski.expenses.repository;

import java.util.ArrayList;
import java.util.List;

import dev.radicheski.expenses.Expense;

public class ExpenseRepository {

    List<Expense> expenses;

    ExpenseRepository() {
        expenses = new ArrayList<>();
    }

    public void remove(int index) {
        expenses.remove(index);
    }

    public Expense get(int index) {
        return expenses.get(index);
    }

    public int size() {
        return expenses.size();
    }
}
