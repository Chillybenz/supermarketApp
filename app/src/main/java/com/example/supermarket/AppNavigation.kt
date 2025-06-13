package com.example.supermarket

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.supermarket.screen.AuthScreen
import com.example.supermarket.screen.HomeScreen
import com.example.supermarket.screen.LoginScreen
import com.example.supermarket.screen.SignupScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "auth") {
        composable("home"){
            HomeScreen(modifier = modifier, navController = navController)
        }
        composable("auth"){
            AuthScreen(modifier,navController)
        }
        composable("login"){
            LoginScreen(modifier)
        }
        composable("Signup"){
            SignupScreen(modifier)
        }
    }
}