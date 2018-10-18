package com.pierrepiron.teachme.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.pierrepiron.teachme.R;
import com.pierrepiron.teachme.dto.model.Deposit;
import com.pierrepiron.teachme.dto.model.Product;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    private ArrayList<Product> productListFiltered;
    private String categorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        String depositJson = getIntent().getStringExtra(DepositActivity.OBJECT_PARAM);
        Gson gson = new Gson();
        ArrayList<Product> productList = gson.fromJson(depositJson, ArrayList.class);

        productListFiltered = filterProductForCurrentCategorie(productList);
        categorie = getIntent().getStringExtra(DepositActivity.CATEGORIE_NAME_PARAM);
    }

    private ArrayList<Product> filterProductForCurrentCategorie(ArrayList<Product> productList) {
        ArrayList<Product> list = new ArrayList<>();
        for (Product product : productList) {
            if (product.getCategorie() == categorie) {
                list.add(product);
            }
        }
        return list;
    }
}
