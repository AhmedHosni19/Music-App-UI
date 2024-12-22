package com.example.musicappui.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Divider
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SubscriptionView(){
    Column (modifier = Modifier.height(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Manage Subscription")
        Card (modifier = Modifier.padding(8.dp)){

                Column (modifier = Modifier.padding(8.dp)){
                    Text(text = "Musical")
                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                        Text(text = "Free Tier")
                        TextButton(onClick = {  }) {
                            Row{
                                Text(text = "See All Plans")
                                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                    contentDescription = "")
                            }
                            
                        }
                    }
                    Divider()
                    Row (modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)){
                        Icon(imageVector = Icons.Default.AccountBox,
                            contentDescription = "")
                        Text(text = "Get a Plan")
                    }
                }
        }
    }
}

