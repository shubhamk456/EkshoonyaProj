package com.example.ekshoonaya;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Custom_Adapter extends  RecyclerView.Adapter<Custom_Adapter.ItemViewHolder>{

    interface OnItemClickListener {

        void onItemClick(int position);
    }

    ArrayList<Item> itemArrayList;
    OnItemClickListener onItemClickListener;
    Context context;

    public Custom_Adapter(ArrayList<Item> itemArrayList,Context context,OnItemClickListener onItemClickListener) {
        this.itemArrayList = itemArrayList;
        this.onItemClickListener = onItemClickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview = (View) layoutInflater.inflate(R.layout.item_rec_view, viewGroup, false);
        ItemViewHolder holder = new ItemViewHolder(itemview);
        return holder;


    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder itemViewHolder, int i) {
        Item item = itemArrayList.get(i);
        itemViewHolder.textView.setText(item.getDesc());
        itemViewHolder.itemview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            onItemClickListener.onItemClick(itemViewHolder.getAdapterPosition());
            }
        });
        Picasso.get().load(item.imageId).into(itemViewHolder.imageView);

    }


    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        View itemview;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            this.itemview = itemView;
            textView = itemView.findViewById(R.id.rc_textView);
            imageView = itemView.findViewById(R.id.rc_image);

        }
    }



}
