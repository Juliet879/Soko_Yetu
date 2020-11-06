package com.example.sokoyetu.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sokoyetu.R;
import com.example.sokoyetu.models.Datum;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {
    private List<Datum> data_product;
    private Context mContext;

    public ProductListAdapter(Context context,List<Datum> data_product){
        mContext = context;
        mData_product = data_product;
    }

    @NonNull
    @Override
    public ProductListAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item, parent, false);
        ProductViewHolder viewHolder = new ProductViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.ProductViewHolder holder, int position) {
        holder.bindData_product(mData_product.get(position));

    }

    @Override
    public int getItemCount() {
        return mData_product.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.productImageView) ImageView mProductImageView;
        @BindView(R.id.nameTextView) TextView mNameTextView;
        @BindView(R.id.priceTextView) TextView mPriceTextView;
        @BindView(R.id.urlTextView) TextView mUrlTextView;

        private Context mContext;

        public ProductViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindData_product(Datum data_product) {
            mNameTextView.setText(data_product.getName());
            mPriceTextView.setText(data_product.getPrice());
            mUrlTextView.setText(data_product.getUrl());
            Picasso.get().load(data_product.getThumb()).into(mProductImageView);
        }

        @Override
        public void onClick(View v){
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, ProductDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("data_product", Parcels.wrap(mData_product));
            mContext.startActivity(intent);
        }
    }
}
