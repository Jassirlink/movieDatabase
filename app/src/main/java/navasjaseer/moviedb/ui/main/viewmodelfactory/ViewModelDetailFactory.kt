package navasjaseer.moviedb.ui.main.viewmodelfactory

import navasjaseer.moviedb.data.repositories.MovieDetailsRepository
import navasjaseer.moviedb.ui.main.viewmodels.MovieDetailsViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ViewModelDetailFactory(private val repository: MovieDetailsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieDetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieDetailsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}