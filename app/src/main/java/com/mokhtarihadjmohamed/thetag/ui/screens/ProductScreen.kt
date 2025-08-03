package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
import com.mokhtarihadjmohamed.thetag.models.Addition
import com.mokhtarihadjmohamed.thetag.models.Product
import com.mokhtarihadjmohamed.thetag.ui.components.CustomButton
import com.mokhtarihadjmohamed.thetag.ui.components.CustomIconButton
import com.mokhtarihadjmohamed.thetag.ui.components.CustomRadioButton
import com.mokhtarihadjmohamed.thetag.ui.components.MenuItem
import com.mokhtarihadjmohamed.thetag.ui.theme.background_color
import com.mokhtarihadjmohamed.thetag.ui.theme.black_900
import com.mokhtarihadjmohamed.thetag.ui.theme.border_color

/*
* This is ProductScreen:
* 1- it have product information in first
* 2- it have lazy column for addition item
* 3- in bottom have add amount and order button
* 4- in to bar it just have back icon button
* */

@Composable
fun ProductScreen(navController: NavController) {
    val product: Product = Product(
        name = "Burger  - SM Lucena",
        description = "Grillé à la flamme pour un goût inimitable",
        price = 18.0,
        imageURl = "",
        type = "Burgers",
        additions = listOf(
            Addition(
                name = "Tenders",
                price = 1.50
            ),
            Addition(
                name = "Poulet Nature"
            ),
            Addition(
                name = "Cordon bleu"
            ),
            Addition(
                name = "Bacon"
            ),
        )
    )

    var selected by remember { mutableStateOf(0) }
    var amount by remember { mutableStateOf(1) }

    Scaffold(
        modifier = Modifier
            .padding(8.dp),
        containerColor = background_color,
        topBar = {
            Row {
                CustomIconButton(
                    icon = R.drawable.outline_arrow_back_24,
                    borderWidth = 0,
                    borderColor = Color.Transparent,
                    iconSize = 24
                    ) {
                    navController.popBackStack()
                }
                Spacer(
                    modifier = Modifier.weight(
                        1f
                    )
                )
            }
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CustomIconButton(
                        icon = R.drawable.decrease
                    ) {
                        if (amount > 1)
                            amount--
                        else
                            amount = 1
                    }
                    Text(
                        text = amount.toString(),
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    CustomIconButton(
                        icon = R.drawable.increase
                    ) {
                        amount++
                    }
                }
                CustomButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Ajouter 1 au panier | 14.65\$",
                    background = black_900,
                    textColor = background_color
                ) { }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(
                top = innerPadding.calculateTopPadding(),
                bottom = innerPadding.calculateBottomPadding()
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                painter = painterResource(R.drawable.product_image),
                contentDescription = "product image"
            )
            MenuItem(type = product.type)
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Menus",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Savourez notre burger classique \"Whopper\" avec une viande grillée à la flamme, des légumes frais, du fromage fondant et notre sauce signature, le tout dans un pain moelleux",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 16.sp,
                ),
                textAlign = TextAlign.Justify
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "8.8$",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Choisissez votre viande!",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                MenuItem(
                    modifier = Modifier.border(
                        width = 1.dp,
                        color = border_color,
                        shape = RoundedCornerShape(8.dp)
                    ),
                    type = "Obligatoire",
                    icon = R.drawable.double_check
                )
            }
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(product.additions.size) { index ->
                    CustomRadioButton(
                        title = product.additions[index].name,
                        plusPrice = product.additions[index].price,
                        onClick = {
                            selected = index
                        },
                        selected = selected == index
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductScreen() {
    ProductScreen(rememberNavController())
}