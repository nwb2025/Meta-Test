package com.example.androiddata.ui.shared

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.androiddata.data.GifData
import com.example.androiddata.data.GifRepo


class SharedViewModel(app: Application) : AndroidViewModel(app) {
    private val dataRepo = GifRepo(app)
    val gifsData = dataRepo.gifsData
    val selectedGif = MutableLiveData<GifData>()

    fun refreshData() {
        dataRepo.refreshDataFromWeb()
    }
}
