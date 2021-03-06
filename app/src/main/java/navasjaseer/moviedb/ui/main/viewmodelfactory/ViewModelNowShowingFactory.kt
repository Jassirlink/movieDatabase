package navasjaseer.moviedb.ui.main.viewmodelfactory

import navasjaseer.moviedb.data.repositories.NowShowingRepository
import navasjaseer.moviedb.ui.main.viewmodels.NowShowingViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelNowShowingFactory(private val repository: NowShowingRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NowShowingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NowShowingViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}