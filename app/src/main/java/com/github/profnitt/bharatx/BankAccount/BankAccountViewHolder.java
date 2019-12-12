package com.github.profnitt.bharatx.BankAccount;

import android.content.Intent;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.github.profnitt.bharatx.LoginActivities.AddNewBankAccountActivity;
import com.github.profnitt.bharatx.R;
import com.github.profnitt.bharatx.databinding.LayoutBankAccountIconBinding;


public class BankAccountViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private LayoutBankAccountIconBinding binding;

    public BankAccountViewHolder(LayoutBankAccountIconBinding binding) {
        super (binding.getRoot());
        this.binding = binding;
        binding.getRoot().setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        LayoutBankAccountIconBinding binding = DataBindingUtil.getBinding(v);
        if (binding.bankName.getText().toString().equalsIgnoreCase("Add an account")) {
            Intent intent = new Intent(v.getContext(), AddNewBankAccountActivity.class);
            v.getContext().startActivity(intent);
        }
    }
}
