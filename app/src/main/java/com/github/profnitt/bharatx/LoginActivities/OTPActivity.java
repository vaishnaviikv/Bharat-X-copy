package com.github.profnitt.bharatx.LoginActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.profnitt.bharatx.OTPViewModel;
import com.github.profnitt.bharatx.R;
import com.github.profnitt.bharatx.databinding.ActivityOtpBinding;

public class OTPActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {
    ActivityOtpBinding binding;
    OTPViewModel otpViewModel;
    boolean canInputOTP = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_otp);
        otpViewModel = ViewModelProviders.of(this).get(OTPViewModel.class);

        binding.setOtpViewModel(otpViewModel);
        binding.setLifecycleOwner(this);

        binding.prevButton.setOnClickListener(new View.OnClickListener() {
            private int i = 1000;
            @Override
            public void onClick(View v) {
                i++;
                otpViewModel.setOTPText(String.valueOf(i));
            }
        });

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyOTP();
            }
        });

        binding.otpInput.inputOne.setOnClickListener(this);
        binding.otpInput.inputTwo.setOnClickListener(this);
        binding.otpInput.inputThree.setOnClickListener(this);
        binding.otpInput.inputFour.setOnClickListener(this);

        binding.otpInput.hiddenOtpText.setOnKeyListener(this);
    }

    @Override
    public void onClick(View v) {
        if (canInputOTP) {
            otpViewModel.setOTPText("");
            binding.otpInput.hiddenOtpText.setText("");
            binding.otpInput.hiddenOtpText.requestFocus();
            showSoftKeyboard(binding.otpInput.hiddenOtpText);
            otpViewModel.setFocusedInput(0);

            binding.textView.setText(R.string.input_otp, TextView.BufferType.NORMAL);
            //TODO: stop scanning SMS for OTP process here
        }
    }

    void hideSoftKeyboard(EditText e) {
        InputMethodManager im = (InputMethodManager) getSystemService(Service.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(e.getWindowToken(), 0);
    }

    void showSoftKeyboard(EditText e) {
        InputMethodManager im = (InputMethodManager) getSystemService(Service.INPUT_METHOD_SERVICE);
        im.showSoftInput(e, 0);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (v.getId() == R.id.hiddenOtpText) {
            otpViewModel.setOTPText(binding.otpInput.hiddenOtpText.getText().toString());
            otpViewModel.setFocusedInput(binding.otpInput.hiddenOtpText.getText().toString().length());

            if (binding.otpInput.hiddenOtpText.getText().toString().length() == 4) {
                hideSoftKeyboard((EditText) v);
                verifyOTP();
            }
        }
        return false;
    }

    void applyInactiveBackground(EditText e){
        if (e != null)
            e.setBackground(getResources().getDrawable(R.drawable.edit_text_disabled_background));
    }

    void applyDefaultBackground(EditText e) {
        if (e != null)
            e.setBackground(getResources().getDrawable(R.drawable.edit_text_default_background));
    }

    void disableOTPInput() {
        applyInactiveBackground(binding.otpInput.inputOne);
        applyInactiveBackground(binding.otpInput.inputTwo);
        applyInactiveBackground(binding.otpInput.inputThree);
        applyInactiveBackground(binding.otpInput.inputFour);

        canInputOTP = false;
    }

    void enableOTPInput() {
        applyDefaultBackground(binding.otpInput.inputOne);
        applyDefaultBackground(binding.otpInput.inputTwo);
        applyDefaultBackground(binding.otpInput.inputThree);
        applyDefaultBackground(binding.otpInput.inputFour);

        canInputOTP = true;
    }

    void verifyOTP() {
        //disabling OTP input until OTP is completely verified
        disableOTPInput();

        //basic verification of length of OTP
        if (otpViewModel.getOTPText().getValue().trim().length() != 4) {
            Toast.makeText(getApplicationContext(), "Please enter 4 digit OTP Pin", Toast.LENGTH_SHORT).show();
            enableOTPInput();
            return;
        }

        //TODO: implement OTP verification

        enableOTPInput();
        Toast.makeText(getApplicationContext(), "OTP Verified successfully", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), UserInfoActivity.class);
        startActivity(intent);
    }
}
