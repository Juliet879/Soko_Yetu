package com.example.sokoyetu.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.sokoyetu.R;
import com.example.sokoyetu.models.Datum;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailFragment extends Fragment {
    @BindView(R.id.productImageView) ImageView mImageLabel;
    @BindView(R.id.NameTextView) TextView mNameLabel;
    @BindView(R.id.priceTextView) TextView mPriceLabel;
    @BindView(R.id.websiteTextView) TextView mUrlLabel;
    @BindView(R.id.saveProductButton) TextView mSaveProductButton;

    private Datum mData_product;

    public ProductDetailFragment() {
        // Required empty public constructor
    }

    public static ProductDetailFragment newInstance(Datum data_product){
        ProductDetailFragment restaurantDetailFragment = new ProductDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("data_product", Parcels.wrap(data_product));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mData_product = Parcels.unwrap(getArguments().getParcelable("data_product"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mData_product.getThumb()).into(mImageLabel);
        mNameLabel.setText(mData_product.getName());
        mPriceLabel.setText(mData_product.getPrice());
        mUrlLabel.setText(mData_product.getUrl());
        return view;
    }
}
