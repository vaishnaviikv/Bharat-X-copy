package com.github.profnitt.bharatx.LoginActivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;

import com.github.profnitt.bharatx.BankAccount.BankAccountDataSource;
import com.github.profnitt.bharatx.BankAccount.BankAccountData;
import com.github.profnitt.bharatx.BankAccount.BankAccountListAdapter;
import com.github.profnitt.bharatx.R;
import com.github.profnitt.bharatx.databinding.ActivityAddBankAccountsBinding;

import java.util.ArrayList;

public class AddBankAccountsActivity extends AppCompatActivity {

    ArrayList<BankAccountData> bankAccountData;
    BankAccountListAdapter bankAccountListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddBankAccountsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_bank_accounts);
        binding.banksList.setLayoutManager(new GridLayoutManager(this, 3));

        bankAccountData = BankAccountDataSource.getLocallySavedAccounts(this);
        bankAccountListAdapter = new BankAccountListAdapter(bankAccountData);
        binding.banksList.setAdapter(bankAccountListAdapter);
    }

    //TODO make this more efficient (maybe using LiveData)
    @Override
    protected void onResume() {
        super.onResume();
        bankAccountData.clear();
        bankAccountData.addAll(BankAccountDataSource.getLocallySavedAccounts(this));
        bankAccountListAdapter.notifyDataSetChanged();
    }
}
