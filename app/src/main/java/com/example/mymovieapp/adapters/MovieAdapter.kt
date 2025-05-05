package com.example.mymovieapp.adapters
import com.example.mymovieapp.R
import com.example.mymovieapp.model.data.Movie

class MovieAdapter(items:List<Movie>,listener: MovieInteractionListener): BaseAdapter<Movie>(items,listener) {

    override val layoutId: Int=R.layout.movie_item
}
interface MovieInteractionListener: BaseInteractionListener{
    fun onClickMovie(movie: Movie)
}

