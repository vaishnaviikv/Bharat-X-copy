package com.github.profnitt.bharatx.LoginActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.profnitt.bharatx.R;
import com.github.profnitt.bharatx.databinding.ActivityUserInfoBinding;

public class UserInfoActivity extends AppCompatActivity {
ActivityUserInfoBinding binding;
final int BusinessOptionIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_info);

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                if (binding.employmentStatus.getSelectedItemPosition() != BusinessOptionIndex)
                    intent = new Intent(getApplicationContext(), AddBankAccountsActivity.class);
                else
                    intent = new Intent(getApplicationContext(), BusinessAccountInfoActivity.class);

                startActivity(intent);
            }
        });
    }
}
