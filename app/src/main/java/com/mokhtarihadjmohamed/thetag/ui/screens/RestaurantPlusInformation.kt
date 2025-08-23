package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.components.CustomButton
import com.mokhtarihadjmohamed.thetag.ui.components.CustomIconButton
import com.mokhtarihadjmohamed.thetag.ui.components.IconPosition
import com.mokhtarihadjmohamed.thetag.ui.components.OpeningHoursDialog
import com.mokhtarihadjmohamed.thetag.ui.components.RatingBar
import com.mokhtarihadjmohamed.thetag.ui.components.TopBar
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

@Composable
fun RestaurantPlusInformation(navController: NavController) {
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = black_normal,
        topBar = {
            TopBar(
                title = stringResource(R.string.restaurantPlusInformation_title),
                iconColor = white_normal,
                textColor = white_normal,
                textSize = 18
            ) { }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    start = 16.dp,
                    end = 16.dp,
                    bottom = paddingValues.calculateBottomPadding() + 16.dp
                ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    modifier = Modifier.size(60.dp),
                    painter = painterResource(R.drawable.restaurant_logo),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Julien Lefèvre",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = white_normal
                        )
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        RatingBar(
                            rating = 4,
                            maxRating = 5,
                            onRatingChanged = {}
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "4.1",
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.inter_medium)),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = white_normal
                            )
                        )
                    }
                }
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Envoyer un message au patron Vous avez une question ou un retour à faire au patron ? Utilisez ce formulaire pour nous faire part de vos commentaires ou demandes.",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 14.sp,
                    color = white_normal
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CustomIconButton(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.instgrame,
                    iconColor = white_normal,
                    iconSize = 28,
                    borderColor = white_normal,
                    roundedCorner = 12,
                    borderWidth = 1,
                    paddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {

                }
                CustomIconButton(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.tik_tok,
                    iconColor = white_normal,
                    iconSize = 28,
                    borderColor = white_normal,
                    roundedCorner = 12,
                    borderWidth = 1,
                    paddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {

                }
                CustomIconButton(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.facebook,
                    iconColor = white_normal,
                    iconSize = 28,
                    borderColor = white_normal,
                    roundedCorner = 12,
                    borderWidth = 1,
                    paddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {

                }
                CustomIconButton(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.snapshat,
                    iconColor = white_normal,
                    iconSize = 28,
                    borderColor = white_normal,
                    roundedCorner = 12,
                    borderWidth = 1,
                    paddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {

                }
            }
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(R.string.restaurantPlusInformation_btn_01),
                iconPosition = IconPosition.START,
                icon = R.drawable.working_houre,
                textAlign = TextAlign.Start,
                borderColor = grey_normal,
                borderRadios = 12,
                rowCenter = true
            ) {
                showDialog = true
            }
            Spacer(modifier = Modifier.weight(1f))
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(R.string.restaurantPlusInformation_btn_02),
                icon = R.drawable.exit,
                iconColor = white_normal,
                iconPosition = IconPosition.START,
                textAlign = TextAlign.Start,
                borderColor = grey_normal,
                borderRadios = 12,
                textSize = 18,
                rowCenter = true
            ) {
                navController.navigate("NfcScreen") {
                    popUpTo("AccountSetting") { inclusive = true }
                    launchSingleTop = true
                }
            }
        }
        OpeningHoursDialog(
            showDialog = showDialog,
        ) {
            showDialog = false
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RestaurantPlusInformationPreview() {
    RestaurantPlusInformation(rememberNavController())
}