package com.example.sokoyetu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
    }

    InfoApi client = InfoClient.getClient();

    Call<InfoBuySearchResponse> call = client.getProducts(product, "product")
}