package com.example.pmdmtarea2

// Imports necesarios.

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adaptador que mostrará una lista de personajes Character en un RecyclerView.
 *
 * @param characterList Lista de objetos Character que se mostrarán.
 * @param onItemClick Callback que se ejecuta cuando se hace clic en un elemento, pasando el Character seleccionado.
 */

class CharacterAdapter(
    private val characterList: List<Character>, // Lista de personajes
    private val onItemClick: (Character) -> Unit    // Callback ejecutado al hacer clic en un elemento.
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    /**
     * ViewHolder que se encarga de gestionar cada elemento del RecyclerView.
     *
     * @param itemView Vista que representa el elemento individual.
     */

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val characterImage: ImageView = itemView.findViewById(R.id.characterImage) // Imagen del personaje
        val characterName: TextView = itemView.findViewById(R.id.characterName)   // Nombre del personaje
    }

    /**
     * Método que se llama para inflar el diseño de cada tarjeta.
     *
     * @param parent Vista padre donde se añadirá la tarjeta.
     * @param viewType Tipo de vista (no cambia en este caso)
     * @return Una nueva instancia de CharacterViewHolder.
     */

    // Infla el layout de cada tarjeta
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    /**
     * Método que vincula los datos de un personaje a una tarjeta.
     *
     * @param holder El ViewHolder que contiene la vista del elemento.
     * @param position La posición del elemento en la lista.
     */

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characterList[position] // Obtener el personaje actual
        holder.characterImage.setImageResource(character.imageResId) // Asignar imagen
        holder.characterName.text = character.name // Asignar nombre

        // Configura clic en cada tarjeta
        holder.itemView.setOnClickListener {
            onItemClick(character) // Llama al callback con el personaje seleccionado
        }
    }


    /**
     * Devuelve el número total de elementos en la lista.
     *
     * @return Tamaño de la lista de personajes.
     */
    // Número de elementos en la lista
    override fun getItemCount(): Int = characterList.size
}
