package com.mokhtarihadjmohamed.thetag

import android.os.Bundle
import android.util.Log
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
import com.mokhtarihadjmohamed.thetag.data.datastore.SettingsDataStore
import com.mokhtarihadjmohamed.thetag.ui.screens.AccountEditInfo
import com.mokhtarihadjmohamed.thetag.ui.screens.AccountSetting
import com.mokhtarihadjmohamed.thetag.ui.screens.AdditionProductScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.BasketScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.HomeScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.LogInScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.MapScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.NfcScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.OnBoarding
import com.mokhtarihadjmohamed.thetag.ui.screens.OrderScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.OrderType
import com.mokhtarihadjmohamed.thetag.ui.screens.OtpScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.PaymentScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.PhoneNumberScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.ProductScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.RegisterScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.RestaurantChatScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.RestaurantFavorite
import com.mokhtarihadjmohamed.thetag.ui.screens.RestaurantHomeScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.RestaurantMenu
import com.mokhtarihadjmohamed.thetag.ui.screens.RestaurantPlateScreen
import com.mokhtarihadjmohamed.thetag.ui.screens.RestaurantPlusInformation
import com.mokhtarihadjmohamed.thetag.ui.screens.SearchEstablishmentScreen
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
    private lateinit var startScreen: String

    override fun onStart() {
        super.onStart()
        val ds = SettingsDataStore(this)

        CoroutineScope(Dispatchers.IO).launch {
            ds.jwtToken.collect { token ->
                startScreen = if (token != null) "NfcScreen" else "OnBoarding"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationComposable(startScreen)
        }
    }
}

@Composable
fun NavigationComposable(startScreen: String) {
    val navController = rememberNavController()
    Scaffold(
        containerColor = white_normal
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startScreen,
            modifier = Modifier.padding(innerPadding)
        ) {
            // TODO Auth
            composable("OnBoarding") { OnBoarding(navController) }
            composable("LogInScreen") { LogInScreen(navController) }
            composable("RegisterScreen") { RegisterScreen(navController) }
            composable("PhoneNumberScreen") { PhoneNumberScreen(navController) }
            composable("OtpScreen") { OtpScreen(navController) }

            // TODO FastFood Screen
            composable("OrderType") { OrderType(navController) }
            composable("HomeScreen") { HomeScreen(navController) }
            composable("OrderScreen") { OrderScreen(navController) }
            composable("ProductScreen") { ProductScreen(navController) }
            composable("BasketScreen") { BasketScreen(navController) }
            composable("AdditionProductScreen") { AdditionProductScreen(navController) }
            composable("PaymentScreen") { PaymentScreen(navController) }

            // TODO NFC Screen
            composable("NfcScreen") { NfcScreen(navController) }
            composable("SearchEstablishmentScreen") { SearchEstablishmentScreen(navController) }
            composable("MapScreen") { MapScreen(navController) }
            composable("AccountSetting") { AccountSetting(navController) }
            composable("AccountEditInfo") { AccountEditInfo(navController) }

            // TODO Restaurant Screen
            composable("RestaurantHomeScreen") { RestaurantHomeScreen(navController) }
            composable("RestaurantChatScreen") { RestaurantChatScreen(navController) }
            composable("RestaurantPlusInformation") { RestaurantPlusInformation(navController) }
            composable("RestaurantFavorite") { RestaurantFavorite(navController) }
            composable("RestaurantMenu") { RestaurantMenu(navController) }
            composable("RestaurantPlateScreen") { RestaurantPlateScreen(navController) }
        }
    }
}