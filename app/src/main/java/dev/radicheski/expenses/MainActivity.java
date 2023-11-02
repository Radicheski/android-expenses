package dev.radicheski.expenses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        ExpenseAdapter adapter = new ExpenseAdapter();
        adapter.swipeCallback.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapter);
        ExpenseEditor editor = new ExpenseEditor();
        adapter.setEditor(editor);
    }

    public class ExpenseEditor {

        public void edit(Expense expense, Runnable onCompletion) {
            Intent intent = new Intent(getBaseContext(), ExpenseEdit.class);
            intent.putExtra("expense", expense);

            startActivity(intent);

            if (Objects.nonNull(onCompletion)) onCompletion.run();
        }

    }

}