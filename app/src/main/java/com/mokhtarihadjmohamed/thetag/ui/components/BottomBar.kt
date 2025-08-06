package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_dark
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal


/*
* This composable is for bottom navigation item
* it have multiple layer start with main fun call bottomBar in sid will find
* list for items in bar and thar from the Navigation item in the bottom
* that for help us to make the declaration easy and understandable
* */
@Composable
fun BottomBar(navController: NavController) {

    val items = listOf(
        NavigationItem.Menu,
        NavigationItem.Commandes,
    )

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route


    BottomAppBar(
        modifier = Modifier.shadow(14.dp),
        containerColor = white_normal,
        contentColor = grey_normal,
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items.forEachIndexed { index, item ->

                val selected = currentRoute == item.route

                NavigationBarItem(
                    alwaysShowLabel = true,
                    icon = {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = item.route,
                            modifier = Modifier.size(24.dp),
                            tint = if (selected) {
                                grey_dark
                            } else {
                                grey_light_active
                            },
                        )
                    },
                    selected = false,
                    onClick = {
                        if (currentRoute != item.route) {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    label = {
                        Text(
                            text = item.title, style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.inter_medium)),
                                textAlign = TextAlign.Center,
                            ),
                            color = if (selected) {
                                grey_dark
                            } else {
                                grey_light_active
                            }
                        )
                    }
                )

            }
        }
    }
}

// TODO Navigation item declaration
sealed class NavigationItem(var route: String, val icon: Int, val title: String) {
    object Menu : NavigationItem(
        "HomeScreen",
        R.drawable.menu,
        "Menu",
    )

    object Commandes : NavigationItem(
        "OrderScreen",
        R.drawable.command,
        "Commandes",
    )
}
