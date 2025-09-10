package m.z.newsapp.adapter

import m.z.newsapp.R
import m.z.newsapp.databinding.ItemNewsArticleBinding
import m.z.newsapp.model.Article

/**
 * Created by Mongi Zaidi on 10/09/2025.
 */
class NewsAdapter(
    list: List<Article>,
    private val newsAdapterListener: NewsAdapterListener
) : BaseListAdapter<ItemNewsArticleBinding, Article>(list) {

    override val layoutId: Int = R.layout.item_news_article

    override fun bind(binding: ItemNewsArticleBinding, item: Article) {
        binding.apply {
            article = item
            listener = newsAdapterListener
            executePendingBindings()
        }
    }
}

interface NewsAdapterListener {
    fun onArticleClicked(article: Article)
}