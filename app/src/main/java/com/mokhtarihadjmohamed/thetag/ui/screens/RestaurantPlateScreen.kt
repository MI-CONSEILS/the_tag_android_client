package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.components.CustomIconButton
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.yellow_light

@Composable
fun RestaurantPlateScreen(navController: NavController) {
    Scaffold(
        containerColor = black_normal
    ) { paddingValues ->

        Column(
            modifier = Modifier.padding(
                top = paddingValues.calculateTopPadding() + 8.dp,
                bottom = paddingValues.calculateBottomPadding(),
                end = 16.dp,
                start = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .clip(RoundedCornerShape(28.dp))
            ) {
                Image(
                    painter = painterResource(R.drawable.plate_image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomIconButton(
                        icon = R.drawable.outline_arrow_back_24,
                        iconColor = white_normal,
                        iconSize = 18,
                        background = black_normal,
                        borderColor = Color.Transparent
                    ) {

                    }
                    CustomIconButton(
                        icon = R.drawable.share,
                        iconColor = white_normal,
                        iconSize = 18,
                        background = black_normal,
                        borderColor = Color.Transparent
                    ) {

                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(grey_normal, RoundedCornerShape(24.dp))
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Entrées ",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            fontSize = 16.sp,
                            color = grey_light_active
                        )
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Agneau du Chef",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = white_normal
                        )
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "98.99€",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            fontSize = 18.sp,
                            color = white_normal
                        )
                    )
                }
                CustomIconButton(
                    icon = R.drawable.favorite,
                    iconColor = white_normal,
                    iconSize = 20,
                    borderColor = grey_light_active,
                    roundedCorner = 12,
                    borderWidth = 1,
                    paddingValues = PaddingValues(horizontal = 20.dp, vertical = 16.dp)
                ) {

                }
            }
            Text(
                "Descreption",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = grey_light_active
                )
            )
            Text(
                "Un généreux assortiment de fruits de mer frais, composé de crevettes charnues, d’huîtres savoureuses, de langoustines délicates et d’un tourteau bien garni. Idéal pour les amateurs de saveurs marines, à déguster avec un filet de citron et une sauce maison, Idéal pour les amateurs de saveurs marines, à déguster avec un filet de citron et une sauce maison Idéal pour les amateurs de saveurs marines.",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 16.sp,
                    color = grey_light_active
                )
            )
        }
    }
}


@Preview(showBackground = false)
@Composable
fun RestaurantPlateScreen() {
    RestaurantPlateScreen(rememberNavController())
}