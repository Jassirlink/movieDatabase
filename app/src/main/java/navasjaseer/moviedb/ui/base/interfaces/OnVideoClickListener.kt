package navasjaseer.moviedb.ui.base.interfaces

import navasjaseer.moviedb.data.models.MovieVideo

interface OnVideoClickListener {
    fun onVideoClickListener(movieVideo: MovieVideo)
}