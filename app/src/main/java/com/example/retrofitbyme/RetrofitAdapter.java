package com.example.retrofitbyme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitAdapter  extends RecyclerView.Adapter <RetrofitViewHolder>{

    private Context context;

    List<ResponsePostItem> postItems;
    //private List<ResponsePost> responsePostList;


    public RetrofitAdapter(Context context, List<ResponsePostItem> postItems) {
        this.context = context;
        this.postItems = postItems;
    }

    @NonNull
    @Override
    public RetrofitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_retrofit,parent,false);  //item-name is the parents xml jekhane main overview dibe

        RetrofitViewHolder viewHolder=new RetrofitViewHolder(view);   	//ekane View object create kore call korbe.

        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull RetrofitViewHolder holder, int position) {

        String nameStr= postItems.get(position).getTitle();

        holder.jsonData.setText(nameStr);
    }

    @Override
    public int getItemCount() {
        return postItems.size();
    }
}
