package com.example.navigation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.navigation.Common.Common;
import com.example.navigation.Model.Category;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class myAdapter extends FirebaseRecyclerAdapter<Category,myAdapter.myViewHolder> {

    Context context;
    FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public myAdapter(@NonNull FirebaseRecyclerOptions<Category> options,Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Category model) {

        final String key=getRef(position).getKey();
        holder.menu_name.setText(model.getName());
        Glide.with(holder.menu_image.getContext()).load(model.getImage()).into(holder.menu_image);
        holder.view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

           Intent foodlist=new Intent(context,FoodList.class);
           foodlist.putExtra("CategoryId",key );
           foodlist.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           context.startActivity(foodlist);
       }
   });


    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        ImageView menu_image;
        TextView menu_name;
        View view;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            menu_name=itemView.findViewById(R.id.menu_name);
            menu_image=itemView.findViewById(R.id.menu_image);
            view=itemView;
        }
    }




}
