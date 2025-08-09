package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

@Composable
fun OrderReceivedDialog(
    showDialog: Boolean,
    title: String,
    description: String,
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
                        shape = RoundedCornerShape(16.dp)
                    )
                    .background(white_normal, RoundedCornerShape(16.dp))
                    .padding(top = 16.dp, start = 32.dp, end = 32.dp, bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    title,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                )
                Text(
                    description,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                )
                CustomButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "ok",
                    background = black_normal,
                    textColor = white_normal,
                    borderRadios = 12,
                    textSize = 16
                ) {
                    onDismissRequest()
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun OrderReceivedDialogPreview() {
    OrderReceivedDialog(
        showDialog = true,
        title = "Commande bien reçue !",
        description = "Nous vous informerons dès que votre commande sera prête à être récupérée.",
    ) { }
}