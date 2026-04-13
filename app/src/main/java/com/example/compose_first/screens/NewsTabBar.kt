package com.example.compose_first.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.compose_first.models.CategoriesModel
import com.example.compose_first.ui.theme.DarkThemeTypography

@Composable
fun NewsTabs(categories: CategoriesModel) {
    val colorScheme = MaterialTheme.colorScheme
    val tabs = listOf("tab1", "tab2", "tab3", "tab4", "tab5")

    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
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
            for (i in tabs.indices) {
                var isSlected =selectedTabIndex == i
                Tab(
                    selected = selectedTabIndex == i,
                    onClick = {
                        selectedTabIndex = i
                    }
                ) {
                    Text(
                        text = tabs[i] ,
                        color = colorScheme.onBackground,
                        modifier = Modifier.padding(2.dp) ,
                        style =
                            if (isSlected) DarkThemeTypography.bodyLarge else DarkThemeTypography.bodyMedium.copy(fontWeight = FontWeight.Normal)
                    )
                }
            }
        }
    }
}