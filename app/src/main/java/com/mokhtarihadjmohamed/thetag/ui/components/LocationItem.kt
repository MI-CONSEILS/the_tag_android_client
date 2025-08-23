package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
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
import com.mokhtarihadjmohamed.thetag.data.remote.entities.Location
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.green_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_dark
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

@Composable
fun LocationItem(
    modifier: Modifier = Modifier
        .background(black_normal, shape = RoundedCornerShape(16.dp))
        .border(
            width = 2.dp,
            shape = RoundedCornerShape(12.dp),
            color = grey_normal
        )
        .padding(16.dp),
    location: Location,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = location.title,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = white_normal
                )
            )
            Icon(
                modifier = Modifier.size(47.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = "logo btn",
                tint = white_normal
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = location.status,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = green_normal
                )
            )
            Box(
                modifier = Modifier
                    .size(5.dp)
                    .background(white_normal, shape = RoundedCornerShape(9999.dp))
            )
            Text(
                text = location.close,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = grey_light_active
                )
            )
            Box(
                modifier = Modifier
                    .size(5.dp)
                    .background(white_normal, shape = RoundedCornerShape(9999.dp))
            )
            Text(
                text = location.distance,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = grey_light_active
                )
            )
        }
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = location.address,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = grey_normal
            )
        )
        CustomButton(
            label = stringResource(R.string.locationItem_btn),
            borderColor = grey_normal,
            borderRadios = 8,
            padding = PaddingValues(horizontal = 24.dp, vertical = 16.dp)
        ) { }
    }
}

@Preview(showBackground = true)
@Composable
fun LocationItemPreview() {
    LocationItem(
        location = Location(
            title = "The Tag - Cesson",
            status = "Ouvert",
            close = "Ferme a 22:00",
            distance = "8.3KM",
            address = "Zac Plaine Du Moulin A Vent, 77240 Cesson"
        )
    ) {

    }
}