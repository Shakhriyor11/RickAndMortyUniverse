package com.example.rickandmortyuniverse.di

import com.example.rickandmortyuniverse.data.model.CharacterResponse
import com.example.rickandmortyuniverse.domain.mapper.CharacterMapper
import com.example.rickandmortyuniverse.domain.mapper.base.Mapper
import com.example.rickandmortyuniverse.domain.model.Character
import com.example.rickandmortyuniverse.presentation.mapper.CharacterUIMapper
import com.example.rickandmortyuniverse.presentation.model.CharacterUI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindCharacterMapper(
        mapper: CharacterMapper
    ) : Mapper<CharacterResponse, Character>

    @Binds
    abstract fun bindCharacterUIMapper(
        mapper: CharacterUIMapper
    ) : Mapper<Character, CharacterUI>
}