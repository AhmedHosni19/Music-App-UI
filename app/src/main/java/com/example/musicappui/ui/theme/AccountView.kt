package com.example.musicappui.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Divider
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Text
import com.example.musicappui.R

@Composable
fun AccountView() {
    Column (modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()){
        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
            ){
            Row {
                Icon(imageVector = Icons.Default.AccountCircle,
                    contentDescription = "",
                    modifier = Modifier.padding(end=8.dp))
                Column {
                    Text(text = "Ahmed Hosni", style = TextStyle(color = Color.Black))
                    Text(text = "@gmail", style = TextStyle(color = Color.Black))
                }
            }

            IconButton(onClick = { }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription ="" )
            }
        }
        Row (modifier = Modifier
            .fillMaxWidth()){
            Icon(painter = painterResource(id = R.drawable.baseline_music_note_24),
                contentDescription ="" ,
                modifier = Modifier.padding(end=8.dp))
            Text(text = "My Music", style = TextStyle(color = Color.Black))
        }
        Divider()
    }
}
