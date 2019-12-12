package com.github.profnitt.bharatx.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.github.profnitt.bharatx.BankAccount.BankAccountDataSource;
import com.github.profnitt.bharatx.BankAccount.BankAccountData;
import com.github.profnitt.bharatx.BankAccount.BankAccountListAdapter;
import com.github.profnitt.bharatx.R;
import com.github.profnitt.bharatx.databinding.ActivityAddBankAccountsBinding;

import java.util.ArrayList;

public class AddBankAccountsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddBankAccountsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_bank_accounts);
        binding.banksList.setLayoutManager(new GridLayoutManager(this, 3));
        //TODO
        ArrayList<BankAccountData> bankAccountData = BankAccountDataSource.getAccountsOfUser("Shyam");
        BankAccountListAdapter bankAccountListAdapter = new BankAccountListAdapter(bankAccountData);
        binding.banksList.setAdapter(bankAccountListAdapter);
    }
}
