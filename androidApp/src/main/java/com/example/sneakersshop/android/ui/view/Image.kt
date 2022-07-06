package com.example.sneakersshop.android.ui.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.sneakersshop.android.ui.theme.secondaryBackground

@Composable
fun Image(
    url:String,
    modifier: Modifier
) {
    SubcomposeAsyncImage(
        model = url,
        contentDescription = null,
        modifier = modifier
            .padding(5.dp)
    ) {
        val state = painter.state
        if (
            state is AsyncImagePainter.State.Loading ||
            state is AsyncImagePainter.State.Error
        ) {
            CircularProgressIndicator(
                color = secondaryBackground
            )
        } else {
            SubcomposeAsyncImageContent()
        }
    }
}