package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.navigation.Model.Food;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FoodList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference foodList;
    String categoryId="";
    FirebaseRecyclerAdapter<Food,foodAdapter.foodViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        database=FirebaseDatabase.getInstance();
        foodList=database.getReference("Food");
        recyclerView=findViewById(R.id.recycler_food);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



      if(categoryId!=null)
        categoryId=getIntent().getStringExtra("CategoryId");

  //  if(!categoryId.isEmpty()&& categoryId!=null)
     FirebaseRecyclerOptions<Food>options=new FirebaseRecyclerOptions.Builder<Food>()
                  .setQuery(foodList.orderByChild("MenuId").equalTo(categoryId),Food.class).build();
            adapter=  new foodAdapter(options,getApplicationContext());
     //  adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();

    }
    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
//class WrapContentLinearLayoutManager extends LinearLayoutManager {
//    public WrapContentLinearLayoutManager(Context context) {
//        super(context);
//    }
//
//    public WrapContentLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
//        super(context, orientation, reverseLayout);
//    }
//
//    public WrapContentLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }
//
//    @Override
//    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
//        try {
//            super.onLayoutChildren(recycler, state);
//        } catch (IndexOutOfBoundsException e) {
//            Log.e("TAG", "meet a IOOBE in RecyclerView");
//        }
//    }
//}
//
