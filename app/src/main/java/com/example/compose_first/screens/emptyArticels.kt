package com.example.compose_first.screens

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import com.example.compose_first.ui.theme.DarkThemeTypography
import org.intellij.lang.annotations.JdkConstants

@Composable
fun emptyArticles(massage : String){
    val colorScheme  = MaterialTheme.colorScheme
    Box(
        modifier = Modifier.fillMaxSize().background(colorScheme.background),
        contentAlignment = Alignment.Center
    ){
        Text(
            text =  massage ,
            style = DarkThemeTypography.headlineLarge.copy(color =  colorScheme.onBackground) ,

            )

    }




}