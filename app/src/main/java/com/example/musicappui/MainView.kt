package com.example.musicappui

//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musicappui.ui.theme.AccountDialog
import com.example.musicappui.ui.theme.AccountView
import com.example.musicappui.ui.theme.Browser
import com.example.musicappui.ui.theme.Home
import com.example.musicappui.ui.theme.Library
import com.example.musicappui.ui.theme.SubscriptionView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){

    val dialogOpen= remember {
        mutableStateOf(false)
    }
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope:CoroutineScope= rememberCoroutineScope()
    val viewModel:MainViewModel= viewModel()
    val controller:NavController= rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRout=navBackStackEntry?.destination?.route

    val currentScreen= remember {
       viewModel.currentScreen.value
    }
    val title = remember {
        mutableStateOf(currentScreen.title)
    }


    Scaffold (
        bottomBar = {
            if(currentScreen is Screen.DrawerScreen ||currentScreen==Screen.BottomScreen.Home){
                BottomNavigation (modifier=Modifier.height(100.dp)){
                    ScreenInBottom.forEach{
                            item->
                        val isSelected= currentRout==item.bRout
                        val tint=if(isSelected)Color.White else Color.Black
                        BottomNavigationItem(
                            selected = currentRout== item.bRout, onClick = {
                                controller.navigate(item.bRout)
                                title.value=item.bTitle },icon = {
                                Icon(tint=tint,
                                    painter = painterResource(id = item.icon), contentDescription = item.bTitle)
                            },
                            label = { Text(text = item.bTitle,color=tint) }
                            , selectedContentColor = Color.White,
                            unselectedContentColor = Color.Black

                        )
                    }
                }
            }

        },
        topBar = {
            TopAppBar(title = { Text(text = title.value) },
                navigationIcon = { IconButton(onClick = {

                    //open The drawer
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }) {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")
                }})
        },scaffoldState=scaffoldState,
        drawerContent = {
            LazyColumn(modifier=Modifier.padding(16.dp) ) {
                items (ScreensInDrawer){
                    item->
                    DrawerItem(selected = currentRout==item.dRout, item = item) {
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                        if (item.dRout=="add_account"){
                            dialogOpen.value=true
                        }else{
                            controller.navigate(item.dRout)
                            title.value=item.dTitle
                        }
                    }
                }

            }
        }
    ){
        Navigation(navController = controller,viewModel=viewModel, pd = it)
        AccountDialog(dialogOpen = dialogOpen)
    }
}
@Composable
fun DrawerItem(
    selected:Boolean,
    item:Screen.DrawerScreen,
    onDrawerItemClicked :()-> Unit

){
    val background=if (selected) Color.Blue else Color.White
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .background(background)
            .clickable { onDrawerItemClicked() }
    ){
        Icon(painter = painterResource(id = item.icon),
            contentDescription = item.dTitle,
            modifier = Modifier.padding(end = 8.dp, top = 8.dp)
            )
        Text(text = item.dTitle,
            style = MaterialTheme.typography.headlineLarge
        )
    }

}

@Composable
fun Navigation(navController: NavController,viewModel: MainViewModel,pd: PaddingValues){
    NavHost(navController = navController as NavHostController,
        startDestination =Screen.DrawerScreen.Account.route,
        modifier = Modifier.padding(pd) ) {

        composable(Screen.BottomScreen.Home.bRout){
            Home()
        }
        composable(Screen.BottomScreen.Library.bRout){
            Library()
        }
        composable(Screen.BottomScreen.Browser.bRout){
            Browser()
        }

        composable (Screen.DrawerScreen.Account.route  ){
            AccountView()
        }

        composable(Screen.DrawerScreen.Subscription.route) {
            SubscriptionView()
        }


    }
}












