package com.example.compose_first.screens

import android.media.Image
import android.util.Log
import android.util.Log.e
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.example.compose_first.R
import com.example.compose_first.api.ApiManager
import com.example.compose_first.models.ArticelsResponse
import com.example.compose_first.models.ArticlesItem
import com.example.compose_first.models.SourcesItem
import com.example.compose_first.ui.theme.DarkThemeTypography
import com.example.compose_first.ui.theme.Gray
import com.google.gson.annotations.Until
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


data class NewsItem(
    val ImageUrl : Int ,
    val NewsHeadLine : String,
    val NewsAuthor  : String ,
    val NewsPublishTime : String
)


@Composable
fun NewsItems(sources : String?){
    val colorScheme  = MaterialTheme.colorScheme
    var isLoading by  remember {  mutableStateOf(false)}
    var isError by  remember {  mutableStateOf<String?>(null)}
    var Articles by remember {  mutableStateOf<List<ArticlesItem>?>( null) }
    DisposableEffect(Unit) {
        isLoading = true
        ApiManager.apiService.getArticles(source =  sources!!).enqueue(

            object : Callback<ArticelsResponse>{
                override fun onResponse(
                    call: Call<ArticelsResponse?>,
                    response: Response<ArticelsResponse?>
                ) {
                    isLoading = false

                    if (response.isSuccessful){
                            Articles = response.body()!!.articles
                            Log.e("Articels Body " , "${response.body()}")
                        }
                   else{
                            Log.e("Some Thing Went Wrong line 151","Articles Error ")
                            Log.e("Some Thing Went Wrong line 151","${response.code()}")
                            Log.e("ERROR", response.errorBody()?.string().toString())

                        isError = "t.message"



                    }
                }

                override fun onFailure(
                    call: Call<ArticelsResponse?>,
                    t: Throwable
                ) {
                    isLoading = false
                   isError = t.message
                    Log.e("Some Thing Went Wrong line 159","Articles Error "+t.message)
                }

            }

        )
         onDispose {

         }
    }



    LazyColumn (
        modifier = Modifier
            .background(colorScheme.background).
            fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        item{
            if (isLoading){
                onLoading("The Articles Is Loading ")
            }
            if (isError?.isNotEmpty() == true){
                onError("Try Again") {
                    isLoading = true
                    ApiManager.apiService.getArticles(source =  sources!!).enqueue(

                        object : Callback<ArticelsResponse>{
                            override fun onResponse(
                                call: Call<ArticelsResponse?>,
                                response: Response<ArticelsResponse?>
                            ) {
                                isLoading = false

                                if (response.isSuccessful){
                                    Articles = response.body()!!.articles
                                    Log.e("Articels Body " , "${response.body()}")
                                }
                                else{
                                    Log.e("Some Thing Went Wrong line 151","Articles Error ")
                                    Log.e("Some Thing Went Wrong line 151","${response.code()}")
                                    Log.e("ERROR", response.errorBody()?.string().toString())

                                    isError = "t.message"



                                }
                            }

                            override fun onFailure(
                                call: Call<ArticelsResponse?>,
                                t: Throwable
                            ) {
                                isLoading = false
                                isError = t.message
                                Log.e("Some Thing Went Wrong line 159","Articles Error "+t.message)
                            }

                        }

                    )
                    isError = null







                }
            }
        }

        if (!Articles.isNullOrEmpty()){
            items (Articles!!.size){ Article ->
                NewsSingleITem(Articles!![Article])
                Spacer(modifier = Modifier.size(10.dp))

            }
        }


    }


}

@Composable
fun NewsSingleITem(articels : ArticlesItem?){
    val colorScheme  = MaterialTheme.colorScheme
    Card ( border = BorderStroke(2.dp , color = colorScheme.onBackground),
        modifier = Modifier.fillMaxWidth(.9f).height(350.dp) ,
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.background
        )
    ) {
        Image( modifier = Modifier.padding(  5.dp).fillMaxWidth().fillMaxHeight(.7f).padding(5.dp).align(Alignment.CenterHorizontally),
            painter = painterResource(R.drawable.ic_old_man), contentDescription = "News Image ")
        Text(
            articels?.title ?: "" , modifier = Modifier.align(Alignment.CenterHorizontally).padding(horizontal = 10.dp)
                     , style = DarkThemeTypography.bodySmall ,
            color = colorScheme.onBackground
        )

        Row(
            horizontalArrangement = Arrangement.SpaceAround,


            modifier = Modifier.padding(start = 10.dp, top = 20.dp) ,
        ) {
            Text(
                articels?.author ?: "" ,  style = DarkThemeTypography.labelSmall)
            Spacer(modifier = Modifier.size(190.dp))
            Text(
                articels?.publishedAt ?: "",  style = DarkThemeTypography.labelSmall )

        }





    }

}

