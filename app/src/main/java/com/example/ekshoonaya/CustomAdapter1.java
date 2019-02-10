package com.example.ekshoonaya;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter1 extends ArrayAdapter<CountryItem> {



    public CustomAdapter1(Context context, ArrayList<CountryItem> countrylist) {
        super(context, 0,countrylist);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private  View initView(int position,View convertView,ViewGroup parent){
        if(convertView==null){

            convertView= LayoutInflater.from(getContext()).inflate(R.layout.spinner_item1,parent,false);


        }
        ImageView imageView=convertView.findViewById(R.id.image_views1);
        TextView textView=convertView.findViewById(R.id.txtv1);
        CountryItem countryItem= getItem(position);
        if(convertView!=null) {
            imageView.setImageResource(countryItem.getmFlagImage());
            textView.setText(countryItem.getCountrycode());
        }
        return convertView;

    }




















}
