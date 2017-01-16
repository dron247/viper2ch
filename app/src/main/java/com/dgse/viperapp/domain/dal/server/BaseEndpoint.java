package com.dgse.viperapp.domain.dal.server;

import com.dgse.viperapp.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Андрей on 16.01.2017.
 */

public abstract class BaseEndpoint {
    protected static final String BASE_URL = "https://2ch.hk/";

    protected final Retrofit retrofit;

    protected BaseEndpoint() {


        OkHttpClient.Builder okhhtpBuilder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okhhtpBuilder.addInterceptor(interceptor);
        }

        OkHttpClient okHttpClient = okhhtpBuilder.build();


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }
}
