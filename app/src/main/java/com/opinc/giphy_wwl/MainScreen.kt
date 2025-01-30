package com.opinc.giphy_wwl

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.bumptech.glide.Glide

@Composable
fun MainScreen(
) {
    val list = listOf(
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/fe8u8rc5946jbNMyL1",
        "https://giphy.com/embed/18WwwgwTyA36G261Dg",
    )
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(
            list
        ) { url ->
            GifItem(url)
        }
    }

}

@Composable
fun GifItem(url: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.ic_launcher_background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.clip(CircleShape)
    )
}
