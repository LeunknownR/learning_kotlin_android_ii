package com.example.learningkotlin_ii.data.network

import com.example.learningkotlin_ii.BuildConfig
import com.example.learningkotlin_ii.data.repository.HoroscopeRepositoryImpl
import com.example.learningkotlin_ii.application.HoroscopeRepository
import com.example.learningkotlin_ii.data.network.interceptors.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient
            .Builder()
            .addInterceptor(logging)
            .addInterceptor(authInterceptor)
            .build()
    }
    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit): HoroscopeApiService {
        return retrofit.create(HoroscopeApiService::class.java)
    }
    @Provides
    fun provideHoroscopeRepository(horoscopeApiService: HoroscopeApiService): HoroscopeRepository {
        return HoroscopeRepositoryImpl(horoscopeApiService)
    }
}