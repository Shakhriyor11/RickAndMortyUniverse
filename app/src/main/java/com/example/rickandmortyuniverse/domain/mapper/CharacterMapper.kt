package com.example.rickandmortyuniverse.domain.mapper

import com.example.rickandmortyuniverse.data.model.CharacterResponse
import com.example.rickandmortyuniverse.domain.mapper.base.Mapper
import com.example.rickandmortyuniverse.domain.model.Character
import com.example.rickandmortyuniverse.domain.model.Location
import com.example.rickandmortyuniverse.domain.model.Origin
import com.example.rickandmortyuniverse.domain.model.getCharacterStatusEnum
import javax.inject.Inject

class CharacterMapper @Inject constructor() : Mapper<CharacterResponse, Character>() {
    override fun map(from: CharacterResponse) = from.run {
        Character(
            id = id,
            name = name,
            status = getCharacterStatusEnum(status),
            species = species,
            type = type,
            gender = gender,
            origin = Origin(
                origin.name,
                origin.url
            ),
            image = image,
            url = url,
            location = Location(
                name = name,
                url = url
            ),
            episode = episode
        )
    }

}