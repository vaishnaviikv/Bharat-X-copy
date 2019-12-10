package com.github.profnitt.bharatx;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OTPViewModel extends ViewModel {
    private MutableLiveData<String> OTPText = new MutableLiveData<>();
    private MutableLiveData<Integer> focusedInput = new MutableLiveData<>();

    public LiveData<String> getOTPText() {
        return OTPText;
    }

    public void setOTPText(String a) {
        if (a.length() >= 4)
            OTPText.setValue(a.substring(0,4));
        else
            OTPText.setValue(
                    String.format("%-4s",a)
            );
    }

    public OTPViewModel() {
        setOTPText("");
        focusedInput.setValue(-1);
    }

    public void setFocusedInput(int x) {
        focusedInput.setValue(x);
    }

    public LiveData<Integer> getFocusedInput() {
        return focusedInput;
    }

    //TODO: implement a SMS scanning feature here
}
