package com.real_estate.apioffline.di

import android.app.Application
import androidx.room.Room
import com.real_estate.apioffline.api.ContactListAPI
import com.real_estate.apioffline.data.ContactListDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(ContactListAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideCarListAPI(retrofit: Retrofit): ContactListAPI =
        retrofit.create(ContactListAPI::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): ContactListDatabase =
        Room.databaseBuilder(app, ContactListDatabase::class.java, "contactlist_database")
            .build()
}