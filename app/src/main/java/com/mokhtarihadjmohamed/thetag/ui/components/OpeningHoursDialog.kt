package com.mokhtarihadjmohamed.thetag.ui.components


import android.media.Rating
import android.widget.RatingBar
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

@Composable
fun OpeningHoursDialog(
    showDialog: Boolean,
    onDismissRequest: () -> Unit,
) {
    if (showDialog)
        Dialog(
            onDismissRequest = onDismissRequest
        ) {
            Column(
                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = grey_light,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .background(white_normal, RoundedCornerShape(16.dp))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Donnez-nous votre avis !",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                    CustomIconButton(
                        iconColor = grey_normal,
                        borderColor = Color.Transparent,
                        icon = R.drawable.outline_close_24,
                        iconSize = 28
                    ) {
                        onDismissRequest()
                    }
                }
                repeat(5) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        CustomButton(
                            modifier = Modifier.weight(1f),
                            label = "Lundi",
                            background = white_normal,
                            textColor = black_normal,
                            iconColor = black_normal,
                            textSize = 10,
                            iconPosition = IconPosition.START,
                            borderColor = grey_light_active,
                        ) { }
                        CustomButton(
                            modifier = Modifier.weight(1f),
                            label = "08h30",
                            iconEnd = R.drawable.working_houre,
                            iconPosition = IconPosition.START,
                            background = white_normal,
                            iconColor = black_normal,
                            textSize = 10,
                            iconSize = 16,
                            textColor = black_normal,
                            borderColor = grey_light_active,
                        ) { }
                        CustomButton(
                            modifier = Modifier.weight(1f),
                            label = "08h30",
                            iconEnd = R.drawable.working_houre,
                            iconPosition = IconPosition.START,
                            background = white_normal,
                            iconColor = black_normal,
                            textSize = 10,
                            iconSize = 16,
                            textColor = black_normal,
                            borderColor = grey_light_active,
                        ) { }
                    }
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun OpeningHoursDialogPreview() {
    OpeningHoursDialog(
        showDialog = true,
    ) { }
}