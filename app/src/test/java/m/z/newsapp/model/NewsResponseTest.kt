package m.z.newsapp.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class NewsResponseTest {

    @Test
    fun `NewsResponse should be created with all required fields`() {
        // Given
        val status = "ok"
        val totalResults = 100
        val articles = listOf(
            Article("Author1", "Title1", "Description1", "URL1", "ImageURL1", "Date1", "Content1"),
            Article("Author2", "Title2", "Description2", "URL2", "ImageURL2", "Date2", "Content2")
        )

        // When
        val newsResponse = NewsResponse(status, totalResults, articles)

        // Then
        assertEquals(status, newsResponse.status)
        assertEquals(totalResults, newsResponse.totalResults)
        assertEquals(2, newsResponse.articles.size)
        assertEquals("Title1", newsResponse.articles[0].title)
        assertEquals("Title2", newsResponse.articles[1].title)
    }

    @Test
    fun `NewsResponse should handle empty articles list`() {
        // Given
        val status = "ok"
        val totalResults = 0
        val articles = emptyList<Article>()

        // When
        val newsResponse = NewsResponse(status, totalResults, articles)

        // Then
        assertEquals(status, newsResponse.status)
        assertEquals(totalResults, newsResponse.totalResults)
        assertTrue(newsResponse.articles.isEmpty())
    }

    @Test
    fun `NewsResponse should support data class equality`() {
        // Given
        val articles = listOf(Article("Author", "Title", "Description", "URL", "ImageURL", "Date", "Content"))
        val newsResponse1 = NewsResponse("ok", 1, articles)
        val newsResponse2 = NewsResponse("ok", 1, articles)
        val newsResponse3 = NewsResponse("error", 1, articles)

        // Then
        assertEquals(newsResponse1, newsResponse2)
        assertNotEquals(newsResponse1, newsResponse3)
    }

    @Test
    fun `NewsResponse should support data class copy`() {
        // Given
        val articles = listOf(Article("Author", "Title", "Description", "URL", "ImageURL", "Date", "Content"))
        val originalResponse = NewsResponse("ok", 1, articles)

        // When
        val copiedResponse = originalResponse.copy(status = "error")

        // Then
        assertEquals("error", copiedResponse.status)
        assertEquals(1, copiedResponse.totalResults)
        assertEquals(1, copiedResponse.articles.size)
        assertNotEquals(originalResponse, copiedResponse)
    }
}
