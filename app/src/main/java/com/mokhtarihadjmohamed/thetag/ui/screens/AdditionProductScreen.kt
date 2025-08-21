package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.data.remote.entities.Product
import com.mokhtarihadjmohamed.thetag.ui.components.CustomButton
import com.mokhtarihadjmohamed.thetag.ui.components.CustomGridItem
import com.mokhtarihadjmohamed.thetag.ui.components.TopBar
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

@Composable
fun AdditionProductScreen(navController: NavController) {

    Scaffold(
        containerColor = white_normal,
        topBar = {
            TopBar(title = "Vous aimerez aussi…") {
                navController.popBackStack()
            }
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .drawBehind {
                        val strokeWidth = 2.dp.toPx()
                        drawLine(
                            color = grey_light,
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = strokeWidth
                        )
                    }
                    .padding(16.dp),
            ) {
                CustomButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Complétez votre commande",
                    background = black_normal,
                    textColor = white_normal
                ) {
                    navController.navigate("PaymentScreen")
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(
                    top = innerPadding.calculateTopPadding() + 8.dp,
                    bottom = innerPadding.calculateBottomPadding(),
                    start = 8.dp,
                    end = 8.dp
                )
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row {
                Spacer(Modifier.weight(1f))
                LazyVerticalGrid(
                    modifier = Modifier
                        .padding(bottom = innerPadding.calculateBottomPadding())
                        .weight(3f),
                    columns = GridCells.Adaptive(minSize = 128.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(2) {
                        CustomGridItem(
                            modifier = Modifier,
                            onClick = {
                                navController.navigate("ProductScreen")
                            }, product = Product(
                                name = "Coca-Cola",
                                description = "",
                                price = 18.0,
                                imageURl = "",
                                type = "Burgers"
                            ),
                            icon = R.drawable.baseline_add_circle_24,
                            imageSize = 200,
                            textSize = 18,
                            priceSize = 16,
                            image = R.drawable.coca
                        )
                    }
                }
                Spacer(Modifier.weight(1f))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AdditionProductScreenPreview() {
    val nav = rememberNavController()
    AdditionProductScreen(nav)
}