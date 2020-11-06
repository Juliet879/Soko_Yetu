package com.example.sokoyetu.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.sokoyetu.R;
import com.example.sokoyetu.adapters.ProductPagerAdapter;
import com.example.sokoyetu.models.Datum;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewPager) ViewPager mViewPager;
    private ProductPagerAdapter adapterViewPager;
    List<Datum> mData_product = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ButterKnife.bind(this);

        mData_product = Parcels.unwrap(getIntent().getParcelableExtra("data_product"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new ProductPagerAdapter(getSupportFragmentManager(), mRestaurants);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
