package com.example.compose_first.reposotories

import android.util.Log
import com.example.compose_first.api.ApiManager
import com.example.compose_first.models.SourcesItem
import com.example.compose_first.models.SourcesResponse

class onlineDataSource{
    suspend fun getSources(category : String) : List<SourcesItem>? {

       var response =  ApiManager.apiService.getSources(category= category).sources
        Log.e("Repo ","Repo Response${response}")

        return  response
    }
}
