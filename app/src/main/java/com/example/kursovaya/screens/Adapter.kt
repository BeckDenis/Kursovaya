package com.example.kursovaya.screens

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kursovaya.R
import com.example.kursovaya.models.Movie
import kotlinx.android.synthetic.main.item_movie.view.*


// Adapter будет показывать изображения с названием на экране
class MovieAdapter(private val movieData: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = movieData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieData[position]
        holder.view.run {
            item_movie_poster.insertImageW500(movie.poster_path)
            item_movie_name.text = movie.title
        }
    }

    fun ImageView.insertImageW500(posterId: String?) {
        Glide.with(context).load("https://image.tmdb.org/t/p/w500$posterId").into(this)
    }
}