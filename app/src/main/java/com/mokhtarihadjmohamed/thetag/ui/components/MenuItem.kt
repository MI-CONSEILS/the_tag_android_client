package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.screens.ProductScreen
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_dark
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light

/*
* This is the item is used in menu and also in some other face
* it have icon and can not add icon will be with out icon
* */
@Composable
fun MenuItem(
    modifier: Modifier = Modifier
        .border(
            width = 1.dp,
            color = grey_light,
            shape = RoundedCornerShape(4.dp)
        ),
    type: String,
    icon: Int? = null
) {
    Row(
        modifier = modifier.padding(start = 8.dp, end = 8.dp, bottom = 4.dp, top = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        if (icon != null)
            Icon(
                modifier = Modifier.size(13.dp),
                painter = painterResource(icon),
                contentDescription = "Item icon"
            )
        Text(
            type,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 16.sp,
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMenuItem() {
    MenuItem(type = "Obligatoire", icon = R.drawable.double_check)
}