package com.pierrepiron.teachme.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pierrepiron.teachme.R;
import com.pierrepiron.teachme.dto.model.Deposit;

public class ProductListActivity extends AppCompatActivity {

    private Deposit deposit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        deposit = getIntent().getParcelableExtra(DepositActivity.OBJECT_PARAM);

        String categorie = getIntent().getStringExtra(DepositActivity.CATEGORIE_NAME_PARAM);
    }
}
