package com.example.bmiapp.ui.benedict;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BenedictViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public BenedictViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}