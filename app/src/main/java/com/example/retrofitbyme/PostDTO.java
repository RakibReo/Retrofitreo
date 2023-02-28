package com.example.retrofitbyme;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface PostDTO {

    @GET("/posts")
Call<List<ResponsePostItem>> getAllpost();

}
