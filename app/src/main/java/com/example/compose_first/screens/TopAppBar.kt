package com.example.compose_first.screens

import DrawerContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_first.R
import com.example.compose_first.ui.theme.DarkThemeTypography
import com.example.compose_first.ui.theme.White
import kotlinx.coroutines.launch
import java.lang.reflect.Type


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    title: String,
    onMenuClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = DarkThemeTypography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        navigationIcon = {
            Image(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(40.dp)
                    .clickable(onClick = onMenuClick),
                painter = painterResource(R.drawable.ic_hamburger),
                contentDescription = "Menu",
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
            )
        },
        actions = {
            Image(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(30.dp),
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Search",
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}

