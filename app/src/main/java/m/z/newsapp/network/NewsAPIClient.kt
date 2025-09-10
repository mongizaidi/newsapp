package m.z.newsapp.network

import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import m.z.newsapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Mongi Zaidi on 09/09/2025.
 */
class NewsAPIClient {

    companion object {
        private const val BASE_URL = "https://newsapi.org/v2/"
        const val CLIENT_TIMEOUT: Long = 30
        private var instance: NewsEndpoints? = null
    }

    @Synchronized
    fun getNewsEndpoints(): NewsEndpoints {
        if (instance == null) {
            val httpClientBuilder = OkHttpClient.Builder()
                .connectTimeout(CLIENT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(CLIENT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(CLIENT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(APIKeyHeaderInterceptor())
            if (BuildConfig.DEBUG) {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                httpClientBuilder.addInterceptor(httpLoggingInterceptor)
            }
            val retrofit = Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(NetworkResponseAdapterFactory())
                .baseUrl(BASE_URL)
                .build()
            instance = retrofit.create(NewsEndpoints::class.java)

        }
        return instance as NewsEndpoints
    }
}