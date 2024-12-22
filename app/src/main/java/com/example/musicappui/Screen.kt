package com.example.musicappui

import androidx.annotation.DrawableRes

sealed class Screen (val title:String,val route:String){

    sealed class BottomScreen(val bTitle:String,val bRout:String,@DrawableRes val icon:Int)
        :Screen(bTitle,bRout) {
        data object Home:BottomScreen("Home","home",R.drawable.ic_subscribe)
        data object Library:BottomScreen("Library","library", R.drawable.baseline_library_music_24)
        data object Browser:BottomScreen("Browser","browser", R.drawable.baseline_apps_24)
        }

    sealed class DrawerScreen(val dTitle:String,val dRout:String,@DrawableRes val icon:Int)
        :Screen(dTitle,dRout) {
        data object Account:DrawerScreen(
                dTitle = "Account",
                dRout = "account",
                icon = R.drawable.ic_account
            )
        data object Subscription:DrawerScreen(
            dTitle = "Subscription",
            dRout = "subscribe",
            icon = R.drawable.ic_subscribe
        )
        data object AddAccount:DrawerScreen(
            dTitle = "Add Account",
            dRout = "add_account",
            icon = R.drawable.baseline_person_add_alt_1_24
        )

    }
}
val ScreenInBottom= listOf(
    Screen.BottomScreen.Home,
    Screen.BottomScreen.Browser,
    Screen.BottomScreen.Library
)
val ScreensInDrawer= listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.Subscription,
    Screen.DrawerScreen.AddAccount
)