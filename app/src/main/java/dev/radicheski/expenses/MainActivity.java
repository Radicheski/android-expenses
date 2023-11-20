package dev.radicheski.expenses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
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

    public void showAnimation(Runnable nextAction) {
        View popupAnimation = getLayoutInflater().inflate(R.layout.popup_animation, null);
        PopupWindow window = new PopupWindow(popupAnimation,
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        window.showAtLocation(recyclerView, Gravity.CENTER, 0, 0);

        LottieAnimationView lottieView = popupAnimation.findViewById(R.id.animation_view);
        lottieView.setAnimation(R.raw.loading2);
        lottieView.setRepeatCount(3);

        lottieView.setSpeed(3);
        lottieView.setScaleX(0.5f);
        lottieView.setScaleY(0.5f);
        lottieView.addValueCallback(new KeyPath("**"),
                LottieProperty.COLOR_FILTER,
                frameInfo -> new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP));
        lottieView.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (Objects.nonNull(nextAction)) nextAction.run();
                window.dismiss();
            }
        });
    }

}
