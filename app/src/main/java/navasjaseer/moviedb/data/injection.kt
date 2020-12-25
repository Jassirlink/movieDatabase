package navasjaseer.moviedb.data

import navasjaseer.moviedb.data.database.CacheDatabase
import navasjaseer.moviedb.data.database.localCache.NowShowingLocalCache
import navasjaseer.moviedb.data.database.localCache.PopularLocalCache
import navasjaseer.moviedb.data.database.localCache.SearchLocalCache
import navasjaseer.moviedb.data.network.NetworkService
import navasjaseer.moviedb.data.repositories.MovieDetailsRepository
import navasjaseer.moviedb.data.repositories.NowShowingRepository
import navasjaseer.moviedb.data.repositories.PopularRepository
import navasjaseer.moviedb.data.repositories.SearchRepository
import navasjaseer.moviedb.ui.main.viewmodelfactory.ViewModelDetailFactory
import navasjaseer.moviedb.ui.main.viewmodelfactory.ViewModelNowShowingFactory
import navasjaseer.moviedb.ui.main.viewmodelfactory.ViewModelPopularFactory
import navasjaseer.moviedb.ui.main.viewmodelfactory.ViewModelSearchFactory
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import java.util.concurrent.Executors

object Injection {

    private fun provideSearchCache(context: Context): SearchLocalCache {
        val database = CacheDatabase.getInstance(context)
        return SearchLocalCache(database.searchDao(), Executors.newSingleThreadExecutor())
    }
    private fun provideSearchRepository(context: Context): SearchRepository {
        return SearchRepository(NetworkService.instance, provideSearchCache(context))
    }
    fun provideSearchViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelSearchFactory(provideSearchRepository(context))
    }

    private fun provideNowShowingCache(context: Context): NowShowingLocalCache {
        val database = CacheDatabase.getInstance(context)
        return NowShowingLocalCache(database.nowShowingDao(), Executors.newSingleThreadExecutor())
    }
    private fun provideNowShowingRepository(context: Context): NowShowingRepository {
        return NowShowingRepository(NetworkService.instance, provideNowShowingCache(context))
    }
    fun provideNowShowingViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelNowShowingFactory(provideNowShowingRepository(context))
    }

    private fun providePopularCache(context: Context): PopularLocalCache {
        val database = CacheDatabase.getInstance(context)
        return PopularLocalCache(database.poplarDao(), Executors.newSingleThreadExecutor())
    }
    private fun providePopularRepository(context: Context): PopularRepository {
        return PopularRepository(NetworkService.instance, providePopularCache(context))
    }
    fun providePopularViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelPopularFactory(providePopularRepository(context))
    }

    fun provideMovieDetailsRepository(): ViewModelProvider.Factory{
        val movieDetailsrepo = MovieDetailsRepository()
        return ViewModelDetailFactory(movieDetailsrepo)
    }

}