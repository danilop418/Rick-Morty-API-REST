package edu.iesam.rickmortyapi.features.rickmortyapi.presentation

data class CharacterModel(
    val id: Int,
    val name: String,
    val isAlive: Boolean,
    val image: String
)
