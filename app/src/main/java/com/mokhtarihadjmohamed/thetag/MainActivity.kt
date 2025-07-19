package com.mokhtarihadjmohamed.thetag

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.View.HomeScreen
import com.mokhtarihadjmohamed.thetag.View.OnBoarding
import com.mokhtarihadjmohamed.thetag.ui.theme.TheTagTheme
import com.mokhtarihadjmohamed.thetag.ui.theme.background_color

/*
* This is main activity, I'm always use one activity
* and multiple compose and start change between
* them by using navigation lib in purpose to decrease
* requirement and make it easy on the hard ware.
*
* On the NavigationComposable will you fin all screen that will go
* and navigate between.
* */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationComposable()
        }
    }
}

@Composable
fun NavigationComposable() {
    val navController = rememberNavController()
    Scaffold(
        containerColor = background_color
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "HomeScreen",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("OnBoarding") { OnBoarding(navController) }
            composable("HomeScreen") { HomeScreen(navController) }
        }
    }
}