package com.github.profnitt.bharatx.BankAccount;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {BankAccountData.class}, version = 1)
public abstract class BankAccountDataDatabase extends RoomDatabase {
    public abstract BankAccountDataDao bankAccountDataDao();
}
