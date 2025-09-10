package m.z.newsapp.network

import com.haroldadmin.cnradapter.NetworkResponse
import m.z.newsapp.model.APIError
import m.z.newsapp.model.NewsResponse
import javax.inject.Inject

/**
 * Created by Mongi Zaidi on 09/09/2025.
 */
class NewsAPIService @Inject constructor(private val newsAPIClient: NewsAPIClient) {
    suspend fun getTopHeadlines(
        language: String,
        category: String? = null,
        sources: String? = null,
        query: String? = null,
        pageSize: Int = 20,
        page: Int = 0
    ): NetworkResponse<NewsResponse, APIError> {
        return newsAPIClient.getNewsEndpoints()
            .getTopHeadlines(language, category, sources, query, pageSize, page)
    }
}