package com.mokhtarihadjmohamed.thetag.ui.components

import android.media.Rating
import android.widget.RatingBar
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

@Composable
fun OpinionDialog(
    showDialog: Boolean,
    onDismissRequest: () -> Unit,
) {
    var rating by remember { mutableStateOf(3) }
    var value by remember { mutableStateOf("") }

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
                    "Donnez-nous votre avis !",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                )
                Text(
                    "Un petit mot de votre part nous permet d’améliorer votre expérience.",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                )
                RatingBar(
                    rating = rating,
                    onRatingChanged = { rating = it }
                )
                CustomTextField(
                    modifier = Modifier
                        .border(
                            1.dp, grey_light, RoundedCornerShape(16.dp)
                        )
                        .padding(12.dp)
                        .fillMaxWidth(),
                    placeholderColor = grey_light_active,
                    value = value,
                    onValueChange = {
                        value = it
                    },
                    placeholder = "Un mot à ajouter ?"
                )
                CustomButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Envoyer",
                    background = black_normal,
                    textColor = white_normal,
                    borderRadios = 12,
                    textSize = 14
                ) {
                    onDismissRequest()
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun OpinionDialogPreview() {
    OpinionDialog(
        showDialog = true,
    ) { }
}