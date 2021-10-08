package com.tispunshahryar960103.securityman.api;

import com.tispunshahryar960103.securityman.model.Lines;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface IService {

    @GET("metro/getLines.php")
    Call<List<Lines>> getLines();

    @GET("security/getData.php")
    Call<ResponseBody> getData();

    @POST("apilaravel/public/api/register")
    @FormUrlEncoded
    Call<ResponseBody> register(@Field("name") String name,
                                @Field("email") String email,
                                @Field("password") String password,
                                @Field("password_confirmation") String password_confirmation);


    @POST("apilaravel/public/api/login")
    @FormUrlEncoded
    Call<ResponseBody> login(@Field("email") String email,
                             @Field("password") String password);


    @GET("apilaravel/public/api/user")
    Call<ResponseBody> user(@Header("Authorization") String auth);


}
