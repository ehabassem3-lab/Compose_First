package com.example.compose_first.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class apiManger {
    companion object{
        val retrofit = Retrofit.Builder()
            .baseUrl("newsapi.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build() ;
        fun getWebServices(){
            retrofit.create<ApiServices>(ApiServices::class.java)
        }




    }
}