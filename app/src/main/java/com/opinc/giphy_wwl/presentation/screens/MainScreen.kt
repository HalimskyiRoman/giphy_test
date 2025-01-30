package com.opinc.giphy_wwl.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


@Composable
fun MainScreen(
    openFullScreen:(String) -> Unit,
) {
    val list = listOf(
        "https://media2.giphy.com/media/v1.Y2lkPTMyZDU2ZGQ1dGRxdG1hdHRreHlzaTNwd3RuZGJiNDZlczR4bHhjYzluNm1hYXByayZlcD12MV9naWZzX3RyZW5kaW5nJmN0PWc/18WwwgwTyA36G261Dg/giphy.gif",
        "https://media2.giphy.com/media/v1.Y2lkPTMyZDU2ZGQ1dGRxdG1hdHRreHlzaTNwd3RuZGJiNDZlczR4bHhjYzluNm1hYXByayZlcD12MV9naWZzX3RyZW5kaW5nJmN0PWc/18WwwgwTyA36G261Dg/giphy.gif",
        "https://media2.giphy.com/media/v1.Y2lkPTMyZDU2ZGQ1dGRxdG1hdHRreHlzaTNwd3RuZGJiNDZlczR4bHhjYzluNm1hYXByayZlcD12MV9naWZzX3RyZW5kaW5nJmN0PWc/18WwwgwTyA36G261Dg/giphy.gif",
        "https://media2.giphy.com/media/v1.Y2lkPTMyZDU2ZGQ1dGRxdG1hdHRreHlzaTNwd3RuZGJiNDZlczR4bHhjYzluNm1hYXByayZlcD12MV9naWZzX3RyZW5kaW5nJmN0PWc/18WwwgwTyA36G261Dg/giphy.gif",
        "https://media2.giphy.com/media/v1.Y2lkPTMyZDU2ZGQ1dGRxdG1hdHRreHlzaTNwd3RuZGJiNDZlczR4bHhjYzluNm1hYXByayZlcD12MV9naWZzX3RyZW5kaW5nJmN0PWc/18WwwgwTyA36G261Dg/giphy.gif",
        "https://media2.giphy.com/media/v1.Y2lkPTMyZDU2ZGQ1dGRxdG1hdHRreHlzaTNwd3RuZGJiNDZlczR4bHhjYzluNm1hYXByayZlcD12MV9naWZzX3RyZW5kaW5nJmN0PWc/18WwwgwTyA36G261Dg/giphy.gif",
        "https://media2.giphy.com/media/v1.Y2lkPTMyZDU2ZGQ1dGRxdG1hdHRreHlzaTNwd3RuZGJiNDZlczR4bHhjYzluNm1hYXByayZlcD12MV9naWZzX3RyZW5kaW5nJmN0PWc/18WwwgwTyA36G261Dg/giphy.gif",
        "https://media2.giphy.com/media/v1.Y2lkPTMyZDU2ZGQ1dGRxdG1hdHRreHlzaTNwd3RuZGJiNDZlczR4bHhjYzluNm1hYXByayZlcD12MV9naWZzX3RyZW5kaW5nJmN0PWc/18WwwgwTyA36G261Dg/giphy.gif",
        "https://media2.giphy.com/media/v1.Y2lkPTMyZDU2ZGQ1dGRxdG1hdHRreHlzaTNwd3RuZGJiNDZlczR4bHhjYzluNm1hYXByayZlcD12MV9naWZzX3RyZW5kaW5nJmN0PWc/18WwwgwTyA36G261Dg/giphy.gif",
        "https://media2.giphy.com/media/v1.Y2lkPTMyZDU2ZGQ1dGRxdG1hdHRreHlzaTNwd3RuZGJiNDZlczR4bHhjYzluNm1hYXByayZlcD12MV9naWZzX3RyZW5kaW5nJmN0PWc/18WwwgwTyA36G261Dg/giphy.gif",
        "https://media2.giphy.com/media/v1.Y2lkPTMyZDU2ZGQ1dGRxdG1hdHRreHlzaTNwd3RuZGJiNDZlczR4bHhjYzluNm1hYXByayZlcD12MV9naWZzX3RyZW5kaW5nJmN0PWc/18WwwgwTyA36G261Dg/giphy.gif",
        "https://media2.giphy.com/media/v1.Y2lkPTMyZDU2ZGQ1dGRxdG1hdHRreHlzaTNwd3RuZGJiNDZlczR4bHhjYzluNm1hYXByayZlcD12MV9naWZzX3RyZW5kaW5nJmN0PWc/18WwwgwTyA36G261Dg/giphy.gif",
        "https://media2.giphy.com/media/v1.Y2lkPTMyZDU2ZGQ1dGRxdG1hdHRreHlzaTNwd3RuZGJiNDZlczR4bHhjYzluNm1hYXByayZlcD12MV9naWZzX3RyZW5kaW5nJmN0PWc/18WwwgwTyA36G261Dg/giphy.gif",
        "https://media2.giphy.com/media/v1.Y2lkPTMyZDU2ZGQ1dGRxdG1hdHRreHlzaTNwd3RuZGJiNDZlczR4bHhjYzluNm1hYXByayZlcD12MV9naWZzX3RyZW5kaW5nJmN0PWc/18WwwgwTyA36G261Dg/giphy.gif",
    )
    val context = LocalContext.current
   Column(
       modifier = Modifier.fillMaxSize()
   ) {
       LazyVerticalGrid(
           modifier = Modifier.fillMaxSize(),
           columns = GridCells.Adaptive(minSize = 128.dp)
       ) {
           items(
               list
           ) { url ->
               GifImage( url, openFullScreen)
           }
       }
   }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GifImage(
    url: String,
    openFullScreen:(String) -> Unit,
) {
    GlideImage(
        model = url,
        contentDescription = "GIF",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .clickable {
                openFullScreen(url)
            }
    )
}
