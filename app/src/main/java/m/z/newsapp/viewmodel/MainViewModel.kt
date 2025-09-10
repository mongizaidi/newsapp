package m.z.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haroldadmin.cnradapter.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import m.z.newsapp.model.Article
import m.z.newsapp.network.NewsRepository
import javax.inject.Inject

/**
 * Created by Mongi Zaidi on 10/09/2025.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {
    private val _newsArticles = MutableLiveData<List<Article>>()
    val newsArticles: LiveData<List<Article>> = _newsArticles
    private val _isFetching = MutableLiveData(false)
    val isFetching: LiveData<Boolean> = _isFetching
    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage
    private val _isError = MutableLiveData(false)
    val isError: LiveData<Boolean> = _isError

    fun fetchNews() {
        if (_isFetching.value == true) {
            return
        }
        _isFetching.postValue(true)
        _errorMessage.postValue(null)
        _isError.postValue(false)

        viewModelScope.launch {
            try {
                // Hardcoding language to English
                // because the API doesn't return news for other languages
                val language = "en" // Locale.getDefault().language
                when (val response = newsRepository.getTopHeadlines(language)) {
                    is NetworkResponse.Success -> {
                        val articles = response.body.articles
                        if (articles.isNotEmpty()) {
                            _newsArticles.postValue(articles)
                            _isError.postValue(false)
                        } else {
                            _isError.postValue(true)
                            _errorMessage.postValue("No news articles found")
                        }
                        _isFetching.postValue(false)
                    }

                    is NetworkResponse.Error -> {
                        _isFetching.postValue(false)
                        val errorMessage = response.body?.message
                            ?: "Failed to load news. Please check your internet connection."
                        _isError.postValue(true)
                        _errorMessage.postValue(errorMessage)
                    }
                }
            } catch (e: Exception) {
                _isFetching.postValue(false)
                _isError.postValue(true)
                _errorMessage.postValue("Network error: ${e.message}")
            }
        }
    }

    fun retry() {
        fetchNews()
    }

    fun clearError() {
        _errorMessage.postValue(null)
        _isError.postValue(false)
    }
}