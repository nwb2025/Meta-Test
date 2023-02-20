package com.example.androiddata.data.remote

import com.example.androiddata.data.NestedJsonModel
import retrofit2.Response
import retrofit2.http.GET


interface GifService {
    @GET("trending?api_key=EEjeWKnay8eNwJ091mC2ffGuQe96tdBN&")
    suspend fun getGifData(): Response<NestedJsonModel>
}