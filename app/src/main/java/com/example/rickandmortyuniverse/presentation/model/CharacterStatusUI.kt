package com.example.rickandmortyuniverse.presentation.model

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import com.example.rickandmortyuniverse.R

enum class CharacterStatusUI(
    @ColorRes
    val color: Int,
    @StringRes
    val naming: Int,
) {
    ALIVE(
        R.color.green,
        R.string.alive
    ),
    DEAD(
        R.color.red,
        R.string.dead
    ),
    UNKNOWN(
        R.color.black,
        R.string.unknown
    )
}