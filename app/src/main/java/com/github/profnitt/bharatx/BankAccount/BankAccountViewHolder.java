package com.github.profnitt.bharatx.BankAccount;

import androidx.recyclerview.widget.RecyclerView;

import com.github.profnitt.bharatx.BankAccount.BankAccountData;
import com.github.profnitt.bharatx.R;
import com.github.profnitt.bharatx.databinding.LayoutBankAccountIconBinding;

public class BankAccountViewHolder extends RecyclerView.ViewHolder {
    private LayoutBankAccountIconBinding binding;

    public BankAccountViewHolder(LayoutBankAccountIconBinding binding) {
        super (binding.getRoot());
        this.binding = binding;
    }

    public void updateView(BankAccountData bankData) {
        if (bankData.accountNumber.equals("RESERVED") && bankData.bankName.equals("RESERVED")) {
            binding.bankLogo.setImageDrawable(binding.getRoot().getContext().getResources().getDrawable(R.drawable.icon_add));
            binding.bankName.setText("Add an account");
        }
        else {
            //TODO: update logo as well
            binding.bankName.setText(bankData.bankName);
        }

    }
}
