package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.data.remote.entities.Product
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

/*
* This Composable is Custom grid item is used in the lzayGrid and it tack product
* as input and show all information of it here from image to name and so long
* */

@Composable
fun CustomGridItem(
    modifier: Modifier = Modifier.fillMaxWidth(),
    icon: Int? = null,
    onClick: () -> Unit,
    product: Product,
    imageSize: Int = 100,
    textSize: Int = 13,
    descriptionSize: Int = 12,
    priceSize: Int = 12,
    image: Int = R.drawable.take_away,
) {
    Card(
        modifier = modifier
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
        Column(
            modifier = modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "logo",
                Modifier
                    .fillMaxWidth()
                    .size(imageSize.dp)
            )
            Row(
                modifier = modifier,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = product.name,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = textSize.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                if (icon != null)
                    CustomIconButton(
                        borderColor = Color.Transparent, icon = icon
                    ) {
                    }
            }
            if (product.description.isNotEmpty())
                Text(
                    text = product.description,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = descriptionSize.sp,
                    )
                )
            Text(
                modifier = modifier,
                text = "${product.price} $",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                    fontSize = priceSize.sp,
                    textAlign = TextAlign.End
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CustomGridItemPreview() {
    CustomGridItem(
        onClick = {
        }, product = Product(
            name = "Coca-Cola",
            description = "",
            price = 18.0,
            imageURl = "",
            type = "Burgers"
        )
    )
}