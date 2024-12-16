package com.example.pmdmtarea2

// Imports necesarios.

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

/**
 * Actividad que muestra la pantalla de inicio al abrir la aplicación.
 * Redirige al usuario a la actividad principal después de unos segundos.
 */

class SplashActivity : AppCompatActivity() {


    /**
     * Método llamado al crear la actividad.
     *
     * @param savedInstanceState Estado de la actividad almacenado (si existe).
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        // Delay de 3 segundos antes de redirigir al MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            // Crea un Intent para iniciar la actividad principal
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) // Inicia MainActivity
            finish() // Finaliza la actividad actual para evitar volver atrás
        }, 3000) // Retraso de 3000ms = 3 segundos
    }
}
