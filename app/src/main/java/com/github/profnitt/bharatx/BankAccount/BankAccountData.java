package com.github.profnitt.bharatx.BankAccount;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bank_accounts_data")
public class BankAccountData {
    @PrimaryKey(autoGenerate = true)
    public int index;

    @ColumnInfo(name="bank_name")
    public String bankName;

    @ColumnInfo(name="account_number")
    public String accountNumber;

    public BankAccountData() {

    }

    public BankAccountData(String _bankName, String _accountNumber) {
        bankName = _bankName;
        accountNumber = _accountNumber;
    }
}