package com.example.pmdmtarea2

// Imports necesarios.
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.pmdmtarea2.ui.HomeFragment
import com.example.pmdmtarea2.ui.LanguageFragment
import com.example.pmdmtarea2.ui.SettingsFragment
import com.google.android.material.navigation.NavigationView

/**
 * Actividad principal de la aplicación.
 * Gestiona el menú lateral de navegación, la barra de herramientas, y permite cambiar entre fragmentos.
 */

class MainActivity : AppCompatActivity() {


    // El contenedor del menú lateral (DrawerLayout).

    private lateinit var drawerLayout: DrawerLayout

    /**
     * Método llamado al crear la actividad.
     *
     * @param savedInstanceState Estado de la actividad almacenado (si existe).
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configura la barra de herramientas (Toolbar)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Establece el título de la aplicación utilizando los recursos de idioma actuales
        supportActionBar?.title = getString(R.string.app_name)

        // Configura el menú lateral (DrawerLayout)
        drawerLayout = findViewById(R.id.drawer_layout)

        // Configura el NavigationView para manejar los clics en el menú
        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            handleNavigation(menuItem) // Método para manejar los clics del menú
        }

        // Si no hay estado previo guardado, carga el fragmento inicial (HomeFragment)
        if (savedInstanceState == null) {
            loadFragment(HomeFragment()) // Cargar HomeFragment por defecto
            navigationView.setCheckedItem(R.id.nav_home) // Seleccionar "Home" en el menú
        }
    }

    /**
     * Maneja la navegación cuando se selecciona un elemento del menú.
     *
     * @param menuItem El elemento del menú seleccionado.
     * @return `true` si se procesó correctamente, `false` en caso contrario.
     */

    private fun handleNavigation(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_home -> {
                // Carga fragmento de inicio
                loadFragment(HomeFragment())
            }
            R.id.nav_settings -> {
                // Carga fragmento de opciones
                loadFragment(SettingsFragment())
            }
            R.id.nav_language -> {
                // Carga fragmento del lenguaje
                loadFragment(LanguageFragment())
            }
            else -> return false // No reconocido
        }
        // Cierra el menú lateral
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    /**
     * Carga un fragmento dentro del contenedor definido.
     *
     * @param fragment Instancia del fragmento que se va a mostrar.
     */

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
    }


    /**
     * Crea el menú de opciones (action bar).
     *
     * @param menu El menú donde se inflará el archivo XML.
     * @return `true` para indicar que el menú está listo.
     */

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    /**
     * Maneja los clics en los elementos del menú de opciones.
     *
     * @param item El elemento seleccionado.
     * @return `true` si se manejó el evento, `false` en caso contrario.
     */

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                // Muestra el diálogo "Acerca de..."
                showAboutDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * Maneja el comportamiento al presionar el botón "Atrás".
     * Si el menú lateral está abierto, lo cierra. Si no, realiza la acción predeterminada.
     */
    override fun onBackPressed() {
        // Cierra el menú si está abierto
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed() // Comportamiento por defecto
        }
    }

    /**
     * Muestra un cuadro de diálogo con información "Acerca de...".
     */
    private fun showAboutDialog() {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.about_dialog_title))
            .setMessage(getString(R.string.about_dialog_message))
            .setIcon(R.drawable.info_icon)
            .setPositiveButton(getString(R.string.ok)) { dialog, _ -> dialog.dismiss() }
            .show()
    }
}
