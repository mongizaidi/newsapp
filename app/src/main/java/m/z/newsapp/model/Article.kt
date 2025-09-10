package m.z.newsapp.model

import m.z.newsapp.adapter.ListAdapterItem

/**
 * Created by Mongi Zaidi on 09/09/2025.
 */
data class Article (
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?) : ListAdapterItem