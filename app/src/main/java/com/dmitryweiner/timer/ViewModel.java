package com.dmitryweiner.timer;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class ViewModel extends BaseObservable {
    private int counter;

    @Bindable
    public String getCounter() {
        return String.valueOf(counter);
    }

    public void incrementCounter() {
        counter++;
        notifyPropertyChanged(BR.counter);
    }

    public void resetCounter(View view) {
        counter = 0;
        notifyPropertyChanged(BR.counter);
    }
}
