package com.example.rickandmortyuniverse.domain.repository

import androidx.paging.PagingData
import com.example.rickandmortyuniverse.data.model.CharacterResponse
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacters(): Flow<PagingData<CharacterResponse>>
}