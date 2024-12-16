package com.example.pmdmtarea2

/**
 * Clase diseñada para representar a los personajes con sus atributos:
 *
 * @property name Nombre del personaje.
 * @property imageResId ID del recurso de la imagen asociada al personaje.
 * @property description Breve descripción del personaje.
 * @property abilities Habilidades especiales de los personajes.
 */

data class Character(
    val name: String,         // Nombre del personaje
    val imageResId: Int,      // ID del recurso de imagen (R.drawable.mario)
    val description: String,  // Descripción del personaje
    val abilities: String     // Habilidades del personaje
)
