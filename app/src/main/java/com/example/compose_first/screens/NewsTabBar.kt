package com.example.compose_first.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_first.api.ApiManager
import com.example.compose_first.api.ApiServices
import com.example.compose_first.models.CategoriesModel
import com.example.compose_first.models.SourcesItem
import com.example.compose_first.models.SourcesResponse
import com.example.compose_first.ui.theme.DarkThemeTypography
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

@Composable
fun NewsTabs(categories: CategoriesModel) {
    val colorScheme = MaterialTheme.colorScheme
    var tabs by remember { mutableStateOf<List<SourcesItem>?>(null) }
    var selectedTabIndex by remember { mutableStateOf(0) }
    var isLoading by  remember {  mutableStateOf(false)}
    var isError by  remember {  mutableStateOf<String?>(null)}


    DisposableEffect(Unit) {
        isLoading = true
        ApiManager.apiService.getSources(category =  categories.CategorieTitle).enqueue(
             object : Callback<SourcesResponse>{

                 override fun onResponse(
                     call: Call<SourcesResponse?>,
                     response: Response<SourcesResponse?>
                 ) {
                     isLoading = false

                     if (response.isSuccessful) {
                         tabs = response.body()!!.sources

                         Log.e("SUCCESS", response.body().toString())
                         Log.e("SUCCESS", response.body().toString())
                     } else {
                         Log.e("ERROR", response.errorBody()?.string().toString())

                     }

                                      }

                 override fun onFailure(
                     call: Call<SourcesResponse?>,
                     t: Throwable
                 ) {
                     isLoading = false
                     isError = t.message
                         Log.e("Faluire ","The Api Call Failed line number is 70"+t.message)
                 }

             }

         )

        onDispose {  }
    }





               Column(
                   modifier = Modifier.fillMaxWidth()
               ) {
                   if (isLoading){

                            onLoading("The News Is Loaing")
                           }
                   if (isError?.isNotEmpty() == true){


                       onError("Something Went Wrong" ){

                               isLoading = true
                               ApiManager.apiService.getSources(category =  categories.CategorieTitle).enqueue(
                                   object : Callback<SourcesResponse>{

                                       override fun onResponse(
                                           call: Call<SourcesResponse?>,
                                           response: Response<SourcesResponse?>
                                       ) {
                                           isLoading = false

                                           if (response.isSuccessful) {
                                               tabs = response.body()!!.sources

                                               Log.e("SUCCESS", response.body().toString())
                                               Log.e("SUCCESS", response.body().toString())
                                           } else {
                                               Log.e("ERROR", response.errorBody()?.string().toString())

                                           }

                                       }

                                       override fun onFailure(
                                           call: Call<SourcesResponse?>,
                                           t: Throwable
                                       ) {
                                           isLoading = false
                                           isError = t.message
                                           Log.e("Faluire ","The Api Call Failed line number is 70"+t.message)
                                       }

                                   }

                               )
                           isError  = null




                       }

                   }

                   if (!tabs.isNullOrEmpty()){
                       ScrollableTabRow(
                           selectedTabIndex = selectedTabIndex ,
                           indicator = { tabPositons->
                               Box(
                                   modifier = Modifier
                                       .tabIndicatorOffset(tabPositons[selectedTabIndex])
                                       .height(2.dp)
                                       .background(colorScheme.onBackground)
                               )



                           } ,
                           divider = {

                           }


                       ) {
                           for (i in 0 until  (tabs?.size ?: -1)) {
                               var isSlected =selectedTabIndex == i
                               Tab(
                                   modifier = Modifier.padding(horizontal = 10.dp),
                                   selected = selectedTabIndex == i,
                                   onClick = {
                                       selectedTabIndex = i
                                   }
                               ) {
                                   Text(
                                       text = tabs!![i].name?:"" ,
                                       color = colorScheme.onBackground,
                                       modifier = Modifier.padding(2.dp) ,
                                       style =
                                           if (isSlected) DarkThemeTypography.bodyLarge else DarkThemeTypography.bodyMedium.copy(fontWeight = FontWeight.Normal , fontSize = 14.sp)
                                   )
                               }
                           }
                       }
                       Spacer(modifier = Modifier.size(20.dp))
                       NewsItems(sources = tabs!![selectedTabIndex].id )
                       Log.e("ERROR", "${tabs!![selectedTabIndex].id}")

                   }

               }


}