package com.github.profnitt.bharatx.BankAccount;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.github.profnitt.bharatx.R;
import com.github.profnitt.bharatx.databinding.LayoutBankAccountIconBinding;

import java.util.ArrayList;

public class BankAccountListAdapter extends RecyclerView.Adapter<BankAccountViewHolder> {
    private ArrayList<BankAccountData> accounts;

    public BankAccountListAdapter(ArrayList<BankAccountData> _accounts) {
        accounts = _accounts;
    }

    @NonNull
    @Override
    public BankAccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lf = LayoutInflater.from(parent.getContext());
        LayoutBankAccountIconBinding binding = DataBindingUtil.inflate(lf, R.layout.layout_bank_account_icon, parent, false);
        return new BankAccountViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BankAccountViewHolder holder, int position) {
        if (position < accounts.size())
            holder.updateView(accounts.get(position));
        else {
            holder.updateView(new BankAccountData("RESERVED", "RESERVED"));
        }
    }

    @Override
    public int getItemCount() {
        return accounts.size() + 1;
    }
}
