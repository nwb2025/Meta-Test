package com.example.androiddata.utilities

import android.app.Application
import android.content.Context
import java.io.File

class FileHelper {
    companion object {
        fun readDataFromCache(app: Application):String? {
            val file = File(app.cacheDir, "gifs.json")
            return if (file.exists()) {
                file.readText()
            } else null
        }

        fun saveDataToCache(app: Application, json: String?) {
            val file = File(app.cacheDir, "gifs.json")
            file.writeText(json ?: "", Charsets.UTF_8)
        }
    }
}