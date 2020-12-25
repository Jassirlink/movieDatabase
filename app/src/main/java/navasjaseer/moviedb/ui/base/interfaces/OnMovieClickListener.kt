package navasjaseer.moviedb.ui.base.interfaces

import navasjaseer.moviedb.data.models.Movie

interface OnMovieClickListener {
    fun onMovieClickListener(movie: Movie)
}