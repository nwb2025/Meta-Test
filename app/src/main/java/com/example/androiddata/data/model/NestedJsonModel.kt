package com.example.androiddata.data

import com.squareup.moshi.Json

data class NestedJsonModel(
    var data: List<GifData>?
)

data class GifData(
    @field:Json(name = "type") val type: String,
    @field:Json(name = "id") val id: String,
    @field:Json(name = "url") val url: String,
    @field:Json(name = "slug") val slug: String,
    @field:Json(name = "bitly_gif_url") val bitly_gif_url: String,
    @field:Json(name = "bitly_url") val bitly_url: String,
    @field:Json(name = "embed_url") val embed_url: String,
    @field:Json(name = "username")val username: String,
    @field:Json(name = "source") val source: String,
    @field:Json(name = "title")val title: String,
    @field:Json(name = "rating")val rating: String,
    @field:Json(name = "content_url")val content_url: String,
    @field:Json(name = "source_tld")val source_tld: String,
    @field:Json(name = "source_post_url") val source_post_url: String,
    @field:Json(name = "is_sticker") val is_sticker: Int,
    @field:Json(name = "import_datetime") val import_datetime: String,
    @field:Json(name = "trending_datetime") val trending_datetime: String,
    @field:Json(name = "images")val images: Images?
)

data class Images(
    val original: Image,
    val downsized: Image,
    val downsized_large: Image,
    val downsized_medium: Image,
    val downsized_small: Image,
    val downsized_still: Image,
    val fixed_height: Image,
    val fixed_height_downsampled: Image,
    val fixed_height_small: Image,
    val fixed_height_small_still: Image,
    val fixed_height_still: Image,
    val fixed_width: Image,
    val fixed_width_downsampled: Image,
    val fixed_width_small: Image,
    val fixed_width_small_still: Image,
    val fixed_width_still: Image,
    val looping: Image,
    val original_still: Image,
    val preview: Image,
    val preview_gif: Image,
    val preview_webp: Image
)

data class Image(
    val height: String,
    val width: String,
    val size: String,
    val url: String,
    val mp4_size: String?,
    val mp4: String?,
    val webp_size: String?,
    val webp: String?,
    val frames: String?,
    val hash: String?
)








