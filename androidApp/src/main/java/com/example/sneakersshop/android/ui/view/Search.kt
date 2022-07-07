package com.example.sneakersshop.android.ui.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sneakersshop.android.ui.theme.searchPrimaryBackground

enum class SearchState {
    OPEN,
    CLOSES
}

@Composable
fun Search(
    modifier: Modifier = Modifier,
    onSearchText:(String) -> Unit,
    onSearchState:(SearchState) -> Unit
) {
    var searchText by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(key1 = searchText, block = {
        onSearchText(searchText)
    })

    TextField(
        value = searchText,
        onValueChange = { searchText = it },
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clip(AbsoluteRoundedCornerShape(15.dp)),
        placeholder = {
            Text(
                text = "Search by the keyword...",
                color = Color.White
            )
        },
        trailingIcon = {
            IconButton(onClick = {
                searchText = ""
                onSearchState(SearchState.CLOSES)
            }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            backgroundColor = searchPrimaryBackground,
            cursorColor = Color.White,
            focusedIndicatorColor = searchPrimaryBackground
        )
    )
}