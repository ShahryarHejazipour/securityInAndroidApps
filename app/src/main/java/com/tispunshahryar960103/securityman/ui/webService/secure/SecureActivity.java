package com.tispunshahryar960103.securityman.ui.webService.secure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.tispunshahryar960103.securityman.R;
import com.tispunshahryar960103.securityman.api.ApiClient;
import com.tispunshahryar960103.securityman.api.IService;
import com.tispunshahryar960103.securityman.model.Lines;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secure);

        IService iService = ApiClient.getClient().create(IService.class);

        iService.getData().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                MCrypt mCrypt = new MCrypt();


                try {

                    // 1- for receiving and converting to String and saving the unKnown encrypted response body from server
                    String responseMessage = response.body().string();

                    // 2- For decrypting the encrypted response body from server
                    String decrypt = new String(mCrypt.decrypt(responseMessage));

                    // 3- for convert decrypted response body to Model class with Gson Library
                    Gson gson =new Gson();
                    List<Lines> linesList=gson.fromJson(decrypt, ArrayList.class);

                    Log.e("", "");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("", "");
            }
        });


    }
}