package com.pierrepiron.teachme.dto.mainApi;

import com.pierrepiron.teachme.dto.model.Deposit;
import com.pierrepiron.teachme.dto.model.EDeposit;
import com.pierrepiron.teachme.dto.model.EProduct;
import com.pierrepiron.teachme.dto.model.EUser;
import com.pierrepiron.teachme.dto.model.Product;
import com.pierrepiron.teachme.dto.model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {


    @GET("deposit") Call<ArrayList<EDeposit>> getDepositList(@Query("coX") Double coordX, @Query("coY") Double coordY);

    @GET("deposit/byId") Call<EDeposit> getDeposit(@Query("id") int id);

    @GET("product") Call<ArrayList<EProduct>> searchProduct(@Query("search") String productName);

    @FormUrlEncoded
    @POST("users/") Call<ResponseBody> postUser(@Field("user") User user);

    @FormUrlEncoded
    @POST("users/login/") Call<EUser> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("product/") Call<ResponseBody> postProduct(@Field("objet") Product product);

    @FormUrlEncoded
    @POST("deposit/") Call<ResponseBody> postDeposit(@Field("stockage") Deposit deposit);

    @DELETE("product/{id}") Call<ResponseBody> deleteProduct(@Path("id") int id);
}
