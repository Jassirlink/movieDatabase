package navasjaseer.moviedb.data.database.databaseResults

import navasjaseer.moviedb.data.database.entities.PopularEntry
import androidx.lifecycle.LiveData
import androidx.paging.PagedList

data class PopularResults(
        val data: LiveData<PagedList<PopularEntry>>,
        val networkErrors: LiveData<String>
)