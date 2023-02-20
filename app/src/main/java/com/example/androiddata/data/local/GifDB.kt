package com.example.androiddata.data.local

import androidx.room.RoomDatabase
import com.example.androiddata.data.local.GifDao

//@Database(entities = [Gif::class], version = 1, exportSchema = false)
abstract class GifDB: RoomDatabase() {

    abstract fun gifDao(): GifDao

    companion object{
        /*@Volatile
        private var INSTANCE: GifDB? = null

        fun getGifDB(context: Context): GifDB {
            if (INSTANCE == null){
                // can be called by one thread at a time
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        GifDB::class.java,
                        "gifs.db"
                    ).build()
                }
            }
            return INSTANCE!!
        }*/
    }
}