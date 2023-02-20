package com.example.androiddata.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.androiddata.LOG_TAG
import com.example.androiddata.WEB_SERVICE_URL
import com.example.androiddata.data.remote.GifService
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GifRepo(val app:Application) {
    val gifsData = MutableLiveData<List<GifData>>()
    //private val gifDao = GifDB.getGifDB(app).gifDao()

    init {
        Log.i(LOG_TAG, "Network available: ${networkAvailable()}")
        CoroutineScope(Dispatchers.IO).launch {
            // val data = gifDao.getAll()
            callWebService()

            /*
            if (data.isEmpty()) {
                callWebService()
            } else {
                gifsData.postValue(data)
                withContext(Dispatchers.Main) {
                    Toast.makeText(app, "gifsLogging: using db data ", Toast.LENGTH_SHORT).show()
                }
            }
            */
        }
    }

    @WorkerThread
    suspend fun callWebService() {
        if (networkAvailable()) {
            Log.i(LOG_TAG, "Calling web service")
            val retrofit = Retrofit.Builder()
                .baseUrl(WEB_SERVICE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            val service = retrofit.create(GifService::class.java)
            val response = service.getGifData()
            if (response.isSuccessful) {
                val items = response.body()?.data
                if(items != null) {
                    gifsData.postValue(items)
                }
            } else {
                Log.e("RETROFIT_ERROR", response.message().toString())
            }
        } else {
            withContext(Dispatchers.Main) {
                Toast.makeText(app, "No network connection! ", Toast.LENGTH_SHORT).show()
            }
            gifsData.postValue(emptyList())
        }
    }

    // check the status of the internet connection
    @Suppress("DEPRECATION")
    private fun networkAvailable(): Boolean {
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting ?: false
    }

    fun refreshDataFromWeb() {
        CoroutineScope(Dispatchers.IO).launch {
            callWebService()
        }
    }
}