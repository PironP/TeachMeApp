package com.pierrepiron.teachme.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.pierrepiron.teachme.R;
import com.pierrepiron.teachme.dto.mainApi.ApiListener;
import com.pierrepiron.teachme.dto.mainApi.ApiProvider;
import com.pierrepiron.teachme.dto.model.Deposit;
import com.pierrepiron.teachme.dto.model.Product;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductListActivity extends AppCompatActivity {

    @BindView(R.id.product_recycler_list)
    RecyclerView recyclerView;

    @BindView(R.id.product_list_title)
    TextView productListTitle;

    @BindView(R.id.product_list_no_result_label)
    TextView noResultLabel;

    private ArrayList<Product> productListFiltered;
    private Deposit deposit;
    private int categorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        int depositId = getIntent().getIntExtra(DepositActivity.DEPOSIT_ID_PARAM, 0);
        categorie = getIntent().getIntExtra(DepositActivity.CATEGORIE_ID_PARAM, 0);

        getDeposit(depositId);


    }

    private void getDeposit(final int depositId) {
        ApiProvider apiProvider = new ApiProvider();
        apiProvider.getDeposit(depositId, new ApiListener<Deposit>() {
            @Override
            public void onSuccess(Deposit response) {
                deposit = response;
                filterProductForCurrentCategorie(deposit.getProductList());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    private void filterProductForCurrentCategorie(ArrayList<Product> productList) {
        ArrayList<Product> list = new ArrayList<>();
        for (Product product : productList) {
            if (product.getId_categorie() == categorie) {
                list.add(product);
            }
        }
        productListFiltered = list;
        loadView();
    }

    private void loadView() {
        ProductAdapter productAdapter = new ProductAdapter(productListFiltered);
        if (productListFiltered.size() > 0) {
            productListTitle.setText(productListFiltered.get(0).getCategorie());
        } else {
            noResultLabel.setVisibility(View.VISIBLE);
        }
        recyclerView.setAdapter(productAdapter);
    }
}
