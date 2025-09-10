package m.z.newsapp.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ArticleTest {

    @Test
    fun `Article should be created with all required fields`() {
        // Given
        val author = "Test Author"
        val title = "Test Title"
        val description = "Test Description"
        val url = "https://test.com"
        val urlToImage = "https://test.com/image.jpg"
        val publishedAt = "2023-01-01T00:00:00Z"
        val content = "Test Content"

        // When
        val article = Article(author, title, description, url, urlToImage, publishedAt, content)

        // Then
        assertEquals(author, article.author)
        assertEquals(title, article.title)
        assertEquals(description, article.description)
        assertEquals(url, article.url)
        assertEquals(urlToImage, article.urlToImage)
        assertEquals(publishedAt, article.publishedAt)
        assertEquals(content, article.content)
    }

    @Test
    fun `Article should handle null values`() {
        // Given & When
        val article = Article(null, null, null, null, null, null, null)

        // Then
        assertNull(article.author)
        assertNull(article.title)
        assertNull(article.description)
        assertNull(article.url)
        assertNull(article.urlToImage)
        assertNull(article.publishedAt)
        assertNull(article.content)
    }

    @Test
    fun `Article should support data class equality`() {
        // Given
        val article1 = Article("Author", "Title", "Description", "URL", "ImageURL", "Date", "Content")
        val article2 = Article("Author", "Title", "Description", "URL", "ImageURL", "Date", "Content")
        val article3 = Article("Different Author", "Title", "Description", "URL", "ImageURL", "Date", "Content")

        // Then
        assertEquals(article1, article2)
        assertNotEquals(article1, article3)
    }

    @Test
    fun `Article should support data class copy`() {
        // Given
        val originalArticle = Article("Author", "Title", "Description", "URL", "ImageURL", "Date", "Content")

        // When
        val copiedArticle = originalArticle.copy(title = "New Title")

        // Then
        assertEquals("Author", copiedArticle.author)
        assertEquals("New Title", copiedArticle.title)
        assertEquals("Description", copiedArticle.description)
        assertNotEquals(originalArticle, copiedArticle)
    }
}
