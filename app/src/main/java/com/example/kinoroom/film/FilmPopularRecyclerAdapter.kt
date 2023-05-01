package com.example.kinoroom.film

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kinoroom.film.model.Films
import com.example.kinoroom.R


class FilmPopularRecyclerAdapter(
    private val item: List<Films>,
    private val onItemClickListener: (Films) -> Unit
) : RecyclerView.Adapter<FilmPopularRecyclerAdapter.ViewHolder>() {

    private val chatItems = mutableListOf<Films>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_film_popular, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var filmAverageView: TextView
        lateinit var itemViewGroup: RelativeLayout
        lateinit var dateTextView: TextView
        lateinit var avatarView: AppCompatImageView


        fun bind(item: Films) {
            filmAverageView = itemView.findViewById(R.id.filmAverageView)
           // dateTextView = itemView.findViewById(R.id.dateTextView)
            itemViewGroup = itemView.findViewById(R.id.itemViewGroup2)
            avatarView = itemView.findViewById(R.id.avatarView)



            filmAverageView.text = item.popularity
           // dateTextView.text = item.overview
            Glide
                .with(itemView)
                .load(item.backdrop_path)
                .centerCrop()
                .placeholder(R.drawable.ic_icon_star)
                .into(avatarView)

            itemViewGroup.setOnClickListener {
                onItemClickListener(item)
            }








        }
    }
}