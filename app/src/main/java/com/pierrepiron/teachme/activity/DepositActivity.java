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
    private int[] productByCategorie = new int[11];
    public static final String CATEGORIE_NAME_PARAM = "CATEGORIE_NAME_PARAM";
    public static final String OBJECT_PARAM = "OBJECT_PARAM";

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
        String categorieName = "";
        switch (button.getTag().toString()) {
            case ("1") : {
                categorieName = "Calculatrice";
            }
            break;
            case ("2") : {
                categorieName = "Livre";
            }
            break;
            case ("3") : {
                categorieName = "Geometrie";
            }
            break;
            case ("4") : {
                categorieName = "Musique";
            }
            break;
            case ("5") : {
                categorieName = "Feuille";
            }
            break;
            case ("6") : {
                categorieName = "Cartable";
            }
            break;
            case ("7") : {
                categorieName = "Materiel";
            }
            break;
            case ("8") : {
                categorieName = "Materiel Informatique";
            }
            break;
            case ("9") : {
                categorieName = "Ciseaux";
            }
            break;
        }

        Gson gson = new Gson();
        String productListJson = gson.toJson(deposit.getProductList());

        intent.putExtra(OBJECT_PARAM, productListJson);
        intent.putExtra(CATEGORIE_NAME_PARAM, categorieName);
        startActivity(intent);
    }

}
