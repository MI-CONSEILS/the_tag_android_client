package com.mokhtarihadjmohamed.thetag.ui.components

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.models.Order
import com.mokhtarihadjmohamed.thetag.models.Product
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.red_dark
import com.mokhtarihadjmohamed.thetag.ui.theme.red_light
import com.mokhtarihadjmohamed.thetag.ui.theme.red_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal
import kotlin.math.roundToInt

/*
* This Composable is Custom row item is used in the lzayColumn and it tack order
* as input and show all information of it here from image to price and so long
* */

@Composable
fun CustomRowProduct(
    modifier: Modifier = Modifier
        .fillMaxWidth(),
    onClick: () -> Unit,
    onDelete: () -> Unit,
    product: Product,
) {
    var offsetX by remember { mutableStateOf(0f) }
    val maxOffsetX = -350f

    val animatedOffsetX by animateFloatAsState(
        targetValue = offsetX, label = "offsetX"
    )

    Box(
        modifier = modifier.height(IntrinsicSize.Min),
    ) {
        if (offsetX < 0) {
            val buttonOffsetX = (offsetX - maxOffsetX).coerceAtLeast(0f)
            CustomButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterEnd)
                    .offset { IntOffset(buttonOffsetX.roundToInt(), 0) },
                label = "Retirer",
                icon = R.drawable.delete,
                background = red_normal.copy(alpha = .8f),
                borderColor = red_dark,
                textColor = white_normal,
                borderRadios = 8,
                padding = PaddingValues(start = 32.dp, end = 32.dp),
                onClick = {
                    onDelete()
                    offsetX = 0f
                },
            )
        }

        Card(
            modifier = Modifier
                .offset { IntOffset(animatedOffsetX.roundToInt(), 0) }
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(onHorizontalDrag = { _, dragAmount ->
                        offsetX += dragAmount
                        Log.d("show offset", offsetX.toString())
                    }, onDragEnd = {
                        offsetX = if (offsetX < maxOffsetX / 2) maxOffsetX else 0f
                    })
                }
                .clickable(
                    onClick = onClick
                )
                .border(
                    width = 2.dp,
                    color = grey_light,
                    shape = RoundedCornerShape(12.dp)
                ),
            colors = CardDefaults.cardColors(
                containerColor = white_normal,
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
                        Text(
                            text = "${product.name}",
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
                            text = "$ ${product.price}",
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.inter_medium)),
                                fontSize = 16.sp,
                            )
                        )

                        var amount by remember { mutableStateOf(1) }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            CustomIconButton(
                                background = grey_light_active,
                                icon = R.drawable.decrease,
                                iconSize = 8,
                                iconColor = white_normal, borderColor = Color.Transparent
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
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            CustomIconButton(
                                background = black_normal,
                                icon = R.drawable.increase,
                                iconSize = 8,
                                iconColor = white_normal, borderColor = Color.Transparent
                            ) {
                                amount++
                            }
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomRowProductPreview() {
    CustomRowProduct(
        onClick = {},
        onDelete = {},
        product =
            Product(
                name = "Burger  - SM Lucena",
                description = "Grillé à la flamme pour un goût inimitable",
                price = 18.0,
                imageURl = "",
                amount = 1,
                type = "Burgers"

            ),
    )
}
