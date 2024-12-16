package com.example.pmdmtarea2.ui

// Imports necesarios

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pmdmtarea2.Character
import com.example.pmdmtarea2.CharacterAdapter
import com.example.pmdmtarea2.DetailActivity
import com.example.pmdmtarea2.R
import com.google.android.material.snackbar.Snackbar

/**
 * Fragmento que representa la pantalla de inicio.
 * Muestra una lista de personajes utilizando un RecyclerView.
 */

class HomeFragment : Fragment() {

    /**
     * Referencia al RecyclerView que contiene la lista de personajes.
     */
    private lateinit var recyclerView: RecyclerView // Referencia al RecyclerView


    /**
     * Método llamado para inflar el diseño del fragmento.
     *
     * @param inflater Objeto LayoutInflater utilizado para inflar el diseño.
     * @param container Contenedor padre del diseño.
     * @param savedInstanceState Estado previo de la instancia (si existe).
     * @return Vista inflada del fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el archivo de diseño XML asociado con este fragmento (fragment_home.xml)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    /**
     * Método llamado después de que la vista haya sido creada.
     *
     * @param view Vista creada para este fragmento.
     * @param savedInstanceState Estado previo de la instancia (si existe).
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configura el RecyclerView para mostrar la lista de personajes.
        recyclerView = view.findViewById(R.id.recyclerView)


        // Lista de los personajes a mostrar.
        val characters = listOf(
            Character( // Para Mario
                getString(R.string.character_mario_name),
                R.drawable.mario,
                getString(R.string.character_mario_description),
                getString(R.string.character_mario_abilities)
            ),
            Character( // Para Luigi
                getString(R.string.character_luigi_name),
                R.drawable.luigi,
                getString(R.string.character_luigi_description),
                getString(R.string.character_luigi_abilities)
            ),
            Character( // Para Peach
                getString(R.string.character_peach_name),
                R.drawable.peach,
                getString(R.string.character_peach_description),
                getString(R.string.character_peach_abilities)
            ),
            Character( // Para Toad
                getString(R.string.character_toad_name),
                R.drawable.toad,
                getString(R.string.character_toad_description),
                getString(R.string.character_toad_abilities)
            )
        )


        // Configura el adaptador para manejar los clics en los personajes.
        val adapter = CharacterAdapter(characters) { selectedCharacter ->
            // Muestra mensaje "Toast" al abrir la pantalla de detalles
            Toast.makeText(
                requireContext(),
                getString(R.string.toast_character_selected, selectedCharacter.name),
                Toast.LENGTH_SHORT
            ).show()

            // Abre la actividad de detalles del personaje.
            val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                putExtra("name", selectedCharacter.name)
                putExtra("imageResId", selectedCharacter.imageResId)
                putExtra("description", selectedCharacter.description)
                putExtra("abilities", selectedCharacter.abilities)
            }
            startActivity(intent)
        }

        // Establece el diseño y el adaptador en el RecyclerView.
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Muestra un mensaje de bienvenida "Snackbar" al cargar la pantalla mediante Snackbar.
        Snackbar.make(view, getString(R.string.snackbar_welcome_message), Snackbar.LENGTH_LONG).show()
    }
}
