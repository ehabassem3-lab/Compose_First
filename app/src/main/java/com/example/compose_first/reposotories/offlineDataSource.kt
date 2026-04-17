package com.example.compose_first.reposotories

import android.util.Log
import com.example.compose_first.database.SourcesDatabase
import com.example.compose_first.models.SourcesItem
import com.example.compose_first.models.SourcesResponse
import java.util.Locale
import java.util.Locale.getDefault

class offlineDataSource{
     var dao = SourcesDatabase.getDataBase().getDao()
     suspend fun getSources(category : String) : List<SourcesItem>{

              var sources = dao.getSources(category.lowercase(getDefault()))
         Log.e("Saved " ,"Saved${sources}")
         return sources

     }
     suspend fun saveSources(category : String , sources :  List<SourcesItem>) {

         dao.saveSources(   sources)
         Log.e("Saved " ,"Saved${sources}")





     }
 }
