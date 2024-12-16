package com.example.pmdmtarea2.ui

// Imports necesarios.

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pmdmtarea2.R

/**
 * Fragmento para configuraciones generales de la aplicación.
 * No tinee configuraciones disponibles, pero si las tuviese serían representadas a partir de este fragment
 */
class SettingsFragment : Fragment() {

    /**
     * Método llamado para inflar el diseño del fragmento.
     *
     * @param inflater Objeto LayoutInflater utilizado para inflar el diseño.
     * @param container Contenedor padre del diseño.
     * @param savedInstanceState Estado previo de la instancia (si existe).
     * @return Vista inflada del fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el archivo de diseño XML asociado con este fragmento (fragment_settings.xml).
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
}
