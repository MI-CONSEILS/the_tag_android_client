package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
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
import com.mokhtarihadjmohamed.thetag.data.remote.entities.Addition
import com.mokhtarihadjmohamed.thetag.data.remote.entities.Product
import com.mokhtarihadjmohamed.thetag.ui.components.CustomButton
import com.mokhtarihadjmohamed.thetag.ui.components.CustomIconButton
import com.mokhtarihadjmohamed.thetag.ui.components.CustomRadioButton
import com.mokhtarihadjmohamed.thetag.ui.components.MenuItem
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

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

    var selected by remember { mutableStateOf<Addition?>(null) }
    var amount by remember { mutableStateOf(1) }

    Scaffold(
        containerColor = white_normal,
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
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
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
                    background = black_normal,
                    textColor = white_normal
                ) { }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    start = 8.dp,
                    bottom = innerPadding.calculateBottomPadding() + 4.dp,
                    end = 8.dp,
                )
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                painter = painterResource(R.drawable.product_image),
                contentDescription = "product image"
            )
            MenuItem(type = product.type){}
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
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Choisissez votre viande!",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Choisissez-en 1.",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = grey_light_active
                        )
                    )
                }
                MenuItem(
                    modifier = Modifier.border(
                        width = 1.dp,
                        color = grey_light,
                        shape = RoundedCornerShape(8.dp)
                    ),
                    type = "Obligatoire",
                    icon = R.drawable.double_check
                ){}
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                product.additions.forEach { addition ->
                    CustomRadioButton(
                        title = addition.name,
                        plusPrice = addition.price,
                        onClick = {
                            selected = addition
                        },
                        selected = selected == addition
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