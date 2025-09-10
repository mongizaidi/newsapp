package m.z.newsapp.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNull
import org.junit.Test

class APIErrorTest {

    @Test
    fun `APIError should be created with all required fields`() {
        // Given
        val status = "error"
        val code = "400"
        val message = "Bad Request"

        // When
        val apiError = APIError(status, code, message)

        // Then
        assertEquals(status, apiError.status)
        assertEquals(code, apiError.code)
        assertEquals(message, apiError.message)
    }

    @Test
    fun `APIError should handle null values`() {
        // Given & When
        val apiError = APIError("error", null, null)

        // Then
        assertEquals("error", apiError.status)
        assertNull(apiError.code)
        assertNull(apiError.message)
    }

    @Test
    fun `APIError should support data class equality`() {
        // Given
        val apiError1 = APIError("error", "400", "Bad Request")
        val apiError2 = APIError("error", "400", "Bad Request")
        val apiError3 = APIError("error", "500", "Internal Server Error")

        // Then
        assertEquals(apiError1, apiError2)
        assertNotEquals(apiError1, apiError3)
    }

    @Test
    fun `APIError should support data class copy`() {
        // Given
        val originalError = APIError("error", "400", "Bad Request")

        // When
        val copiedError = originalError.copy(message = "New Error Message")

        // Then
        assertEquals("error", copiedError.status)
        assertEquals("400", copiedError.code)
        assertEquals("New Error Message", copiedError.message)
        assertNotEquals(originalError, copiedError)
    }
}
