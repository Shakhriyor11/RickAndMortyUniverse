package com.example.rickandmortyuniverse.data.model

data class PageInfoResponse(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String?
)