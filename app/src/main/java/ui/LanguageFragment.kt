package com.example.pmdmtarea2.ui

// Imports necesarios.

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.fragment.app.Fragment
import com.example.pmdmtarea2.MainActivity
import com.example.pmdmtarea2.R
import java.util.Locale

/**
 * Fragmento que permite cambiar el idioma de la aplicación.Lo hace mediante un Switch que permite cambiar entre español-inglés
 */
class LanguageFragment : Fragment() {

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

        // Infla el archivo de diseño XML asociado con este fragmento.
        val view = inflater.inflate(R.layout.fragment_language, container, false)

        // Configura el Switch del idioma.
        val switchLanguage: Switch = view.findViewById(R.id.switchLanguage)

        // Obtiene el idioma actual y establece el estado inicial del Switch.
        val currentLocale = getCurrentLocale()
        switchLanguage.isChecked = currentLocale.language == "en" // True si está en inglés

        // Configura el listener para detectar cambios en el estado del Switch.
        switchLanguage.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                setLocale("en") // Cambia idioma a inglés
            } else {
                setLocale("es") // Cambia idioma a español
            }
        }

        return view
    }


    /**
     * Obtiene el idioma actual de la configuración del dispositivo.
     *
     * @return Objeto Locale representando el idioma actual.
     */
    private fun getCurrentLocale(): Locale {
        // Obtiene la configuración actual del idioma
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            resources.configuration.locales[0]
        } else {
            @Suppress("DEPRECATION")
            resources.configuration.locale
        }
    }


    /**
     * Cambia el idioma de la aplicación.
     *
     * @param languageCode Código del idioma (ej., "en" o "es").
     */
    private fun setLocale(languageCode: String) {
        // Cambia la configuración del idioma global de la app
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

        // Reinicia la aplicación para aplicar los cambios.
        restartApp()
    }

    /**
     * Reinicia la actividad principal para aplicar los cambios de idioma.
     */
    private fun restartApp() {
        // Reinicia la actividad principal de manera controlada
        val intent = Intent(requireActivity(), MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        requireActivity().finish()
    }
}
