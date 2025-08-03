package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.background_color
import com.mokhtarihadjmohamed.thetag.ui.theme.black_900
import com.mokhtarihadjmohamed.thetag.ui.theme.border_color

/*
* This Composable is for my custom button it not have a lot in just a box and Text inside
* */
@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    label: String,
    background: Color = black_900,
    textColor: Color,
    padding: PaddingValues = PaddingValues(16.dp),
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                color = background,
                shape = RoundedCornerShape(4.dp)
            )
            .clickable(onClick = onClick)
            .padding(padding)
    ) {
        Text(
            text = label, style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                color = textColor
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCustomButton() {
    CustomButton(
        label = "Ajouter 1 au panier | 14.65\$",
        background = black_900,
        textColor = background_color
    ) { }

}