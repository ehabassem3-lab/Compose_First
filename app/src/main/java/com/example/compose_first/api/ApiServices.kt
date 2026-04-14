package com.example.compose_first.api

import com.example.compose_first.api.ApiManager.Companion.API_KEY
import com.example.compose_first.models.ArticelsResponse
import com.example.compose_first.models.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {


    @GET("v2/top-headlines/sources")
    fun getSources(
        @Query("apiKey") apiKey : String = API_KEY,
        @Query("category") category: String
    ) : Call<SourcesResponse>

     @GET("v2/everything")
    fun getArticles
                 (
         @Query("apiKey") apiKey : String = API_KEY,
       @Query("sources")  source : String
    ) : Call<ArticelsResponse>


}