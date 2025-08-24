package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import com.mokhtarihadjmohamed.thetag.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.ui.components.BottomBar
import com.mokhtarihadjmohamed.thetag.ui.components.CustomDropMenu
import com.mokhtarihadjmohamed.thetag.ui.components.PlateRowItem
import com.mokhtarihadjmohamed.thetag.ui.components.TopBar
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

@Composable
fun RestaurantFavorite(navController: NavController) {
    Scaffold(
        containerColor = black_normal,
        topBar = {
            TopBar(
                title = stringResource(R.string.restaurantFavorite_title),
                textColor = white_normal,
                iconColor = white_normal,
                textSize = 18
            ) {
                navController.popBackStack()
            }
        },
        bottomBar = {
            BottomBar(navController){}
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.restaurantFavorite_sub_title),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = white_normal
                    )
                )
                CustomDropMenu(
                    modifier = Modifier,
                    placeholder = "Trier par date",
                    items = listOf("Trier par date", "Trier A to Z"),
                    label = "Trier par date"
                ) { }
            }

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(10) {
                    PlateRowItem(
                        title = "Entrecôte Grillée",
                        description = "Un généreux assortiment de fruits de mer frais, composé de crevettes charnues, d’huîtres savoureuses, de langoustines délicates et d’un tourteau bien garni"
                    )
                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun RestaurantFavoritePreview() {
    RestaurantFavorite(rememberNavController())
}