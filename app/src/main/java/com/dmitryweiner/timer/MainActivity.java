package com.dmitryweiner.timer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dmitryweiner.timer.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private boolean isRunning = false;
    final ViewModel viewModel = new ViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);

        Button buttonStart = findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(view -> isRunning = true);
        Button buttonStop = findViewById(R.id.buttonStop);
        buttonStop.setOnClickListener(view -> isRunning = false);
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 1000, 1000);
    }

    class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(() -> {
                if (isRunning) {
                    viewModel.incrementCounter();
                }
            });
        }
    }
}