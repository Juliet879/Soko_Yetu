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
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {
    public static final String TAG = ProductListAdapter.class.getSimpleName();

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
//    @BindView(R.id.errorTextView) TextView mErrorTextView;
//    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private ProductListAdapter mAdapter;
    private List<Datum> data_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String product = intent.getStringExtra("product");
        getData_product(product);
    }

    private void getData_product(String product){
        final InfoClient infoClient = new InfoClient();
        infoClient.findData_product(product, new Callback(){

            @Override
            public void onFailure(Call call, Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                data_product = infoClient.processResults(response);
                ProductsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new ProductListAdapter(getApplicationContext(), data_product);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ProductsActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }

        });
    }

}