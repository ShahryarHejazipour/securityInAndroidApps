package com.tispunshahryar960103.securityman.ui.webService.sslPinning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.tispunshahryar960103.securityman.R;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SSLPinningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sslpinning);

        //1
        OkHttpClient.Builder httpBuilder=new OkHttpClient.Builder();

        //2
        CertificatePinner certificatePinner=new CertificatePinner.Builder()
                /*
                در متد add در پایین :
                چون در این تمرین ما در سرورمان فعلا Pattern ی برای SSL نداریم از سایت گیت هاب استفاده شد.
                برای پارامتر دوم که از ما Pin می خواهد می توان از سایت ssllabs.com استفاده کرد.
                برای آشنایی با طرز کار آن به فایل تکست sslLabsDotCom در همین پکیج رجوع شود.
                 */
                .add("api.github.com","sha256/k2v657xBsOVe1PQRwOsHsw3bsGT2VzIqz5K+59sNQws=").build();


        //3
        OkHttpClient client1=httpBuilder.certificatePinner(certificatePinner).build();

        //4
        Retrofit retrofit=new Retrofit.Builder().client(client1)
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create()).build();

        //5
        GitHubService gitHubService=retrofit.create(GitHubService.class);
        gitHubService.getGitHubRepos().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("", "" );
                /*
                دیده می شود که تنها با یک Certificate درست اجازه برقراری ارتباط با سرور
                یعنی سایت گیت هاب و دریافت اطلاعات را داریم
                 */
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("", "" );
            }
        });


    }
}