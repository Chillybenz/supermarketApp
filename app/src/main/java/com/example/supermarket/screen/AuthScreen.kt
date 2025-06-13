package com.example.supermarket.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.supermarket.R
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.draw.clip
import androidx.navigation.NavHostController

@Composable
fun AuthScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(25.dp))
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Make Supermarket Great Again",
            style = TextStyle(
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("login")
        },
            modifier = Modifier.fillMaxWidth().
            height(60.dp)
        ){
            Text(text = "login", fontSize = 22.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(onClick = {
            navController.navigate("signup")
        },
            modifier = Modifier.fillMaxWidth().
            height(60.dp)
        ){
            Text(text = "Sign-Up", fontSize = 22.sp)
        }
    }
}
