package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.components.CustomButton
import com.mokhtarihadjmohamed.thetag.ui.components.CustomIconButton
import com.mokhtarihadjmohamed.thetag.ui.components.CustomTextField
import com.mokhtarihadjmohamed.thetag.ui.components.IconPosition
import com.mokhtarihadjmohamed.thetag.ui.components.TopBar
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

@Composable
fun RestaurantChatScreen(navController: NavController) {
    var message by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .imePadding(),
        containerColor = white_normal,
        topBar = {
            TopBar(
                title = "L'Oiseau Blanc",
                image = R.drawable.restaurant_logo
            ) { }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CustomIconButton(
                    borderColor = Color.Transparent,
                    iconColor = grey_normal,
                    icon = R.drawable.load_file,
                    iconSize = 18
                ) {

                }
                CustomTextField(
                    modifier = Modifier
                        .weight(1f)
                        .border(
                            width = 1.dp,
                            color = grey_light_active,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(12.dp),
                    value = message,
                    onValueChange = {
                        message = it
                    },
                )
                CustomIconButton(
                    borderColor = Color.Transparent,
                    iconColor = grey_normal,
                    icon = R.drawable.send,
                    iconSize = 18
                ) {

                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .imePadding()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    start = 16.dp,
                    end = 16.dp,
                    bottom = paddingValues.calculateBottomPadding()
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(60.dp),
                    painter = painterResource(R.drawable.restaurant_logo),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Julien Lefèvre",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = black_normal
                    )
                )
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Envoyer un message au patron\n" +
                        "Vous avez une question ou un retour à faire au patron ? Utilisez ce formulaire pour nous faire part de vos commentaires ou demandes.",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 14.sp,
                    color = black_normal
                )
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun RestaurantChatScreenPreview() {
    RestaurantChatScreen(rememberNavController())
}