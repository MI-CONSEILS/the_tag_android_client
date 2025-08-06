package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
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
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal


/*
* this is a customRadioButton, all row for check any type off addition will add
* so it have row and in it text and radio button.
* */

@Composable
fun CustomRadioButton(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .border(
            width = 2.dp,
            color = grey_light,
            shape = RoundedCornerShape(8.dp)
        ),
    title: String,
    plusPrice: Double? = null,
    selected: Boolean = false,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier
            .clickable(
                onClick = onClick
            )
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            if (plusPrice != null)
                Text(
                    text = "+ $plusPrice $",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 16.sp,
                        color = grey_light_active
                    )
                )
        }
        RadioButton(
            modifier = Modifier.size(10.dp),
            selected = selected,
            onClick = onClick,
            colors = RadioButtonColors(
                selectedColor = black_normal,
                unselectedColor = grey_light,
                disabledSelectedColor = grey_light_active,
                disabledUnselectedColor = grey_light
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCustomRadioButton() {
    CustomRadioButton(
        title = "Tenders",
        plusPrice = 1.50,
        onClick = {}
    )
}