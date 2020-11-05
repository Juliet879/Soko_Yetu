package com.example.sokoyetu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.sokoyetu.InfoApi;
import com.example.sokoyetu.InfoBuySearchResponse;
import com.example.sokoyetu.InfoClient;
import com.example.sokoyetu.R;

import retrofit2.Call;

public class ProductsActivity extends AppCompatActivity {

    private ProductListAdapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        final Intent intent = getIntent();
        String product = intent.getStringExtra("product");
        intent.putExtra("product",product);
    }

    InfoApi client = InfoClient.getClient();

    Call<InfoBuySearchResponse> call = client.getProducts(product);
}