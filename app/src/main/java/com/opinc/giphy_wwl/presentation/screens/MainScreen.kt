package com.opinc.giphy_wwl.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.opinc.giphy_wwl.R
import com.opinc.giphy_wwl.domain.data.GiphyModel
import com.opinc.giphy_wwl.presentation.activity.MainActivityViewModel
import com.opinc.giphy_wwl.presentation.activity.MainActivityViewModel.ScreenState


@Composable
fun MainScreen(
    viewModel: MainActivityViewModel,
    openFullScreen: (String) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    when (uiState) {
        is ScreenState.Success -> {
            MainScreenContent(
                data = (uiState as ScreenState.Success).data, openFullScreen = openFullScreen
            )
        }

        is ScreenState.Error -> {
            Toast.makeText(context, stringResource(R.string.error_generic), Toast.LENGTH_LONG).show()
        }
        ScreenState.Loading -> {}
    }

}

@Composable
private fun MainScreenContent(
    data: GiphyModel,
    openFullScreen: (String) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(), columns = GridCells.Adaptive(minSize = 200.dp)
        ) {
            items(
                data.data
            ) { item ->

                GifImage(
                    item.small,
                    openFullScreen = {
                        openFullScreen(item.original)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GifImage(
    url: String,
    openFullScreen: (String) -> Unit,
) {
    GlideImage(model = url,
        contentDescription = "GIF",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable {
                openFullScreen(url)
            })
}
