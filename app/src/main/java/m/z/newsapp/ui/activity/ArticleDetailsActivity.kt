package m.z.newsapp.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import m.z.newsapp.R
import m.z.newsapp.databinding.ActivityArticleDetailsBinding
import m.z.newsapp.model.Article
import m.z.newsapp.viewmodel.ArticleDetailsViewModel

/**
 * Created by Mongi Zaidi on 09/09/2025.
 */
@AndroidEntryPoint
class ArticleDetailsActivity : AppCompatActivity() {

    companion object {
        const val ARG_ARTICLE = "article"
    }

    private lateinit var binding: ActivityArticleDetailsBinding
    private val viewModel: ArticleDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityArticleDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        intent?.getStringExtra(ARG_ARTICLE)?.let { json ->
            try {
                val parsedArticle = Gson().fromJson(json, Article::class.java)
                viewModel.setArticle(parsedArticle)
            } catch (e: Exception) {
                viewModel.setArticle(null)
            }
        } ?: run {
            viewModel.setArticle(null)
        }
        
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed() // Or finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}