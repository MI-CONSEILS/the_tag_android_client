package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.data.remote.entities.Location
import com.mokhtarihadjmohamed.thetag.ui.components.CustomTextField
import com.mokhtarihadjmohamed.thetag.ui.components.LocationItem
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

@Composable
fun MapScreen(navController: NavController, maxImageSize: Dp = 300.dp) {
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

    val locations: List<Location> = arrayListOf(
        Location(
            title = "The Tag - Cesson",
            status = "Ouvert",
            close = "Ferme a 22:00",
            distance = "8.3KM",
            address = "Zac Plaine Du Moulin A Vent, 77240 Cesson"
        ),
        Location(
            title = "The Tag - Cesson",
            status = "Ouvert",
            close = "Ferme a 22:00",
            distance = "8.3KM",
            address = "Zac Plaine Du Moulin A Vent, 77240 Cesson"
        ),
        Location(
            title = "The Tag - Cesson",
            status = "Ouvert",
            close = "Ferme a 22:00",
            distance = "8.3KM",
            address = "Zac Plaine Du Moulin A Vent, 77240 Cesson"
        ),
    )
    Scaffold(
        containerColor = black_normal
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = innerPadding.calculateBottomPadding()
                )
        ) {
            Box(
                modifier = Modifier
                    .nestedScroll(nestedScrollConnection)
            ) {
                // TODO grid of products
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16 .dp)
                        .offset {
                            IntOffset(0, currentImageSize.roundToPx())
                        }, verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "The Tag",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = white_normal
                        )
                    )

                    LazyColumn(
                        modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding()),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        items(locations) { location ->
                            LocationItem(
                                location = location
                            ) { }
                        }
                    }
                }

                // TODO Header section
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .graphicsLayer {
                            scaleY = imageScale
                            translationY = -(maxImageSize.toPx() - currentImageSize.toPx()) / 2f
                        },
                ) {
                    // TODO Card Ads
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = white_normal,
                        )
                    ) {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(R.drawable.map),
                            contentDescription = "image ads"
                        )
                    }

                    // TODO Search field
                    CustomTextField(
                        modifier = Modifier
                            .padding(16.dp)
                            .offset(y = 56.dp)
                            .border(
                                1.dp, Color.Gray, RoundedCornerShape(8.dp)
                            )
                            .background(black_normal, RoundedCornerShape(8.dp))
                            .padding(12.dp)
                            .fillMaxWidth(), value = search,
                        onValueChange = {
                            search = it
                        },
                        icon = R.drawable.search,
                        textColor = white_normal,
                        iconColor = grey_light_active,
                        placeholder = "Chercher un établissement"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun MapScreenPreview() {
    MapScreen(rememberNavController())
}