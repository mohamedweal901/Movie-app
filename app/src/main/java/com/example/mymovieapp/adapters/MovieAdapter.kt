package com.example.mymovieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovieapp.R
import com.example.mymovieapp.databinding.MovieItemBinding
import com.example.mymovieapp.model.data.Movie

class MovieAdapter(private var items:List<Movie>, val listener: MovieInteractionListener): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem=items[position]
        holder.binding.listener=listener
        holder.binding.item=currentItem
    }

    fun setItems(newItems:List<Movie>){
        items=newItems
    }

    class MovieViewHolder(val itemView: View):RecyclerView.ViewHolder(itemView){
        val binding = MovieItemBinding.bind(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
interface MovieInteractionListener{
    fun onClickMovie(movie: Movie)
}