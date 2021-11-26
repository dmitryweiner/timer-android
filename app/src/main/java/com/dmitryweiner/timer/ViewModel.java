package com.dmitryweiner.timer;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class ViewModel extends BaseObservable {
    private int counter;

    @Bindable
    public int getCounter() {
        return counter;
    }

    public void setCounter(int value) {
        if (counter != value) {
            counter = value;
            notifyPropertyChanged(BR.counter);
        }
    }

    public void resetCounter() {
        counter = 0;
    }
}
