package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
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

@Composable
fun BottomBar(navController: NavController, onClick: () -> Unit) {

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Favorite,
    )

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 56.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    drawLine(
                        color = grey_light_active,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = 2f
                    )
                },
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
                                white_normal
                            } else {
                                grey_normal
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
                                white_normal
                            } else {
                                grey_dark
                            }
                        )
                    }
                )

            }
        }

        CustomIconButton(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = -42.dp),
            icon = R.drawable.waiter_call,
            background = white_normal,
            borderColor = Color.Transparent,
            roundedCorner = 9999,
            iconSize = 76
        ) { }
    }
}


@Preview
@Composable
fun BottomBarPreview() {
    BottomBar(rememberNavController()) {

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

    object Favorite : NavigationItem(
        "RestaurantFavorite",
        R.drawable.favorite,
        "Favorite",
    )

    object Home : NavigationItem(
        "RestaurantMenu",
        R.drawable.home,
        "Accueil",
    )
}
