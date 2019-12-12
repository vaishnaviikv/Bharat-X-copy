package com.github.profnitt.bharatx.BankAccount;

import com.github.profnitt.bharatx.BankAccount.BankAccountData;

import java.util.ArrayList;

/*TODO: update this class with:
    an interface to fetch user's list of bank accounts
*/
public class BankAccountDataSource {
    //placeholder implementation
    public static ArrayList<BankAccountData> getAccountsOfUser(String user) {
        ArrayList<BankAccountData> bankAccountData = new ArrayList<>();
        bankAccountData.add(new BankAccountData("YesBank", "001"));
        bankAccountData.add(new BankAccountData("ABCBank", "002"));
        bankAccountData.add(new BankAccountData("ABCBank", "003"));
        bankAccountData.add(new BankAccountData("SBI", "004"));
        bankAccountData.add(new BankAccountData("SBI", "005"));
        return bankAccountData;
    }
}
