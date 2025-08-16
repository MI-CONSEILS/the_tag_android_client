package com.mokhtarihadjmohamed.thetag

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.ui.screens.AdditionProductScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.BasketScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.HomeScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.OnBoarding
import com.mokhtarihadjmohamed.thetag.ui.screens.OrderScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.OrderType
import com.mokhtarihadjmohamed.thetag.ui.screens.PaymentScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.ProductScreen
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

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
        containerColor = white_normal
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "OnBoarding",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("OnBoarding") { OnBoarding(navController) }
            composable("OrderType") { OrderType(navController) }
            composable("HomeScreen") { HomeScreen(navController) }
            composable("OrderScreen") { OrderScreen(navController) }
            composable("ProductScreen") { ProductScreen(navController) }
            composable("BasketScreen") { BasketScreen(navController) }
            composable("AdditionProductScreen") { AdditionProductScreen(navController) }
            composable("PaymentScreen") { PaymentScreen(navController) }
        }
    }
}