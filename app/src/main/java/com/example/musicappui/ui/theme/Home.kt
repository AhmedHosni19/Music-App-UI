package com.example.musicappui.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicappui.R

@Composable
fun Home(){
    val categories= listOf("Hits","Workout","Happy","Romantic","TGIF","Running")
    val grouped= listOf<String>("New Release","Top Rated","Favorites").groupBy {
        it[0]
    }

    LazyColumn {
        grouped.forEach{
            stickyHeader{element->
                Text(text =it.value[0] , modifier = Modifier.padding(16.dp))
                LazyRow {
                    items(categories){ cat ->
                        BrowserItem(cat=cat, drawable = R.drawable.baseline_apps_24)
                    }
                }
            }
        }
    }
}

@Composable
fun BrowserItem(cat :String,drawable:Int){
    Card(modifier = Modifier
        .padding(16.dp)
        .size(200.dp),
        border = BorderStroke(4.dp, color = Color.DarkGray)) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){

                Text(text = cat)
                Image(
                    painter = painterResource(id = R.drawable.baseline_apps_24),
                    contentDescription = cat
                )

            }
        }
    }
}
