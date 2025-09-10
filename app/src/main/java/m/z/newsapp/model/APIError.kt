package m.z.newsapp.model

/**
 * Created by Mongi Zaidi on 09/09/2025.
 */
data class APIError(
    val status: String,
    val code: String?,
    val message: String?
)