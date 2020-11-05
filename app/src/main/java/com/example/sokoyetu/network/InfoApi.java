package com.example.sokoyetu.network;

import com.example.sokoyetu.InfoBuySearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InfoApi {
    @GET("product/search")
    Call<InfoBuySearchResponse> getProducts(
            String product, @Query("q") String q
    );

    Call<InfoBuySearchResponse> getProducts(String product);
}
