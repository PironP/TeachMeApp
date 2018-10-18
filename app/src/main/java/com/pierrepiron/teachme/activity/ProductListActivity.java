package com.pierrepiron.teachme.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.pierrepiron.teachme.R;
import com.pierrepiron.teachme.dto.model.Deposit;

public class ProductListActivity extends AppCompatActivity {

    private Deposit deposit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        String depositJson = getIntent().getStringExtra(DepositActivity.OBJECT_PARAM);
        Gson gson = new Gson();
        deposit = gson.fromJson(depositJson, Deposit.class);

        String categorie = getIntent().getStringExtra(DepositActivity.CATEGORIE_NAME_PARAM);
    }
}
