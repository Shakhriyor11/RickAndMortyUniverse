package com.example.rickandmortyuniverse.di

import com.example.rickandmortyuniverse.data.network.CharacterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {
    @Provides
    fun provideCharacterService(retrofit: Retrofit) : CharacterService =
        retrofit.create(CharacterService::class.java)
}