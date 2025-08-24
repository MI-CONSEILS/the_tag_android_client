package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.green_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal


@Composable
fun CustomDropMenu(
    placeholder: String,
    items: List<String>,
    modifier: Modifier = Modifier,
    label: String,
    onClick: (item: String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Column {
        OutlinedButton(
            modifier = Modifier.background(black_normal),
            onClick = { expanded = !expanded },
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (label != "") label else placeholder, style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = white_normal,
                    )
                )
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    tint = white_normal
                )
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = modifier.background(color = black_normal)
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        onClick(item)
                        expanded = false
                    },
                    text = {
                        Text(
                            text = item, style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.inter_medium)),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = white_normal,
                            )
                        )
                    },
                    modifier = modifier.background(color = black_normal),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomDropMenuPreview() {
    CustomDropMenu(
        modifier = Modifier,
        placeholder = "Trier par date",
        items = emptyList(),
        label = "tri"
    ) { }
}
