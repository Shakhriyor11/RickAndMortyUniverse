package com.example.rickandmortyuniverse.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyuniverse.data.datasource.CharacterPagingDataSource
import com.example.rickandmortyuniverse.data.model.CharacterResponse
import com.example.rickandmortyuniverse.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val dataSource: CharacterPagingDataSource
) : CharacterRepository {

    override fun getCharacters(): Flow<PagingData<CharacterResponse>> {
        return Pager(PagingConfig(pageSize = 5)) { dataSource }.flow
    }
}