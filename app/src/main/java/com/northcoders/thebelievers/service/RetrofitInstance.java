package com.northcoders.thebelievers.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofitInstance = null;
    private static String BASE_URL;


    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();


    public static TheBelieverAPIService getServiceMethod(){
        BASE_URL = "https://thebelievers.onrender.com/api/v1/TheBeliever/";
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        retrofitInstance = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();


        return retrofitInstance.create(TheBelieverAPIService.class);

    }
}
