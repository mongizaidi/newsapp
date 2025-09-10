package m.z.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import m.z.newsapp.model.Article
import javax.inject.Inject

/**
 * Created by Mongi Zaidi on 10/09/2025.
 */
@HiltViewModel
class ArticleDetailsViewModel @Inject constructor() : ViewModel() {
    private val _article = MutableLiveData<Article?>()
    val article: LiveData<Article?> = _article
    
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    
    fun setArticle(article: Article?) {
        if (article == null) {
            _error.postValue("Article not found")
        } else {
            _article.postValue(article)
            _error.postValue(null)
        }
    }
    
    fun clearError() {
        _error.postValue(null)
    }
}