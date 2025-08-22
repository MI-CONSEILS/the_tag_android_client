package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
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
import com.mokhtarihadjmohamed.thetag.ui.components.CustomTextField
import com.mokhtarihadjmohamed.thetag.ui.components.CustomizableSearchBar
import com.mokhtarihadjmohamed.thetag.ui.components.IconPosition
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_dark
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

@Composable
fun SearchEstablishmentScreen(navController: NavController) {
    var search by remember { mutableStateOf("") }
    val allItems =
        listOf("Burger King", "PizzaHut", "Subway", "McDonald 's")
    val allIcon =
        listOf(R.drawable.burger_king, R.drawable.pizza_hut, R.drawable.subway, R.drawable.mac)


    Scaffold(
        containerColor = black_normal,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    modifier = Modifier
                        .clickable(onClick = {
                            navController.navigate("NfcScreen")
                        })
                        .weight(1f)
                        .drawBehind {
                            val strokeWidth = 2.dp.toPx()
                            drawLine(
                                color = black_normal,
                                start = androidx.compose.ui.geometry.Offset(0f, size.height),
                                end = androidx.compose.ui.geometry.Offset(size.width, size.height),
                                strokeWidth = strokeWidth
                            )
                        }
                        .padding(
                            top = 16.dp,
                            bottom = 16.dp
                        ),
                    text = stringResource(R.string.nfcScreen_text_top_01),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = grey_normal,
                        textAlign = TextAlign.Center
                    )
                )
                Text(
                    modifier = Modifier
                        .clickable(onClick = {
                            navController.navigate("SearchEstablishmentScreen")
                        })
                        .weight(1f)
                        .drawBehind {
                            val strokeWidth = 2.dp.toPx()
                            drawLine(
                                color = white_normal,
                                start = androidx.compose.ui.geometry.Offset(0f, size.height),
                                end = androidx.compose.ui.geometry.Offset(size.width, size.height),
                                strokeWidth = strokeWidth
                            )
                        }
                        .padding(
                            top = 16.dp,
                            bottom = 16.dp
                        ),
                    text = stringResource(R.string.nfcScreen_text_top_02),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = white_normal,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(
                top = innerPadding.calculateTopPadding() + 16.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = innerPadding.calculateBottomPadding() + 8.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(R.string.searchEstablishment_title),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = white_normal,
                    textAlign = TextAlign.Center
                )
            )
            CustomTextField(
                modifier = Modifier
                    .border(
                        1.dp, Color.Gray, RoundedCornerShape(8.dp)
                    )
                    .padding(12.dp)
                    .fillMaxWidth(), value = search,
                onValueChange = {
                    search = it
                },
                icon = R.drawable.search,
                textColor = white_normal,
                placeholder = "Chercher un établissement"
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(R.string.searchEstablishment_sub_titll),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 12.sp,
                    color = white_normal,
                )
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(allItems.size) {
                    ListItem(
                        headlineContent = {
                            Text(
                                allItems[it], style = TextStyle(
                                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                                    fontSize = 16.sp,
                                    color = white_normal,
                                )
                            )
                        },
                        colors = ListItemDefaults.colors(containerColor = Color.Transparent),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 2.dp,
                                color = grey_normal,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(top = 2.dp, bottom = 2.dp, end = 8.dp, start = 8.dp)
                            .clickable {

                            },
                        leadingContent = {
                            Image(
                                modifier = Modifier.size(32.dp),
                                painter = painterResource(allIcon[it]),
                                contentDescription = "logo btn",
                            )
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchEstablishmentScreenPreview() {
    SearchEstablishmentScreen(rememberNavController())
}
