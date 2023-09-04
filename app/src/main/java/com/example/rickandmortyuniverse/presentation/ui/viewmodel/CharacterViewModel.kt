package com.example.rickandmortyuniverse.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import com.example.rickandmortyuniverse.domain.interactor.GetCharactersUSeCase
import com.example.rickandmortyuniverse.domain.mapper.base.Mapper
import com.example.rickandmortyuniverse.domain.model.Character
import com.example.rickandmortyuniverse.presentation.model.CharacterUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    getCharactersUseCase: GetCharactersUSeCase,
    private val mapper: Mapper<Character, CharacterUI>,
) : ViewModel() {
    val characters: StateFlow<PagingData<CharacterUI>> =
        getCharactersUseCase.invoke().map { pagingData ->
            pagingData.map { character ->
                mapper.map(character)
            }
        }.stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            PagingData.empty()
        )
}