package navasjaseer.moviedb.data.requestmodels

import navasjaseer.moviedb.data.models.Movie
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieRequest {
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int = 0
    @SerializedName("page")
    @Expose
    var page: Int = 0
    @SerializedName("results")
    @Expose
    var results: List<Movie>? = null
}