package com.mokhtarihadjmohamed.thetag.View

import android.provider.CalendarContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
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
import com.mokhtarihadjmohamed.thetag.CustomCompose.CustomTextField
import com.mokhtarihadjmohamed.thetag.CustomCompose.TopBar
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.background_color
import com.mokhtarihadjmohamed.thetag.ui.theme.border_color

@Composable
fun HomeScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }

    val menusList: List<String> =
        stringArrayResource(R.array.menus).toCollection(destination = ArrayList())

    Scaffold(
        topBar = {
            TopBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                title = "Burger King"
            )
        },
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .fillMaxSize(),
        containerColor = background_color
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // TODO Search field
            CustomTextField(
                modifier = Modifier
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(12.dp)
                    .fillMaxWidth(),
                value = text,
                onValueChange = {
                    text = it
                },
                placeholder = stringResource(R.string.search),
                icon = R.drawable.search,
                endIcon = R.drawable.fillter
            )
            // TODO Card Ads
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        color = border_color,
                        shape = RoundedCornerShape(12.dp)
                    ),
                colors = CardDefaults.cardColors(
                    containerColor = background_color,
                )
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.ads),
                    contentDescription = "image ads"
                )
            }
            // TODO Menus bar
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(menusList) { item ->
                    Text(
                        item,
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = border_color,
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(start = 8.dp, end = 8.dp, bottom = 4.dp, top = 4.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposablePreviewHome() {
    val navController = rememberNavController()

    HomeScreen(navController)
}