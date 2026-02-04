package com.example.compose_first

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_first.ui.theme.Compose_FirstTheme

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            first()

        }
    }
}


@Composable
fun first(){

    var names  by remember { mutableStateOf(listOf<String>()) }
    var name by remember { mutableStateOf("") }
    Column(

        modifier = Modifier.fillMaxSize().background(Color.White).padding(30.dp)
       , horizontalAlignment = Alignment.CenterHorizontally,


        ) {
           Row() {
               OutlinedTextField(value = name,onValueChange  = { text ->
                   name = text

               },modifier = Modifier.weight(1f) )
               Button(

                   onClick ={

                           names = names +name
                           name = ""


                            },

               )
               {

                   Text("Add Name ")


               }

           }
        Spacer(modifier = Modifier.width(20.dp))
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(names){ currenitems->

                Text(
                    text = currenitems,
                    fontSize = 200.sp,
                    color = Color.Black
                )
                HorizontalDivider()
                VerticalDivider()


        }



        }










    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_FirstTheme {
        first()

    }
}