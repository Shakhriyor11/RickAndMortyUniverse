package com.example.rickandmortyuniverse.presentation.mapper

import com.example.rickandmortyuniverse.domain.mapper.base.Mapper
import com.example.rickandmortyuniverse.presentation.model.CharacterUI
import com.example.rickandmortyuniverse.domain.model.Character
import com.example.rickandmortyuniverse.domain.model.CharacterStatus
import com.example.rickandmortyuniverse.presentation.model.CharacterStatusUI
import com.example.rickandmortyuniverse.presentation.model.LocationUI
import com.example.rickandmortyuniverse.presentation.model.OriginUI
import javax.inject.Inject

class CharacterUIMapper @Inject constructor() : Mapper<Character, CharacterUI>() {
    override fun map(from: Character) = from.run {
        CharacterUI(
            id = id,
            name = name,
            status = status.convertToUI(),
            species = species,
            type = type,
            gender = gender,
            origin = OriginUI(
                origin.name,
                origin.url
            ),
            image = image,
            url = url,
            location = LocationUI(
                name = name,
                url = url
            ),
            episode = episode
        )
    }
}

fun CharacterStatus.convertToUI(): CharacterStatusUI {
    return when (this) {
        CharacterStatus.ALIVE -> CharacterStatusUI.ALIVE
        CharacterStatus.DEAD -> CharacterStatusUI.DEAD
        CharacterStatus.UNKNOWN -> CharacterStatusUI.UNKNOWN
    }
}