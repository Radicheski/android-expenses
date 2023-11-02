package dev.radicheski.expenses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Objects;
import java.util.function.Consumer;

import dev.radicheski.expenses.repository.ExpenseRepository;
import dev.radicheski.expenses.repository.MockedExpenseRepository;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {

    private MainActivity.ExpenseEditor editor;
    private ExpenseRepository repository;
    public final ItemTouchHelper swipeCallback = new ItemTouchHelper(new SwipeCallback());

    public ExpenseAdapter() {
        super();
        repository = MockedExpenseRepository.getInstance();
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

    public void setEditor(MainActivity.ExpenseEditor editor) {
        this.editor = editor;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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

            itemView.setOnClickListener(this);
        }

        public void bind(Expense expense) {
            Expense.ViewModel viewModel = expense.toViewModel();

            description.setText(viewModel.getDescription());
            date.setText(viewModel.getDate());
            amount.setText(viewModel.getAmount());
            category.setText(viewModel.getCategory());
        }

        @Override
        public void onClick(View v) {
            if (Objects.isNull(editor)) return;

            int position = getAdapterPosition();
            Expense expense = repository.get(position);
            editor.edit(expense, () -> notifyItemChanged(position));
        }
    }

    private class SwipeCallback extends ItemTouchHelper.Callback {

        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.8f;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            repository.remove(position);
            notifyItemRemoved(position);
        }

    }

}
