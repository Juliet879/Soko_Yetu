package com.example.sokoyetu.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.sokoyetu.InfoApi;
import com.example.sokoyetu.InfoClient;
import com.example.sokoyetu.R;
import com.example.sokoyetu.adapters.ProductListAdapter;
import com.example.sokoyetu.models.Datum;
import com.example.sokoyetu.models.InfoBuySearchResponse;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private ProductListAdapter mAdapter;
    private List<Datum> data_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        final Intent intent = getIntent();
        String product = intent.getStringExtra("product");
        intent.putExtra("product",product);

        InfoApi client = InfoClient.getClient();

        Call<InfoBuySearchResponse> call = client.getProducts(book);

        Call.enqueue(new Callback<InfoBuySearchResponse>() {
            @Override
            public void onResponse(Call<InfoBuySearchResponse> call, Response<InfoBuySearchResponse> response) {
               if (response.isSuccessful()){

               }
            }

            @Override
            public void onFailure(Call<InfoBuySearchResponse> call, Throwable t) {
                data_product = response.body().getDatum();
                mAdapter = new ProductListAdapter(ProductsActivity.this, data_product);
                mRecyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BookListActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setHasFixedSize(true);
                showGoogle_book();
            }
        }

        }


}