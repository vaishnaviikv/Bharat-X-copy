package com.github.profnitt.bharatx.BankAccount;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BankAccountDataDao {
    @Query("SELECT * FROM bank_accounts_data")
    List<BankAccountData> getAll();

    @Query("SELECT * FROM bank_accounts_data WHERE bank_name LIKE :bankName")
    List<BankAccountData> getBanksWithName(String bankName);

    @Insert
    void insert(BankAccountData accountData);

    @Delete
    void delete(BankAccountData accountData);
}