package com.example.navigation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartViewHolder extends RecyclerView.ViewHolder {

    public TextView txt_cart_name,txt_price;
    public ImageView image_cart_count;

    public void setTxt_cart_name(TextView txt_cart_name) {
        this.txt_cart_name = txt_cart_name;
    }

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_cart_name=itemView.findViewById(R.id.cart_item_name);
        txt_price=itemView.findViewById(R.id.cart_item_price);
        image_cart_count=itemView.findViewById(R.id.cart_item_count);

    }
}
