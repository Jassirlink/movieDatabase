package navasjaseer.moviedb.data.database.localCache

import navasjaseer.moviedb.data.database.dao.SearchDao
import navasjaseer.moviedb.data.database.entities.SearchEntry
import androidx.paging.DataSource
import java.util.concurrent.Executor

class SearchLocalCache(
    private val searchDao: SearchDao,
    private val ioExecutor: Executor
) {

    /**
     * Insert a list of searches in the database, on a background thread.
     */
    fun insert(repos: List<SearchEntry>, insertFinished: ()-> Unit) {
        ioExecutor.execute {
            searchDao.insert(repos)
            insertFinished()
        }
    }

    fun searchesByName(name: String): DataSource.Factory<Int, SearchEntry> {
        // appending '%' so we can allow other characters to be before and after the query string
        val query = "%${name.replace(' ', '%')}%"
        return searchDao.searchesByName(query)
    }
}