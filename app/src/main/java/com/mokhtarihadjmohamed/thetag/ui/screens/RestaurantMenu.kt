package com.mokhtarihadjmohamed.thetag.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.components.BottomBar
import com.mokhtarihadjmohamed.thetag.ui.components.CustomDropMenu
import com.mokhtarihadjmohamed.thetag.ui.components.MenuItem
import com.mokhtarihadjmohamed.thetag.ui.components.PlateCardItem
import com.mokhtarihadjmohamed.thetag.ui.components.PlateRowItem
import com.mokhtarihadjmohamed.thetag.ui.components.TopBar
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.yellow_light
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@Composable
fun RestaurantMenu(navController: NavController) {

    data class Plate(
        val title: String,
        val description: String
    )

    val menusList: List<String> =
        stringArrayResource(R.array.menus).toCollection(destination = ArrayList())

    val plates = listOf(
        Plate(
            title = "Entrecôte Grillée",
            description = "Un généreux assortiment de fruits de mer frais, composé de crevettes charnues, d’huîtres savoureuses, de langoustines délicates et d’un tourteau bien garni"
        ),
        Plate(
            title = "Plateau de Fruits de Mer",
            description = "Crevettes, huîtres, langoustines et tourteau préparés avec soin"
        ),
        Plate(
            title = "Saumon Gravlax",
            description = "Délicatement mariné avec des herbes fraîches et du citron"
        )
    )

    var itemSelected by remember { mutableStateOf("") }

    val pagerState = rememberPagerState(pageCount = { plates.size })
    var pagerDragAmount by remember { mutableStateOf(0f) }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        containerColor = black_normal,
        topBar = {
            TopBar(
                title = stringResource(R.string.restaurantMenu_title),
                textColor = white_normal,
                iconColor = white_normal,
                textSize = 18
            ) {
                navController.popBackStack()
            }
        },
        bottomBar = {
            BottomBar(navController) {}
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(
                top = paddingValues.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp,
                bottom = paddingValues.calculateBottomPadding()
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 24.dp,
                        spotColor = yellow_light,
                        shape = RoundedCornerShape(16.dp),
                        clip = false
                    )
                    .background(
                        color = black_normal,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .border(
                        width = .5.dp,
                        color = grey_normal,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(12.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(menusList) { item ->
                    MenuItem(
                        modifier = Modifier
                            .background(
                                if (itemSelected == item)
                                    white_normal
                                else
                                    black_normal,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        type = item,
                        textColor = if (itemSelected == item)
                            black_normal
                        else
                            white_normal,
                    ) {
                        itemSelected = item
                    }
                }
            }

            HorizontalPager(
                state = pagerState,
                flingBehavior = PagerDefaults.flingBehavior(
                    state = pagerState,
                    pagerSnapDistance = PagerSnapDistance.atMost(0)
                ),
                contentPadding = PaddingValues(horizontal = 14.dp),
                pageSpacing = 4.dp
            ) { page ->
                val plate = plates[page]
                PlateCardItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .pointerInput(Unit) {
                            detectHorizontalDragGestures(onHorizontalDrag = { _, dragAmount ->
                                pagerDragAmount = dragAmount
                            }, onDragEnd = {
                                val nextPage =
                                    if (pagerDragAmount < 0) pagerState.currentPage + 1 else pagerState.currentPage - 1
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(nextPage)
                                }
                            })
                        }
                        .graphicsLayer {
                            val pageOffSet = (
                                    (pagerState.currentPage - page) + pagerState
                                        .currentPageOffsetFraction
                                    ).absoluteValue
                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffSet.coerceIn(0f, 1f)
                            )
                            scaleY = lerp(
                                start = 0.75f,
                                stop = 1f,
                                fraction = 1f - pageOffSet.coerceIn(0f, 1f)
                            )
                        },
                    title = plate.title,
                    description = plate.description,
                    borderColor = if (pagerState.currentPage != page) Color.Transparent else null
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RestaurantMenuPreview() {
    RestaurantMenu(rememberNavController())
}