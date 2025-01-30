package com.opinc.giphy_wwl.domain.data


data class GiphyModel(
    val data: List<GifUrls>,
)

data class GifUrls(
    val original: String,
    val small: String
)