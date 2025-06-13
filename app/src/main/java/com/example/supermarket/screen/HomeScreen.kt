package com.example.supermarket.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.example.supermarket.pages.*

@Composable
fun HomeScreen(modifier: Modifier = Modifier,navController: NavController){
    val navItemList = listOf(
        NavItem("Home",Icons.Default.Home),
        NavItem("Favorite",Icons.Default.Favorite),
        NavItem("Cart",Icons.Default.ShoppingCart),
        NavItem("Profile",Icons.Default.Person)

    )
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar{
                navItemList.forEachIndexed {index, navItem ->
                    NavigationBarItem(
                        selected = index==selectedIndex,
                        onClick =  {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(imageVector = navItem.icon,contentDescription = navItem.label)
                               },
                        label = {
                            Text(text = navItem.label)
                        }
                    )


                }
            }
        }


    ) {
        ContentScreen(modifier = modifier.padding(it),selectedIndex = selectedIndex)
    }
}


@Composable
fun ContentScreen(modifier: Modifier = Modifier,selectedIndex: Int){
    when(selectedIndex){
        0 -> HomePage(modifier)
        1 -> FavoritePage(modifier)
        2 -> CartPage(modifier)
        3 -> ProfilePage(modifier)
    }
}
data class NavItem(
    val label: String,
    val icon: ImageVector
)