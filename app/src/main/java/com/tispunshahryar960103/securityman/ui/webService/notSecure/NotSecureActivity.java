package com.tispunshahryar960103.securityman.ui.webService.notSecure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.tispunshahryar960103.securityman.R;
import com.tispunshahryar960103.securityman.api.ApiClient;
import com.tispunshahryar960103.securityman.api.IService;
import com.tispunshahryar960103.securityman.model.Lines;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotSecureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_secure);

        IService iService= ApiClient.getClient().create(IService.class);
        iService.getLines().enqueue(new Callback<List<Lines>>() {
            @Override
            public void onResponse(Call<List<Lines>> call, Response<List<Lines>> response) {
                Log.e("","");
            }

            @Override
            public void onFailure(Call<List<Lines>> call, Throwable t) {
                Log.e("","");

            }
        });


    }
}