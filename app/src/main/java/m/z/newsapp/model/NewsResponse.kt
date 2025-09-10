package m.z.newsapp.model

/**
 * Created by Mongi Zaidi on 09/09/2025.
 */
data class NewsResponse (
    val status: String,
    val totalResults: Int,
    val articles: List<Article>)