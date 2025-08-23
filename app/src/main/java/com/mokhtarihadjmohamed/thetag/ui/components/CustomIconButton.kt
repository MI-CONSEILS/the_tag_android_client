package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal

/*
* this is a custom button, it just simple icon and onclick and can change the icon
* by injection.
* */

@Composable
fun CustomIconButton(
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.menu,
    iconSize: Int = 16,
    iconColor: Color = black_normal,
    borderWidth: Int = 2,
    borderColor: Color = grey_normal,
    roundedCorner: Int = 24,
    background: Color = Color.Transparent,
    paddingValues: PaddingValues = PaddingValues(8.dp),
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable(onClick = onClick)
            .border(
                width = borderWidth.dp,
                color = borderColor,
                shape = RoundedCornerShape(roundedCorner.dp)
            )
            .background(
                color = background,
                shape = RoundedCornerShape(roundedCorner.dp)
            )
            .padding(
                paddingValues
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(iconSize.dp),
            painter = painterResource(icon),
            contentDescription = "icon",
            tint = iconColor
        )
    }
}
