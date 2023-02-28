package com.example.retrofitbyme;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RetrofitViewHolder extends RecyclerView.ViewHolder{

    TextView jsonData;

    public RetrofitViewHolder(@NonNull View itemView) {
        super(itemView);


        jsonData=itemView.findViewById(R.id.jsonData);

    }
}
