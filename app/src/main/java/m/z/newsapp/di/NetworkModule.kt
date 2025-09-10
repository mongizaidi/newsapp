package m.z.newsapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import m.z.newsapp.network.NewsAPIClient
import m.z.newsapp.network.NewsAPIService
import m.z.newsapp.network.NewsRepository
import javax.inject.Singleton

/**
 * Created by Mongi Zaidi on 09/09/2025.
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideNewsAPIClient(): NewsAPIClient = NewsAPIClient()


    @Singleton
    @Provides
    fun provideNewsAPIService(newsAPIClient: NewsAPIClient): NewsAPIService =
        NewsAPIService(newsAPIClient)



    @Singleton
    @Provides
    fun provideNewsRepository(newsAPIService: NewsAPIService): NewsRepository =
        NewsRepository(newsAPIService)

}