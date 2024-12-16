package com.example.pmdmtarea2

// Imports necesarios.


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Actividad que muestra los detalles de un personaje seleccionado.
 * Recibe datos del personaje mediante un Intent.
 */

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Enlazamos los elementos de la interfaz de usuario con sus IDs en el layout.
        val imageView: ImageView = findViewById(R.id.imageViewDetail) // Imagen  del personaje.
        val textViewName: TextView = findViewById(R.id.textViewNameDetail) // Nombre del personaje.
        val textViewDescription: TextView = findViewById(R.id.textViewDescription) // Descripción del personaje.
        val textViewAbilities: TextView = findViewById(R.id.textViewAbilities) // Habilidades del personaje.

        // Obtenemos los datos enviados desde el Intent.
        val name = intent.getStringExtra("name") ?: "Nombre no disponible" // Valor por defecto (nombre)
        val imageResId = intent.getIntExtra("imageResId", 0) // 0 si no hay imagen
        if (imageResId != 0) { // Si se proporciona un ID de imagen válido, lo asignmaos. De lo contrario, usamos una imagen vacía.
            imageView.setImageResource(imageResId)
        } else {
            imageView.setImageResource(android.R.color.transparent) // Imagen vacía (si no hay ninguna)
        }

        val description = intent.getStringExtra("description") ?: "Descripción no disponible" // Descripción por defecto.
        val abilities = intent.getStringExtra("abilities") ?: "Habilidades no disponibles" // Habilidad por defecto.

        // Actualizamos los elementos de la interfaz de usuario con los datos recibidos.
        textViewName.text = name
        textViewDescription.text = description
        textViewAbilities.text = abilities
    }
}

