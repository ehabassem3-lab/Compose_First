package com.example.compose_first.screens

import android.media.Image
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.example.compose_first.R
import com.example.compose_first.ui.theme.DarkThemeTypography
import com.example.compose_first.ui.theme.Gray


data class NewsItem(
    val ImageUrl : Int ,
    val NewsHeadLine : String,
    val NewsAuthor  : String ,
    val NewsPublishTime : String
)
val newsList = listOf(
    NewsItem(
        ImageUrl = R.drawable.ic_old_man,
        NewsHeadLine = "Israel launches major strikes on Beirut as death toll in Lebanon exceeds 300",
        NewsAuthor = "Sarah Khalil",
        NewsPublishTime = "1h ago"
    ),
    NewsItem(
        ImageUrl = R.drawable.ic_old_man,
        NewsHeadLine = "NASA's Artemis II crew successfully returns after historic lunar flyby mission",
        NewsAuthor = "Michael Reynolds",
        NewsPublishTime = "3h ago"
    ),
    NewsItem(
        ImageUrl = R.drawable.ic_old_man,
        NewsHeadLine = "OpenAI CEO Sam Altman escapes unharmed after firebomb attack on his home",
        NewsAuthor = "Elena Vasquez",
        NewsPublishTime = "5h ago"
    ),
    NewsItem(
        ImageUrl = R.drawable.ic_old_man,
        NewsHeadLine = "US and Iran reach surprise two-week ceasefire agreement in Geneva talks",
        NewsAuthor = "David Chen",
        NewsPublishTime = "Yesterday"
    ),
    NewsItem(
        ImageUrl = R.drawable.ic_old_man,
        NewsHeadLine = "Rory McIlroy storms to six-shot lead at the 2026 Masters Tournament",
        NewsAuthor = "James Patel",
        NewsPublishTime = "Yesterday"
    ),
    NewsItem(
        ImageUrl = R.drawable.ic_old_man,
        NewsHeadLine = "TSMC reports 35% revenue surge as AI chip demand continues to explode",
        NewsAuthor = "Priya Sharma",
        NewsPublishTime = "2d ago"
    ),
    NewsItem(
        ImageUrl = R.drawable.ic_old_man,
        NewsHeadLine = "Trump threatens to pull US out of NATO over disagreements on Iran policy",
        NewsAuthor = "Robert Kline",
        NewsPublishTime = "2d ago"
    ),
    NewsItem(
        ImageUrl = R.drawable.ic_old_man,
        NewsHeadLine = "Meta unveils powerful new Muse AI model in major strategy update",
        NewsAuthor = "Lisa Moreau",
        NewsPublishTime = "3d ago"
    ),
    NewsItem(
        ImageUrl = R.drawable.ic_old_man,
        NewsHeadLine = "Real Madrid held to frustrating 1-1 draw by Girona in La Liga title race",
        NewsAuthor = "Carlos Rivera",
        NewsPublishTime = "3d ago"
    ),
    NewsItem(
        ImageUrl = R.drawable.ic_old_man,
        NewsHeadLine = "S&P 500 rebounds sharply as investors bet on quick end to Middle East tensions",
        NewsAuthor = "Jennifer Lopez",
        NewsPublishTime = "Apr 10, 2026"
    ),
    NewsItem(
        ImageUrl = R.drawable.ic_old_man,
        NewsHeadLine = "China shifts investment strategy in Brazil from infrastructure to consumer brands",
        NewsAuthor = "Ahmed Hassan",
        NewsPublishTime = "Apr 9, 2026"
    ),
    NewsItem(
        ImageUrl = R.drawable.ic_old_man,
        NewsHeadLine = "New study reveals alarming acceleration in Antarctic ice sheet melting",
        NewsAuthor = "Dr. Maria Santos",
        NewsPublishTime = "Apr 8, 2026"
    )
)

@Composable
fun NewsItems(){
    val colorScheme  = MaterialTheme.colorScheme
    LazyColumn (modifier = Modifier.background(colorScheme.background).fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        items(newsList){ newsList->
            NewsSingleITem(newsList)
            Spacer(modifier = Modifier.size(10.dp))

        }

    }


}

@Composable
fun NewsSingleITem(newsItem: NewsItem){
    val colorScheme  = MaterialTheme.colorScheme
    Card ( border = BorderStroke(2.dp , color = colorScheme.onBackground),
        modifier = Modifier.fillMaxWidth(.9f).height(350.dp) ,
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.background
        )
    ) {
        Image( modifier = Modifier.padding(  5.dp).fillMaxWidth().fillMaxHeight(.7f).padding(5.dp).align(Alignment.CenterHorizontally),
            painter = painterResource(newsItem.ImageUrl), contentDescription = "News Image ")
        Text(
            newsItem.NewsHeadLine , modifier = Modifier.align(Alignment.CenterHorizontally).padding(horizontal = 10.dp)
                     , style = DarkThemeTypography.bodySmall ,
            color = colorScheme.onBackground
        )

        Row(
            horizontalArrangement = Arrangement.SpaceAround,


            modifier = Modifier.padding(start = 10.dp, top = 20.dp) ,
        ) {
            Text(newsItem.NewsAuthor  ,  style = DarkThemeTypography.labelSmall)
            Spacer(modifier = Modifier.size(190.dp))
            Text(newsItem.NewsPublishTime  ,  style = DarkThemeTypography.labelSmall )

        }





    }

}

