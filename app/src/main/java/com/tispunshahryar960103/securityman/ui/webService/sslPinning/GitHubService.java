package com.tispunshahryar960103.securityman.ui.webService.sslPinning;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/*
چون در وب سرویس آموزشی این دوره کدی برای جستار SSl Pinning در نظر گرفته نشده بود
که بر اساس آن وب سرویس درون کلاس IService متدهای لازم را بنویسیم و ما در این مثال از
وب سرویس های نمونه ی سایت GitHub.com استفاده کردیم - در SSLPinningActivity.java -
بنابراین از این اینترفیس به جای IService.java برای نوشتن متدهای لازم در ارتباط با وب سرویس
سایت گیت هاب.
 */
public interface GitHubService {

    @GET("users/srfarzad/repos")
    Call<ResponseBody> getGitHubRepos();
}
