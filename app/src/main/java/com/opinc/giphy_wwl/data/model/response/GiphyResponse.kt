package com.opinc.giphy_wwl.data.model.response

import com.google.gson.annotations.SerializedName
import com.opinc.giphy_wwl.domain.data.GifUrls
import com.opinc.giphy_wwl.domain.data.GiphyModel

data class GiphyResponse(
    val data: List<GiphyData>,
)

data class GiphyData(
    val images: GiphyImages
)

data class GiphyImages(
    val original: GiphyImageDetails,
    @SerializedName("preview_webp")
    val small: GiphyImageDetails
)

data class GiphyImageDetails(
    val url: String
)

fun GiphyResponse.mapToGiphyModel() =  GiphyModel(
        data = this.data.map { giphyData ->
            GifUrls(
                original = giphyData.images.original.url,
                small = giphyData.images.small.url
            )
        }
    )
