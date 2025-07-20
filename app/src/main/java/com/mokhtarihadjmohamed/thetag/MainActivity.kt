package com.mokhtarihadjmohamed.thetag

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.model.Notification
import com.mokhtarihadjmohamed.thetag.view.HomeScreen
import com.mokhtarihadjmohamed.thetag.view.OnBoarding
import com.mokhtarihadjmohamed.thetag.ui.theme.background_color
import com.mokhtarihadjmohamed.thetag.view.OrderScreen

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
            composable("OrderScreen") { OrderScreen(navController) }
        }
    }
}