package com.tispunshahryar960103.securityman.api;

import android.util.Base64;

import com.tispunshahryar960103.securityman.BuildConfig;

import java.io.UnsupportedEncodingException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    static {
        System.loadLibrary("ndksample");
    }


    //public static final String BASE_URL="http://api.androidsupport.ir/";
   //public static final String BASE_URL= BuildConfig.serverUrl;
   //public static final String BASE_URL= getUrl();
   public static final String BASE_URL= getSecureBaseUrl();

    private static Retrofit retrofit=null;

    public static Retrofit getClient(){


        if (retrofit==null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }

        return retrofit;


    }

    public static native String getUrl();


    /*
    برای بهینه تر کردن امنیت رشته های تابع getUrl از تابع زیر استفاده می شود که
    می گوید مقدار mUrl را گرفته و decode کند و مقدار آن را برگرداند. در غیر اینصورت یک مقدار نادرست
    مانند "https://gdgsdhguk.com/" را برگرداند تا اگر کسی فایل apk را decompile کرد نتواند به رشته های ما
    دشترسی داشته باشد.
     */
    public static String getSecureBaseUrl(){

        String mUrl=getUrl();

        try {
            String text = new String(Base64.decode(mUrl,Base64.DEFAULT),"UTF-8");
            return text;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        mUrl="https://gdgsdhguk.com/";
        return mUrl;

    }










}
