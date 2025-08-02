package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R

/*
* This Composable is for my custom button it not have a lot in just a box and Text inside
* */
@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    label: String,
    textColor: Color,
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clickable(onClick = onClick)
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