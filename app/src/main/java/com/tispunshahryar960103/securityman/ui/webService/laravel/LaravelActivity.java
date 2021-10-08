package com.tispunshahryar960103.securityman.ui.webService.laravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.tispunshahryar960103.securityman.R;
import com.tispunshahryar960103.securityman.api.ApiClient;
import com.tispunshahryar960103.securityman.api.IService;
import com.tispunshahryar960103.securityman.model.LoginResponse;
import com.tispunshahryar960103.securityman.model.ResponseMessage;
import com.tispunshahryar960103.securityman.model.Success;
import com.tispunshahryar960103.securityman.ui.sharedPref.MyEncryptedSharedPreferences;

import java.io.IOException;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaravelActivity extends AppCompatActivity {

    AppCompatEditText edt_name, edt_email, edt_password, edt_repassword, edt_email_login, edt_password_login;
    AppCompatButton btn_register, btn_login;
    IService iService;

    //For saving the token
    MyEncryptedSharedPreferences myEncryptedSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laravel);


        edt_name = findViewById(R.id.edt_name);
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);
        edt_repassword = findViewById(R.id.edt_repassword);
        btn_register = findViewById(R.id.btn_register);
        btn_login = findViewById(R.id.btn_login);
        edt_email_login = findViewById(R.id.edt_email_login);
        edt_password_login = findViewById(R.id.edt_password_login);

        //For saving the token
        myEncryptedSharedPreferences=new MyEncryptedSharedPreferences(this);

        iService = ApiClient.getClient().create(IService.class);

       btn_register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               iService.register(Objects.requireNonNull(edt_name.getText()).toString(), Objects.requireNonNull(edt_email.getText()).toString(), Objects.requireNonNull(edt_password.getText()).toString()
                       , Objects.requireNonNull(edt_repassword.getText()).toString()).enqueue(new Callback<ResponseBody>() {
                   @Override
                   public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                       Log.e("", "");

                       if (response.body()!=null){

                           Gson gson=new Gson();
                           try {
                               String res = response.body().string();


                              ResponseMessage responseMessage=gson.fromJson(res,ResponseMessage.class);
                              myEncryptedSharedPreferences.saveToken(responseMessage.getSuccess().getToken());

                               Log.e("", "");


                           } catch (IOException e) {
                               e.printStackTrace();
                           }catch (Exception e){
                               e.printStackTrace();
                           }
                       }
                   }

                   @Override
                   public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                       Log.e("", "");
                   }
               });
           }
       });

       btn_login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               iService.login(edt_email_login.getText().toString(),edt_password_login.getText().toString()).enqueue(new Callback<ResponseBody>() {
                   @Override
                   public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                       Log.e("", "");

                       if (response.body()!=null){

                           Gson gson=new Gson();
                           try {
                               String res = response.body().string();


                               LoginResponse loginResponse=gson.fromJson(res,LoginResponse.class);
                               myEncryptedSharedPreferences.saveToken(loginResponse.getToken());

                               Log.e("", "");


                           } catch (IOException e) {
                               e.printStackTrace();
                           }catch (Exception e){
                               e.printStackTrace();
                           }
                       }
                   }

                   @Override
                   public void onFailure(Call<ResponseBody> call, Throwable t) {
                       Log.e("", "");
                   }
               });


           }
       });


    }
}