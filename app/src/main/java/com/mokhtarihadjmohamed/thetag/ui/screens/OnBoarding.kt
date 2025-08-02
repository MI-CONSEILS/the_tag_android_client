package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.background_color
import com.mokhtarihadjmohamed.thetag.ui.theme.border_color

/*
* This is onboarding screen you will find:
* 1- The layout will be centers I used spacer to center the element and make the
* user layout more responsive.
* 2- I have used Text with size 32 for title and call text off it from resource
* string to help with multi language.
* 3- every card from this will tack us in to the home.
* */

@Composable
fun OnBoarding(navController: NavController){
    Scaffold(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxSize(),
        containerColor = background_color
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            // TODO The title
            Text(
                text = stringResource(id = R.string.header_home),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(modifier = Modifier.weight(.2f))
            // TODO card in go
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        color = border_color,
                        shape = RoundedCornerShape(12.dp)
                    ).clickable(
                        onClick = {
                            navController.navigate("HomeScreen") {
                                launchSingleTop = true
                            }
                        }
                    ),
                colors = CardDefaults.cardColors(
                    containerColor = background_color,
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.take_away),
                        contentDescription = "logo",
                        Modifier.size(80.dp)
                    )
                    Column {
                        Text(
                            text = stringResource(id = R.string.take_away_home_title),
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.inter_medium)),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                        Text(
                            text = stringResource(id = R.string.take_away_home_description),
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.inter_medium)),
                                fontSize = 16.sp,
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(.3f))
            // TODO Card in place
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        color = border_color,
                        shape = RoundedCornerShape(12.dp)
                    ).clickable(
                        onClick = {
                            navController.navigate("HomeScreen") {
                                launchSingleTop = true
                            }
                        }
                    ),
                colors = CardDefaults.cardColors(
                    containerColor = background_color,
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.in_place),
                        contentDescription = "logo",
                        Modifier.size(80.dp)
                    )
                    Column {
                        Text(
                            text = stringResource(id = R.string.in_place_home_title),
                            modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding()),
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.inter_medium)),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                        Text(
                            text = stringResource(id = R.string.in_place_home_description),
                            modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding()),
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.inter_medium)),
                                fontSize = 16.sp,
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}