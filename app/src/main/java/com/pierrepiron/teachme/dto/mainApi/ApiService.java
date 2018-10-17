package com.pierrepiron.teachme.dto.mainApi;

import com.pierrepiron.teachme.dto.model.EStockage;
import com.pierrepiron.teachme.dto.model.EUser;
import com.pierrepiron.teachme.dto.model.Objet;
import com.pierrepiron.teachme.dto.model.Stockage;
import com.pierrepiron.teachme.dto.model.User;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {


    @GET("stockages/{coordX}/{coordY}") Call<ArrayList<EStockage>> getStockageList(@Path("coordX") String coordX, @Path("coordY") String coordY);

    @GET("stockage/{id}/") Call<EStockage> getStockage(@Path("id") String id);

    @FormUrlEncoded
    @POST("users/") Call<ResponseBody> postUser(@Field("user") User user);

    @FormUrlEncoded
    @POST("users/login/") Call<EUser> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("objet/") Call<ResponseBody> postFavorites(@Field("objet") Objet objet);

    @FormUrlEncoded
    @POST("stockage/") Call<ResponseBody> postFavorites(@Field("stockage") Stockage stockage);

    @DELETE("objet/{id}") Call<ResponseBody> deleteObjet(@Path("id") String id);
}
