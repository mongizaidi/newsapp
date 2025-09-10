package m.z.newsapp.network

import m.z.newsapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class APIKeyHeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val requestBuilder: Request.Builder =
            request.newBuilder().method(request.method, request.body)

        addHeaders(requestBuilder)

        return chain.proceed(requestBuilder.build())
    }

    private fun addHeaders(requestBuilder: Request.Builder): Request.Builder =
        requestBuilder.header("Authorization", BuildConfig.NEWS_API_KEY)
}