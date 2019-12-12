package com.github.profnitt.bharatx.LoginActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.github.profnitt.bharatx.R;
import com.github.profnitt.bharatx.databinding.ActivityBusinessAccountInfoBinding;

public class BusinessAccountInfoActivity extends AppCompatActivity {
    final String DEBUG_TAG = "BusinessAccountInfo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityBusinessAccountInfoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_business_account_info);

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddBankAccountsActivity.class);
                startActivity(intent);
            }
        });

        binding.businessAccountSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(DEBUG_TAG,  String.valueOf(position));
                switch(position) {
                    case 1:
                        binding.businessAccountDetails.setVisibility(View.VISIBLE);
                        break;

                    case 0:
                        binding.businessAccountDetails.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                binding.businessAccountSpinner.setSelection(1);
            }
        });
    }
}
