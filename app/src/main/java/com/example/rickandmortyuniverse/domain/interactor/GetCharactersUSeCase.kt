package com.example.rickandmortyuniverse.domain.interactor

import androidx.paging.PagingData
import androidx.paging.map
import com.example.rickandmortyuniverse.data.model.CharacterResponse
import com.example.rickandmortyuniverse.domain.mapper.base.Mapper
import com.example.rickandmortyuniverse.domain.model.Character
import com.example.rickandmortyuniverse.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCharactersUSeCase @Inject constructor(
    private val repository: CharacterRepository,
    private val mapper: Mapper<CharacterResponse, Character>
) {

    fun invoke() : Flow<PagingData<Character>> =
        repository.getCharacters().map { pagingData ->
            pagingData.map { characterResponse ->
                mapper.map(characterResponse)
            }
        }
}