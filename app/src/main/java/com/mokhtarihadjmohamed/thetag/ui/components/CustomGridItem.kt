package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.models.Product
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

/*
* This Composable is Custom grid item is used in the lzayGrid and it tack product
* as input and show all information of it here from image to name and so long
* */

@Composable
fun CustomGridItem(
    modifier: Modifier = Modifier
        .border(
            width = 2.dp,
            color = grey_light,
            shape = RoundedCornerShape(12.dp)
        ),
    onClick: () -> Unit,
    product: Product,
) {
    Card(
        modifier = modifier
            .clickable(
                onClick = onClick
            ),
        colors = CardDefaults.cardColors(
            containerColor = white_normal,
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.take_away),
                contentDescription = "logo",
                Modifier
                    .fillMaxWidth()
                    .size(100.dp)
            )
            Text(
                text = product.name,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
            )
            Text(
                text = product.description,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 12.sp,
                )
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "${product.price} $",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                    fontSize = 12.sp,
                    textAlign = TextAlign.End
                )
            )
        }
    }
}
