package com.example.compose_first.reposotories

import android.util.Log
import com.example.compose_first.models.SourcesItem
import com.example.compose_first.models.SourcesResponse

class NewsRepositories(){

    var isConnected = false
    var offlineDataSource = offlineDataSource()
    var onlineDataSource = onlineDataSource()

    suspend fun getSources(category : String) : List<SourcesItem>{
        if (isConnected){
            val source = onlineDataSource.getSources(category)
            offlineDataSource.saveSources(category , source!!)
            Log.e("Saved " ,"Saved${ offlineDataSource.saveSources(category , source!!)}")
            return source
        }
        else{
           return  offlineDataSource.getSources(category)
        }






    }

}