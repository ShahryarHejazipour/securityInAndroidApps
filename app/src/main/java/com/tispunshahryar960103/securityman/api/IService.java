package com.tispunshahryar960103.securityman.api;

import com.tispunshahryar960103.securityman.model.Lines;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IService {

    @GET("metro/getLines.php")
    Call<List<Lines>> getLines();

    @GET("security/getData.php")
    Call<ResponseBody> getData();


}
