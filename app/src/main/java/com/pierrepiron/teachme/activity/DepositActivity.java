package com.pierrepiron.teachme.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pierrepiron.teachme.R;
import com.pierrepiron.teachme.dto.mainApi.ApiListener;
import com.pierrepiron.teachme.dto.mainApi.ApiProvider;
import com.pierrepiron.teachme.dto.model.Deposit;
import com.pierrepiron.teachme.dto.model.Product;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DepositActivity extends AppCompatActivity {

    private ArrayList<String> categoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        ButterKnife.bind(this);


        int depositId = getIntent().getIntExtra(MapsActivity.DEPOSIT_ID_PARAM, 0);

        ApiProvider apiProvider = new ApiProvider();

        apiProvider.getDeposit(depositId, new ApiListener<Deposit>() {
            @Override
            public void onSuccess(Deposit response) {
                loadView(response);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    protected void loadView(Deposit deposit) {
        setCategoryList(deposit);
    }

    protected void setCategoryList(Deposit deposit) {
        for (Product product : deposit.getProductList()) {
            if (categoryList.indexOf(product.getCategorie()) == -1) {
                categoryList.add(product.getCategorie());
            }
        }
    }

}
