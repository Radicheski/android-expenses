package dev.radicheski.expenses;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {

    private ExpenseRepository repository;

    public ExpenseAdapter() {
        super();
        repository = ExpenseRepository.getInstance();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Expense expense = repository.get(position);
        holder.bind(expense);
    }

    @Override
    public int getItemCount() {
        return repository.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Expense expense) {
            Log.d("ExpenseAdapter", "bind: " + expense.toString());
        }
    }

}
