package com.example.androiddata.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androiddata.R
import com.example.androiddata.data.GifData

class MainRecyclerAdapter(val context: Context,
                          val gifs: List<GifData>):
    RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>()

{
    override fun getItemCount() = gifs.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.gif_grid_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gif = gifs[position]
        with(holder) {
            title?.let {
                it.text = gif.title
                it.contentDescription = gif.title
            }

           Glide.with(context)
                .load(gif.images?.original?.url.toString())
               .error(R.drawable.default_img)
                .into(gifImage)
        }
    }

    inner class ViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        val title= itemView.findViewById<TextView>(R.id.title)
        val gifImage = itemView.findViewById<ImageView>(R.id.gifImage)
    }

}