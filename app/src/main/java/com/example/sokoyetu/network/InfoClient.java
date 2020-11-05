package com.example.sokoyetu.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.sokoyetu.Constants.INFO_BASE_URL;

public class InfoClient {
    private static Retrofit retrofit = null;

    public static InfoApi getClient() {

        if (retrofit == null) {

            HttpLoggingInterceptor inteceptor = new HttpLoggingInterceptor();
            inteceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(inteceptor)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(INFO_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(InfoApi.class);
    }

}
