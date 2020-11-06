package com.example.sokoyetu.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.sokoyetu.models.Datum;

import java.util.List;

public class ProductPagerAdapter extends FragmentPagerAdapter {
    private List<Datum> mData_product;

    public ProductPagerAdapter(FragmentManager fm, List<Datum> data_product){
        super(fm);
        mData_product = data_product;
    }

    @Override
    public Fragment getItem(int position){
        return ProductDetailFragment.newInstance(mData_product.get(position));
    }

    @Override
    public int getCount(){
        return mData_product.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mData_product.get(position).getName();
    }
}
