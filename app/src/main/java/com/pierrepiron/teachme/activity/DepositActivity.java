package com.pierrepiron.teachme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.google.gson.Gson;
import com.pierrepiron.teachme.R;
import com.pierrepiron.teachme.dto.mainApi.ApiListener;
import com.pierrepiron.teachme.dto.mainApi.ApiProvider;
import com.pierrepiron.teachme.dto.model.Deposit;
import com.pierrepiron.teachme.dto.model.Product;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DepositActivity extends AppCompatActivity {

    private Deposit deposit;
    private ArrayList<String> categoryList = new ArrayList<>();
    private int[] productByCategorie = new int[10];
    public static final String DEPOSIT_ID_PARAM = "DEPOSIT_ID_PARAM";
    public static final String CATEGORIE_ID_PARAM = "CATEGORIE_ID_PARAM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        ButterKnife.bind(this);


        final int depositId = getIntent().getIntExtra(MapsActivity.DEPOSIT_ID_PARAM, 0);

        ApiProvider apiProvider = new ApiProvider();

        apiProvider.getDeposit(depositId, new ApiListener<Deposit>() {
            @Override
            public void onSuccess(Deposit response) {
                deposit = response;
                loadView(deposit);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    protected void loadView(Deposit deposit) {
        calculNumberOfProductByCat(deposit);
    }

    protected void calculNumberOfProductByCat(Deposit deposit) {
        for (Product product : deposit.getProductList()) {
            productByCategorie[product.getId_categorie()] ++;
        }
    }

    protected void setCategoryList(Deposit deposit) {
        for (Product product : deposit.getProductList()) {
            if (categoryList.indexOf(product.getCategorie()) == -1) {
                categoryList.add(product.getCategorie());
            }
        }
    }

    @OnClick({ R.id.categorie1, R.id.categorie2, R.id.categorie3, R.id.categorie4, R.id.categorie5, R.id.categorie6, R.id.categorie7, R.id.categorie8, R.id.categorie9 })
    public void onCategorieClicked(Button button) {
        Intent intent = new Intent(this, ProductListActivity.class);
        int categorieId = 0;
        switch (button.getTag().toString()) {
            case ("1") : {
                categorieId = 2;
            }
            break;
            case ("2") : {
                categorieId = 1;
            }
            break;
            case ("3") : {
                categorieId = 9;
            }
            break;
            case ("4") : {
                categorieId = 8;
            }
            break;
            case ("5") : {
                categorieId = 4;
            }
            break;
            case ("6") : {
                categorieId = 5;
            }
            break;
            case ("7") : {
                categorieId = 3;
            }
            break;
            case ("8") : {
                categorieId = 6;
            }
            break;
            case ("9") : {
                categorieId = 7;
            }
            break;
        }

        intent.putExtra(DEPOSIT_ID_PARAM, deposit.getId_stockage());
        intent.putExtra(CATEGORIE_ID_PARAM, categorieId);
        startActivity(intent);
    }

}
