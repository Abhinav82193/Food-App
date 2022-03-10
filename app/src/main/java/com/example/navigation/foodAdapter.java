package com.example.navigation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.navigation.Model.Category;
import com.example.navigation.Model.Food;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class foodAdapter extends FirebaseRecyclerAdapter<Food,foodAdapter.foodViewHolder> {

    Context context;
    FirebaseRecyclerAdapter firebaseRecyclerAdapter;


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     *
     */
    public foodAdapter(@NonNull FirebaseRecyclerOptions<Food> options, Context context) {
        super(options);
        this.context=context;

    }

    @Override
    protected void onBindViewHolder(@NonNull foodViewHolder holder, int position, @NonNull Food model) {
        final String key=getRef(position).getKey();
        holder.food_name.setText(model.getName());
        Glide.with(holder.food_image.getContext()).load(model.getImage()).into(holder.food_image);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent fooddetail=new Intent(context,FoodDetail.class);
                fooddetail.putExtra("FoodId",key );
                fooddetail.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(fooddetail);
            }
        });

    }

    @NonNull
    @Override
    public foodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item,parent,false);
        return new foodAdapter.foodViewHolder(view);
    }

    public class foodViewHolder extends RecyclerView.ViewHolder {

        ImageView food_image;
        TextView food_name;
        View view;

        public foodViewHolder(@NonNull View itemView) {
            super(itemView);
            food_image=itemView.findViewById(R.id.food_image);
            food_name=itemView.findViewById(R.id.food_name);
            view=itemView;
        }
    }
}
