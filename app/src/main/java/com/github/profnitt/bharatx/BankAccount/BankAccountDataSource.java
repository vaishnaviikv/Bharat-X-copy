package com.github.profnitt.bharatx.BankAccount;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;

public class BankAccountDataSource {
    private static BankAccountDataDatabase db = null;

    private static void getDbInstance(Context context) {
        if (db == null)
            db = Room.databaseBuilder(context, BankAccountDataDatabase.class, "sampleDatabase").allowMainThreadQueries().build();
    }

    //placeholder implementation
    public static ArrayList<BankAccountData> getLocallySavedAccounts(Context context) {
        getDbInstance(context);
        return  new ArrayList<>(db.bankAccountDataDao().getAll());
    }

    public static void addAccount(Context context, BankAccountData bankAccountData) {
        getDbInstance(context);
        db.bankAccountDataDao().insert(bankAccountData);
    }
}
