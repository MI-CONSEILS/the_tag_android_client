package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.components.CustomButton
import com.mokhtarihadjmohamed.thetag.ui.components.CustomIconButton
import com.mokhtarihadjmohamed.thetag.ui.components.IconPosition
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

@Composable
fun RestaurantHomeScreen(navController: NavController) {

    val btn_list = listOf(
        "Menu",
        "Appeler le serveur",
        "Demander l’addition ",
        "Plus d’information"
    )
    val btn_icon = listOf(
        R.drawable.menu,
        R.drawable.waiter,
        R.drawable.addition,
        R.drawable.information
    )

    Scaffold(
        containerColor = black_normal,
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomIconButton(
                    borderColor = Color.Transparent,
                    iconColor = white_normal,
                    icon = R.drawable.favorite,
                    iconSize = 28
                ) {

                }
                Text(
                    text = stringResource(R.string.restaurantHomeScreen_hello),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = white_normal
                    )
                )
                CustomIconButton(
                    borderColor = Color.Transparent,
                    iconColor = white_normal,
                    icon = R.drawable.messages,
                    iconSize = 28
                ) {

                }
            }
        }
    ) { paddingValues ->

        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(R.drawable.restuarant_home_background),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, black_normal),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )

        Column(
            modifier = Modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    start = 16.dp,
                    end = 16.dp,
                    bottom = paddingValues.calculateBottomPadding()
                )
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.restaurantHomeScreen_hello),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 42.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = white_normal
                )
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Julien Lefèvre",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 28.sp,
                    color = white_normal
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        black_normal.copy(alpha = .8f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                repeat(4) {
                    CustomButton(
                        modifier = Modifier.fillMaxWidth(),
                        label = btn_list[it],
                        borderColor = grey_normal,
                        iconEnd = btn_icon[it],
                        iconColor = white_normal,
                        iconPosition = IconPosition.START,
                        borderRadios = 18,
                        textSize = 18,
                        textAlign = TextAlign.Start,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) { }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }

    }

}

@Preview(showBackground = true)
@Composable
fun RestaurantHomeScreenPreview() {
    RestaurantHomeScreen(rememberNavController())
}