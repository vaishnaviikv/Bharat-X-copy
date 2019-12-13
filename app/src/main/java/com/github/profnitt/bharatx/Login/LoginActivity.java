package com.github.profnitt.bharatx.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.profnitt.bharatx.R;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText EditTextPhone;
    Button mButton ;
    String codeSent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mButton= findViewById(R.id.sendOTPButton);
        mAuth = FirebaseAuth.getInstance();

        EditTextPhone = findViewById(R.id.phone);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOTP();
                Intent intent = new Intent(getApplicationContext(), OTPActivity.class);
                startActivity(intent);
            }
        });

    }
    private void sendOTP(){

        String phone = EditTextPhone.getText().toString();

        if(phone.isEmpty()){
            EditTextPhone.setError("Phone number is required");
            EditTextPhone.requestFocus();
            return;
        }

        if(phone.length() < 10 ){
            EditTextPhone.setError("Please enter a valid phone");
            EditTextPhone.requestFocus();
            return;
        }

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
    }


    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override

        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            codeSent = s;
        }
    };

}
