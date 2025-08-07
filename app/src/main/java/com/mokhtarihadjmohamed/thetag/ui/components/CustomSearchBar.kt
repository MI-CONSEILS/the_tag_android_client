package com.mokhtarihadjmohamed.thetag.ui.components

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.zIndex
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_dark
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

/*
* This is custom search bar and is expand when you click it or write in it
* so it have tow box in big box tha contain all:
* the first is not a box is row and have textfield and icon and search
* the second is for the expand list and
* */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomizableSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    searchResults: List<String>,
    onResultClick: (String) -> Unit,
    onExpand: (Boolean) -> Unit,
    // Customization options
    placeholder: String = stringResource(R.string.search),
    leadingIcon: Int = R.drawable.search,
    trailingIcon: Int = R.drawable.fillter,
    supportingContent: (@Composable (String) -> Unit)? = null,
    leadingContent: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {

    var showResults by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier.zIndex(1f)
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(leadingIcon),
                contentDescription = "search icon",
                modifier = Modifier
                    .size(20.dp)
                    .clickable(
                        onClick = {
                            onSearch(query)
                            showResults = false
                        }
                    ),
                tint = grey_dark
            )

            BasicTextField(
                modifier = Modifier.weight(1f),
                value = query,
                onValueChange = {
                    onQueryChange(it)
                    showResults = it.isNotBlank()
                },
                singleLine = true,
                textStyle = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 14.sp,
                    color = black_normal,
                ),
                decorationBox = { innerTextField ->
                    if (query.isEmpty()) {
                        Text(
                            text = placeholder, style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.inter_medium)),
                                fontSize = 14.sp,
                                color = grey_dark,
                            )
                        )
                    }
                    innerTextField()
                }
            )

            Icon(
                painter = painterResource(trailingIcon),
                contentDescription = "filter icon",
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                        showResults = !showResults
                    },
                tint = grey_dark
            )
        }

        if (showResults)
            Popup(
                offset = IntOffset(x = 0, y = 150),
                properties = PopupProperties(
                    excludeFromSystemGesture = true,
                    focusable = true
                ),
                onDismissRequest = { showResults = false }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color(0x40FFFFFF))
                        .border(1.dp, grey_light, RoundedCornerShape(8.dp))
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter)
                            .background(white_normal, shape = RoundedCornerShape(8.dp))
                            .padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(searchResults.size) { index ->
                            val resultText = searchResults[index]
                            ListItem(
                                headlineContent = { Text(resultText) },
                                supportingContent = supportingContent?.let { { it(resultText) } },
                                leadingContent = leadingContent,
                                colors = ListItemDefaults.colors(containerColor = Color.Transparent),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .border(
                                        width = 2.dp,
                                        color = grey_light,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .padding(top = 2.dp, bottom = 2.dp, end = 8.dp, start = 8.dp)
                                    .clickable {
                                        onResultClick(resultText)
                                        showResults = false
                                    }
                            )
                        }
                    }
                }
            }
        onExpand(showResults)
    }
}
