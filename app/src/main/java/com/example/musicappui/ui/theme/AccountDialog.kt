package com.example.musicappui.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.primarySurface
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun AccountDialog(dialogOpen:MutableState<Boolean>){
    if (dialogOpen.value){
        AlertDialog(onDismissRequest =
        { dialogOpen.value=false},
            confirmButton = {
                TextButton(onClick = {dialogOpen.value=false},
                   ) {
                    Text(text = "Confirm")
                    
                }
                 },
            dismissButton =  {
                TextButton(onClick = {dialogOpen.value=false},
                ) {
                    Text(text = "Dismiss")

                }
            },
            title = {
              Text(text = "Add Account")
            },
            text = {
                Column (
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .wrapContentHeight(),
                    verticalArrangement = Arrangement.Center
                ){
                    TextField(value = "", onValueChange ={
                    } ,Modifier.fillMaxWidth(),
                        label = { Text(text = "Email")}
                    )
                    TextField(value = "", onValueChange ={
                    } ,Modifier.padding(top = 8.dp).fillMaxWidth(),
                        label = { Text(text = "PassWord")})
                }
            },
            modifier = Modifier.fillMaxWidth().background(MaterialTheme.colors.primarySurface)
                .padding(8.dp),
            shape = RoundedCornerShape(5.dp),
            properties = DialogProperties(
                dismissOnClickOutside = true,
                dismissOnBackPress = true
            ),


        )
    }
}
