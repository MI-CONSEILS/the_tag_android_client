package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.components.BottomBar
import com.mokhtarihadjmohamed.thetag.ui.components.CustomGridItem
import com.mokhtarihadjmohamed.thetag.ui.components.TopBar
import com.mokhtarihadjmohamed.thetag.models.Product
import com.mokhtarihadjmohamed.thetag.ui.components.CustomizableSearchBar
import com.mokhtarihadjmohamed.thetag.ui.components.MenuItem
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_dark
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal


/*
* This is home screen you will find:
* 1- in the top bar that have icon off cart and chat and name category.
* 2- after that you will find search where we user customTextFiled.
* 3- after that will see category icon or menu icon and we user lazyrow and text in it.
* 4- after that menu list that I user gridItem.
* 5- in bottom will find navigation bar that will tack us to order list
* and when we scrolling the header section is go away in
* the top off screen is doing by nestedScroll
* */

@Composable
fun HomeScreen(
    navController: NavController, maxImageSize: Dp = 200.dp,
) {

    var currentImageSize by remember { mutableStateOf(maxImageSize) }
    var imageScale by remember { mutableFloatStateOf(1f) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                // Calculate the change in image size based on scroll delta
                val delta = available.y
                val newImageSize = currentImageSize + delta.dp
                val previousImageSize = currentImageSize

                // Constrain the image size within the allowed bounds
                currentImageSize = newImageSize.coerceIn(0.dp, maxImageSize)
                val consumed = currentImageSize - previousImageSize

                // Calculate the scale for the image
                imageScale = currentImageSize / maxImageSize

                // Return the consumed scroll amount
                return Offset(0f, consumed.value)
            }
        }
    }

    var search by remember { mutableStateOf("") }

    val allItems =
        listOf("Chocolate boba", "grilled beef burger", "honey bee cake", "classic momos")
    var filteredItems by rememberSaveable { mutableStateOf(allItems) }

    val menusList: List<String> =
        stringArrayResource(R.array.menus).toCollection(destination = ArrayList())

    var isExpand by rememberSaveable { mutableStateOf(false) }

    val products: List<Product> = arrayListOf(
        Product(
            name = "Burger  - SM Lucena",
            description = "Grillé à la flamme pour un goût inimitable",
            price = 18.0,
            imageURl = "",
            type = "Burgers"
        ),
        Product(
            name = "Burger  - SM Lucena",
            description = "Grillé à la flamme pour un goût inimitable",
            price = 18.0,
            imageURl = "",
            type = "Burgers"
        ),
        Product(
            name = "Burger  - SM Lucena",
            description = "Grillé à la flamme pour un goût inimitable",
            price = 18.0,
            imageURl = "",
            type = "Burgers"
        ),
        Product(
            name = "Burger  - SM Lucena",
            description = "Grillé à la flamme pour un goût inimitable",
            price = 18.0,
            imageURl = "",
            type = "Burgers"
        ),
        Product(
            name = "Burger  - SM Lucena",
            description = "Grillé à la flamme pour un goût inimitable",
            price = 18.0,
            imageURl = "",
            type = "Burgers"
        ),
        Product(
            name = "Burger  - SM Lucena",
            description = "Grillé à la flamme pour un goût inimitable",
            price = 18.0,
            imageURl = "",
            type = "Burgers"
        ),
        Product(
            name = "Burger  - SM Lucena",
            description = "Grillé à la flamme pour un goût inimitable",
            price = 18.0,
            imageURl = "",
            type = "Burgers"
        ),
        Product(
            name = "Burger  - SM Lucena",
            description = "Grillé à la flamme pour un goût inimitable",
            price = 18.0,
            imageURl = "",
            type = "Burgers"
        ),
        Product(
            name = "Burger  - SM Lucena",
            description = "Grillé à la flamme pour un goût inimitable",
            price = 18.0,
            imageURl = "",
            type = "Burgers"
        ),
        Product(
            name = "Burger  - SM Lucena",
            description = "Grillé à la flamme pour un goût inimitable",
            price = 18.0,
            imageURl = "",
            type = "Burgers"
        ),
        Product(
            name = "Burger  - SM Lucena",
            description = "Grillé à la flamme pour un goût inimitable",
            price = 18.0,
            imageURl = "",
            type = "Burgers"
        ),
        Product(
            name = "Burger  - SM Lucena",
            description = "Grillé à la flamme pour un goût inimitable",
            price = 18.0,
            imageURl = "",
            type = "Burgers"
        ),
        Product(
            name = "Burger  - SM Lucena",
            description = "Grillé à la flamme pour un goût inimitable",
            price = 18.0,
            imageURl = "",
            type = "Burgers"
        )
    )

    Scaffold(
        topBar = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TopBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    title = "Burger King",
                    onBasketClick = {
                        navController.navigate("BasketScreen")
                    },
                    onChatClick = {})
            }
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .fillMaxSize(),
        containerColor = white_normal
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding() + 8.dp,
                    bottom = innerPadding.calculateBottomPadding()
                )
        ) {
            // TODO Search field
            CustomizableSearchBar(
                modifier = Modifier
                    .border(
                        1.dp, Color.Gray, RoundedCornerShape(8.dp)
                    )
                    .padding(12.dp)
                    .fillMaxWidth(), query = search, onQueryChange = {
                    search = it
                }, onSearch = { query ->
                    filteredItems = if (query.isBlank()) {
                        allItems
                    } else {
                        allItems.filter { it.contains(query, ignoreCase = true) }
                    }
                }, searchResults = filteredItems, onResultClick = {
                    isExpand = false
                }, onExpand = {
                    isExpand = it
                }, leadingContent = {
                    Icon(
                        painter = painterResource(R.drawable.notice),
                        contentDescription = "card icon",
                        modifier = Modifier.size(21.dp),
                        tint = grey_dark
                    )
                })

            Box(
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                    )
                    .nestedScroll(nestedScrollConnection)
                    .blur(radius = if (isExpand) 12.dp else 0.dp)
                    .offset(y = 56.dp),
            ) {
                // TODO grid of products
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .offset {
                            IntOffset(0, currentImageSize.roundToPx())
                        }, verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(), text = "Menus", style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    LazyVerticalGrid(
                        modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding()),
                        columns = GridCells.Adaptive(minSize = 128.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(products) { product ->
                            CustomGridItem(
                                onClick = {
                                    navController.navigate("ProductScreen")
                                }, product = product
                            )
                        }
                    }
                }

                // TODO Header section
                Column(
                    Modifier
                        .fillMaxWidth()
                        .graphicsLayer {
                            scaleY = imageScale
                            translationY = -(maxImageSize.toPx() - currentImageSize.toPx()) / 2f
                        },
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // TODO Card Ads
                    Card(
                        modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(
                            containerColor = white_normal,
                        )
                    ) {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(R.drawable.ads),
                            contentDescription = "image ads"
                        )
                    }
                    // TODO Menus bar
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        items(menusList) { item ->
                            MenuItem(type = item)
                        }
                    }
                }
            }
        }
    }
}