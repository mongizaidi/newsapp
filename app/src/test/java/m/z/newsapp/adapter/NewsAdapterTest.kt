package m.z.newsapp.adapter

import m.z.newsapp.model.Article
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class NewsAdapterTest {

    @Mock
    private lateinit var mockListener: NewsAdapterListener

    private lateinit var adapter: NewsAdapter

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `NewsAdapter should be created with empty list`() {
        // Given
        val emptyList = emptyList<Article>()

        // When
        adapter = NewsAdapter(emptyList, mockListener)

        // Then
        assertEquals(0, adapter.itemCount)
    }

    @Test
    fun `NewsAdapter should be created with article list`() {
        // Given
        val articles = listOf(
            createMockArticle(title = "Article 1"),
            createMockArticle(title = "Article 2"),
            createMockArticle(title = "Article 3")
        )

        // When
        adapter = NewsAdapter(articles, mockListener)

        // Then
        assertEquals(3, adapter.itemCount)
    }

    @Test
    fun `NewsAdapter should extend BaseListAdapter`() {
        // Given
        val articles = listOf(createMockArticle())

        // When
        adapter = NewsAdapter(articles, mockListener)

        // Then
        assertTrue(adapter is BaseListAdapter<*, *>)
    }

    private fun createMockArticle(
        author: String = "Test Author",
        title: String = "Test Title",
        description: String = "Test Description",
        url: String = "https://test.com",
        urlToImage: String = "https://test.com/image.jpg",
        publishedAt: String = "2023-01-01T00:00:00Z",
        content: String = "Test Content"
    ): Article {
        return Article(author, title, description, url, urlToImage, publishedAt, content)
    }
}
