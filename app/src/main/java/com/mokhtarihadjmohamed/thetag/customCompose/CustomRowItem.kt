package com.mokhtarihadjmohamed.thetag.customCompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.model.Order
import com.mokhtarihadjmohamed.thetag.model.Product
import com.mokhtarihadjmohamed.thetag.ui.theme.background_color
import com.mokhtarihadjmohamed.thetag.ui.theme.border_color

/*
* This Composable is Custom row item is used in the lzayColumn and it tack order
* as input and show all information of it here from image to price and so long
* */

@Composable
fun CustomRowItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    order: Order,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = order.date,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 14.sp,
            )
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = border_color,
                    shape = RoundedCornerShape(12.dp)
                )
                .clickable(
                    onClick = onClick
                ),
            colors = CardDefaults.cardColors(
                containerColor = background_color,
            )
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.take_away),
                    contentDescription = "logo",
                    Modifier.size(80.dp)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            order.products.forEach { product ->
                                Text(
                                    text = "${product.amount} x ${product.name}",
                                    style = TextStyle(
                                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                )
                            }
                        }
                        Text(
                            text = "#${order.id}",
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.inter_medium)),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "$ ${order.getTotal()}",
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.inter_medium)),
                                fontSize = 16.sp,
                            )
                        )

                        CustomButton(
                            modifier = Modifier
                                .background(
                                    color = Color.Black,
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .padding(
                                start = 16.dp,
                                end = 16.dp,
                                bottom = 8.dp,
                                top = 8.dp
                            ),
                            label = "Commander",
                            textColor = Color.White,
                            onClick = {}
                        )
                    }

                }
            }
        }
    }
}
