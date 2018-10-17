package com.pierrepiron.teachme.dto.mainApi;


import com.pierrepiron.teachme.dto.mapper.StockageMapper;
import com.pierrepiron.teachme.dto.model.EStockage;
import com.pierrepiron.teachme.dto.model.Stockage;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {

    private static final String BASE_URL = "https://kaamelott-api.herokuapp.com/";

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


    public void getStockageList(String coordX, String coordY, final ApiListener<ArrayList<Stockage>> listener) {
        apiService.getStockageList(coordX, coordY).enqueue(new Callback<ArrayList<EStockage>>() {
            @Override
            public void onResponse(Call<ArrayList<EStockage>> call, Response<ArrayList<EStockage>> response) {
                if (listener != null) {
                    StockageMapper stockageMapper = new StockageMapper();
                    ArrayList<Stockage> stockageList = stockageMapper.map(response.body());
                    listener.onSuccess(stockageList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EStockage>> call, Throwable t) {
                if (listener != null) listener.onError(t);
            }
        });
    }

    public void getStockage(String id, final ApiListener<Stockage> listener) {
        apiService.getStockage(id).enqueue(new Callback<EStockage>() {
            @Override
            public void onResponse(Call<EStockage> call, Response<EStockage> response) {
                if (listener != null) {
                    StockageMapper stockageMapper = new StockageMapper();
                    Stockage stockage = stockageMapper.map(response.body());
                    listener.onSuccess(stockage);
                }
            }

            @Override
            public void onFailure(Call<EStockage> call, Throwable t) {
                if (listener != null) listener.onError(t);
            }
        });
    }
/*
    public void getPeople(String id, final ApiListener<People> listener) {
        apiService.getPeople(id).enqueue(new Callback<EPeople>() {
            @Override public void onResponse(Call<EPeople> call, Response<EPeople> response) {
                if (listener != null) {
                    PeopleMapper peopleMapper = new PeopleMapper();
                    People people = peopleMapper.map(response.body());
                    listener.onSuccess(people);
                }
            }

            @Override public void onFailure(Call<EPeople> call, Throwable t) {
                if (listener != null) listener.onError(t);
            }
        });
    }

    public void getRandomQuote(final ApiListener<Quote> listener) {
        apiService.getRandomQuote().enqueue(new Callback<EQuote>() {
            @Override
            public void onResponse(Call<EQuote> call, Response<EQuote> response) {
                if (listener != null) {
                    QuoteMapper quoteMapper= new QuoteMapper();
                    Quote quote = quoteMapper.map(response.body());
                    listener.onSuccess(quote);
                }
            }

            @Override
            public void onFailure(Call<EQuote> call, Throwable t) {
                if (listener != null) listener.onError(t);
            }
        });
    }

    public void getFavorites(String userId, final ApiListener<ArrayList<Favorite>> listener) {
        apiService.getFavorites(userId).enqueue(new Callback<ArrayList<EFavorite>>() {
            @Override
            public void onResponse(Call<ArrayList<EFavorite>> call, Response<ArrayList<EFavorite>> response) {
                if (listener != null) {
                    FavoriteMapper favoriteMapper = new FavoriteMapper();
                    ArrayList<Favorite> favoritesList = favoriteMapper.map(response.body());
                    listener.onSuccess(favoritesList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EFavorite>> call, Throwable t) {
                if (listener != null) listener.onError(t);
            }
        });
    }

    public void addFavorite(String userId, String quoteId, final ApiListener<Integer> listener) {

        apiService.postFavorites(userId, quoteId).enqueue(new Callback<ResponseBody>() {
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

    public void login(String email, String password, final ApiListener<User> listener) {
        apiService.login(email, password).enqueue(new Callback<EUser>() {
            @Override
            public void onResponse(Call<EUser> call, Response<EUser> response) {
                if (listener != null) {
                    if (response.code() == 200) {
                        UserMapper userMapper = new UserMapper();
                        User user = userMapper.map(response.body());
                    }
                    listener.onSuccess(User.getInstance());
                }
            }

            @Override
            public void onFailure(Call<EUser> call, Throwable t) {
                if (listener != null) listener.onError(t);
            }
        });
    }

    public void deleteFavorite(String idFavorite, final ApiListener<Integer> listener) {
        apiService.deleteFavorite(idFavorite).enqueue(new Callback<ResponseBody>() {
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
}
