package dev.radicheski.expenses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.NumberFormat;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {

    private ExpenseRepository repository;

    public ExpenseAdapter() {
        super();
        repository = ExpenseRepository.getInstance();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense, parent, false);
        return new ViewHolder(view);
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

        private static DateFormat dateFormat = DateFormat.getDateInstance();
        private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        private TextView description;
        private TextView date;
        private TextView amount;
        private TextView category;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);
            amount = itemView.findViewById(R.id.amount);
            category = itemView.findViewById(R.id.category);
        }

        public void bind(Expense expense) {
            description.setText(expense.getDescription());
            date.setText(dateFormat.format(expense.getDate()));
            amount.setText(currencyFormat.format(expense.getAmount()));
            category.setText(expense.getCategory());
        }
    }

}
