package dev.radicheski.expenses;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class ExpenseEdit extends Activity {

    private TextInputLayout description;
    private TextInputLayout date;
    private TextInputLayout amount;
    private TextInputLayout category;

    private Button save;

    private Expense.ViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expense_edit);

        description = findViewById(R.id.description);
        date = findViewById(R.id.date);
        amount = findViewById(R.id.amount);
        category = findViewById(R.id.category);

        save = findViewById(R.id.save);
        save.setOnClickListener(this::save);

        Bundle extras = getIntent().getExtras();
        if (Objects.nonNull(extras))  {
            Expense expense = (Expense) extras.getSerializable("expense");
            viewModel = expense.toViewModel();

            description.getEditText().setText(viewModel.getDescription());
            date.getEditText().setText(viewModel.getDate());
            amount.getEditText().setText(viewModel.getAmount());
            category.getEditText().setText(viewModel.getCategory());
        }
    }

    private void save(View view) {
        if (Objects.nonNull(viewModel)){
            viewModel.setDescription(description.getEditText().getText().toString());
            viewModel.setDate(date.getEditText().getText().toString());
            viewModel.setAmount(amount.getEditText().getText().toString());
            viewModel.setCategory(category.getEditText().getText().toString());
        }
        finish();
    }

}
