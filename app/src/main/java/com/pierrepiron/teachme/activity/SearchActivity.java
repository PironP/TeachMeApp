package com.pierrepiron.teachme.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pierrepiron.teachme.R;
import com.pierrepiron.teachme.dto.mainApi.ApiListener;
import com.pierrepiron.teachme.dto.mainApi.ApiProvider;
import com.pierrepiron.teachme.dto.model.Product;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity implements ProductAdapter.Listener {

    @BindView(R.id.category_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.searched_text)
    EditText searchedText;

    @BindView(R.id.no_result_label)
    TextView noResultLabel;

    @BindView(R.id.product_details)
    LinearLayout productDetails;

    @BindView(R.id.product_details_name)
    TextView productDetailsNames;

    @BindView(R.id.product_details_categorie)
    TextView productDetailsCategorie;

    @BindView(R.id.product_details_description)
    TextView productDetailsDescription;

    private ArrayList<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick (R.id.search_button)
    public void searchProducts() {

        String research = searchedText.getText().toString();
        if (research.length() < 3) {
            return;
        }

        ApiProvider apiProvider = new ApiProvider();

        apiProvider.searchProduct(research, new ApiListener<ArrayList<Product>>() {
            @Override
            public void onSuccess(ArrayList<Product> response) {
                productList = response;
                loadView();
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    private void loadView() {

        noResultLabel.setVisibility(productList.size() == 0 ? View.VISIBLE : View.INVISIBLE);
        ProductAdapter productAdapter = new ProductAdapter(productList);

        productAdapter.setListener(this);
        recyclerView.setAdapter(productAdapter);

        // peopleAdapter.setListener(this);
        // recyclerView.setAdapter(peopleAdapter);
    }


    @Override
    public void onProductClick(Product product) {
        if (productDetails.getVisibility() == View.VISIBLE) {
            return;
        }

        productDetailsDescription.setText(product.getDescription());
        productDetailsNames.setText(product.getId_product());
        // productDetailsCategorie.setText(product.getCategorie());
        productDetails.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.close_product_details_button)
    public void onCloseDetailsProductButton() {
        productDetails.setVisibility(View.GONE);
    }
}
