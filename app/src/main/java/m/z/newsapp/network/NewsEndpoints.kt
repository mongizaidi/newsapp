package m.z.newsapp.network

import com.haroldadmin.cnradapter.NetworkResponse
import m.z.newsapp.model.APIError
import m.z.newsapp.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Mongi Zaidi on 09/09/2025.
 */
interface NewsEndpoints {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("language") language: String,
        @Query("category") category: String?,
        @Query("sources") sources: String?,
        @Query("q") query: String?,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int
    ): NetworkResponse<NewsResponse, APIError>

}
