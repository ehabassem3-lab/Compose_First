package com.example.compose_first.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun News(
    navController: NavController){

    val colorScheme = MaterialTheme.colorScheme
    Scaffold(
        modifier = Modifier.fillMaxSize().background(colorScheme.background),
        topBar = {
            TopAppBar("News")
        }
    ) {


    }
}