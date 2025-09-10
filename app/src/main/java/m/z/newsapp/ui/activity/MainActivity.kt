package m.z.newsapp.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import m.z.newsapp.R
import m.z.newsapp.adapter.NewsAdapter
import m.z.newsapp.adapter.NewsAdapterListener
import m.z.newsapp.databinding.ActivityMainBinding
import m.z.newsapp.model.Article
import m.z.newsapp.network.NewsRepository
import m.z.newsapp.viewmodel.MainViewModel
import javax.inject.Inject

/**
 * Created by Mongi Zaidi on 09/09/2025.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NewsAdapterListener {
    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var newsRepository: NewsRepository
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        binding.adapter = NewsAdapter(listOf(), this)
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchNews()
    }

    override fun onArticleClicked(article: Article) {
        val intent = Intent(this, ArticleDetailsActivity::class.java)
        intent.putExtra(ArticleDetailsActivity.ARG_ARTICLE, Gson().toJson(article))
        startActivity(intent)
    }
}