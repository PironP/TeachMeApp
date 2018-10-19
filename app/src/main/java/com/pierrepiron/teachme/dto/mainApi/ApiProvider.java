package com.pierrepiron.teachme.dto.mainApi;

import com.pierrepiron.teachme.dto.mapper.CurrentUserMapper;
import com.pierrepiron.teachme.dto.mapper.DepositMapper;
import com.pierrepiron.teachme.dto.mapper.ProductMapper;
import com.pierrepiron.teachme.dto.mapper.UserMapper;
import com.pierrepiron.teachme.dto.model.CurrentUser;
import com.pierrepiron.teachme.dto.model.Deposit;
import com.pierrepiron.teachme.dto.model.ECurrentUser;
import com.pierrepiron.teachme.dto.model.EDeposit;
import com.pierrepiron.teachme.dto.model.EProduct;
import com.pierrepiron.teachme.dto.model.EUser;
import com.pierrepiron.teachme.dto.model.Product;
import com.pierrepiron.teachme.dto.model.User;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {

    private static final String BASE_URL = "https://hackathonteachme.herokuapp.com/";

    private ApiService apiService;

    public ApiProvider() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .build();
        apiService = retrofit.create(ApiService.class);

    }

    private OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
        return okBuilder.build();
    }


    public void getDepositList(Double coordX, Double coordY, final ApiListener<ArrayList<Deposit>> listener) {
        apiService.getDepositList(coordX, coordY).enqueue(new Callback<ArrayList<EDeposit>>() {
            @Override
            public void onResponse(Call<ArrayList<EDeposit>> call, Response<ArrayList<EDeposit>> response) {
                if (listener != null) {
                    DepositMapper depositMapper = new DepositMapper();
                    ArrayList<Deposit> depositList = depositMapper.map(response.body());
                    listener.onSuccess(depositList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EDeposit>> call, Throwable t) {
                if (listener != null) listener.onError(t);
            }
        });
    }

    public void getDeposit(int id, final ApiListener<Deposit> listener) {
        apiService.getDeposit(id).enqueue(new Callback<EDeposit>() {
            @Override
            public void onResponse(Call<EDeposit> call, Response<EDeposit> response) {
                if (listener != null) {
                    DepositMapper depositMapper = new DepositMapper();
                    Deposit deposit = depositMapper.map(response.body());
                    listener.onSuccess(deposit);
                }
            }

            @Override
            public void onFailure(Call<EDeposit> call, Throwable t) {
                if (listener != null) listener.onError(t);
            }
        });
    }

    public void searchProduct(String productName, final ApiListener<ArrayList<Product>> listener) {
        apiService.searchProduct(productName).enqueue(new Callback<ArrayList<EProduct>>() {
            @Override
            public void onResponse(Call<ArrayList<EProduct>> call, Response<ArrayList<EProduct>> response) {
                if (listener != null) {
                    ProductMapper productMapper = new ProductMapper();
                    ArrayList<Product> productList = productMapper.map(response.body());
                    listener.onSuccess(productList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EProduct>> call, Throwable t) {
                if (listener != null) listener.onError(t);
            }
        });
    }


    public void postProduct(Product product, final ApiListener<Integer> listener) {

        apiService.postProduct(product).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (listener != null) {
                    listener.onSuccess(response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (listener != null) listener.onError(t);
            }
        });
    }


    public void login(String email, String password, final ApiListener<CurrentUser> listener) {
        apiService.login(email, password).enqueue(new Callback<ECurrentUser>() {
            @Override
            public void onResponse(Call<ECurrentUser> call, Response<ECurrentUser> response) {
                if (listener != null) {
                    if (response.code() == 200) {
                        CurrentUserMapper currentUserMapper = new CurrentUserMapper();
                        currentUserMapper.map(response.body());
                        listener.onSuccess(CurrentUser.getInstance());

                    }

                }
            }

            @Override
            public void onFailure(Call<ECurrentUser> call, Throwable t) {
                if (listener != null) listener.onError(t);
            }
        });
    }

/*
    public void signup(String email, String password, final ApiListener<Integer> listener) {
        apiService.postUser(email, password).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (listener != null) {
                    listener.onSuccess(response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (listener != null) listener.onError(t);
            }
        });
    }

*/
    public void deleteProduct(int id_product, final ApiListener<Integer> listener) {
        apiService.deleteProduct(id_product).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (listener != null) {
                    listener.onSuccess(response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (listener != null) listener.onError(t);
            }
        });
    }

}
