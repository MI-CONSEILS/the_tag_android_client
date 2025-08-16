package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

/*
* This composable is dots navigation is the point that show what page
* of navigation you are in and you can set size and selected page number and
* put how mush space between dot.
* */

@Composable
fun DotsNavigation(modifier: Modifier = Modifier, size: Int, selected: Int, space: Int = 8) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space.dp)
    ) {
        repeat(size) {
            Box(
                modifier = Modifier
                    .weight(
                        if (it == selected) 3f else 1f
                    )
                    .background(
                        if (it == selected) white_normal else grey_normal,
                        shape = RoundedCornerShape(9999.dp)
                    )
                    .height(4.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DotsNavigationPreview() {
    DotsNavigation(size = 4, selected = 1)
}