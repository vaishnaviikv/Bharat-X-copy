package com.github.profnitt.bharatx.LoginActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.profnitt.bharatx.BankAccount.BankAccountData;
import com.github.profnitt.bharatx.BankAccount.BankAccountDataDao_Impl;
import com.github.profnitt.bharatx.BankAccount.BankAccountDataSource;
import com.github.profnitt.bharatx.R;
import com.github.profnitt.bharatx.databinding.ActivityAddBankAccountsBinding;
import com.github.profnitt.bharatx.databinding.ActivityAddNewBankAccountBinding;

public class AddNewBankAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityAddNewBankAccountBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_bank_account);
        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BankAccountData data = new BankAccountData();
                data.accountNumber = binding.accountNumberEdittext.getText().toString();
                data.bankName = binding.bankNameEdittext.getText().toString();

                BankAccountDataSource.addAccount(getApplicationContext(), data);

                finish();
            }
        });
    }


}
