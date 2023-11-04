package dev.radicheski.expenses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.airbnb.lottie.LottieAnimationView;

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

        public void edit(int expense) {
            Intent intent = new Intent(getBaseContext(), ExpenseEdit.class);
            intent.putExtra("expense", expense);

            showAnimation(() -> startActivity(intent));
        }

    }

    private void showAnimation(Runnable nextAction) {
        View popupAnimation = getLayoutInflater().inflate(R.layout.popup_animation, null);
        PopupWindow window = new PopupWindow(popupAnimation,
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        window.showAtLocation(recyclerView, Gravity.CENTER, 0, 0);

        LottieAnimationView lottieView = popupAnimation.findViewById(R.id.animation_view);
        lottieView.setRepeatCount(5);
        lottieView.setAnimation(R.raw.loading);
        lottieView.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                window.dismiss();
                if (Objects.nonNull(nextAction)) nextAction.run();
            }
        });
        lottieView.playAnimation();
    }

}