package com.pierrepiron.teachme.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.pierrepiron.teachme.R;
import com.pierrepiron.teachme.dto.mainApi.ApiListener;
import com.pierrepiron.teachme.dto.mainApi.ApiProvider;
import com.pierrepiron.teachme.dto.model.Deposit;
import com.pierrepiron.teachme.dto.model.Product;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailsActivity extends AppCompatActivity {

    private String productDescription;
    private Deposit deposit;

    @BindView(R.id.product_details_name)
    TextView productDetailsName;

    @BindView(R.id.product_details_assoc_name)
    TextView productDetailsAssocName;

    @BindView(R.id.product_details_assoc_adress)
    TextView productDetailsAssocAdress;

    @BindView(R.id.product_details_assoc_tel)
    TextView productDetailsAssocTel;

    @BindView(R.id.product_details_assoc_horaire)
    TextView productDetailsAssocHoraire;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        ButterKnife.bind(this);

        productDescription = getIntent().getStringExtra(SearchActivity.PRODUCT_DESC_PARAM);
        int depositProduct = getIntent().getIntExtra(SearchActivity.DEPOSIT_ID_PARAM, 0);

        getDeposit(depositProduct);
    }


    protected void getDeposit(int idDeposit) {
        ApiProvider apiProvider = new ApiProvider();
        apiProvider.getDeposit(idDeposit, new ApiListener<Deposit>() {
            @Override
            public void onSuccess(Deposit response) {
                deposit = response;
                loadView();
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    protected void loadView() {

        productDetailsAssocName.setText(deposit.getName());
        productDetailsAssocAdress.setText(deposit.getAdresse());
        productDetailsAssocTel.setText(deposit.getTel());
        productDetailsName.setText(productDescription);

    }
}
