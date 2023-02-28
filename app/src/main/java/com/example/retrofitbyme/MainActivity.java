package com.example.retrofitbyme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.retrofitbyme.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PostDTO dto =RetrofitClient.getRetrofit().create(PostDTO.class);

        Call<List<ResponsePostItem>> response = dto.getAllpost();  //PosDTO theke post antese

        response.enqueue(new Callback<List<ResponsePostItem>>() {
            @Override
            public void onResponse(Call<List<ResponsePostItem>> call, Response<List<ResponsePostItem>> response) {
           if(response.isSuccessful()){

               Log.i("TAG","code: "+response.code());
               List<ResponsePostItem> postItems= response.body();


               if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){

                   postItems.forEach(p ->{

                       Log.i("TAG","item: "+p);


                   });


               }

               RetrofitAdapter adapter =new RetrofitAdapter(MainActivity.this,postItems);//serial-2  //NameAdapter Constructor Declaration
               binding.suracall.setAdapter(adapter);  // serial-1 ekhane binding dia adapter class method call kore outp

           }
            }

            @Override
            public void onFailure(Call<List<ResponsePostItem>> call, Throwable t) {

            }
        });



    }
}