package com.albrecht3.change_color

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var lvColor: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Cargar Preferencias y Aplicar Tema
        sharedPreferences = getSharedPreferences("Values", MODE_PRIVATE)
        val theme = sharedPreferences.getInt("Theme", 1)
        applyAppTheme(theme)

        setContentView(R.layout.activity_main)

        // 2. Rellenar el array
        val iconoDatos = arrayOf(
            Datos(R.drawable.bg_azul, "Azul"),
            Datos(R.drawable.bg_rojo, "Rojo"),
            Datos(R.drawable.bg_verde, "Verde"),
            Datos(R.drawable.bg_naranja, "Naranja"),
            Datos(R.drawable.bg_morado, "Morado"),
            Datos(R.drawable.bg_rosa, "Rosa"),
            Datos(R.drawable.bg_amarillo, "Amarillo"),
            Datos(R.drawable.bg_negro, "Negro")
        )

        // 3. Configurar Adapter y ListView
        val adapter = DatosAdapter(this, R.layout.listview_item_row, iconoDatos)
        lvColor = findViewById(R.id.lv)
        lvColor.adapter = adapter

        // 4. Listener de Clicks usando lambdas
        lvColor.setOnItemClickListener { _, _, position, _ ->
            // En Kotlin, 'when' sustituye al switch de forma elegante
            val selectedTheme = position + 2
            updateTheme(selectedTheme)
        }
    }

    private fun applyAppTheme(theme: Int) {
        val themeRes = when (theme) {
            2 -> R.style.AppBlue
            3 -> R.style.AppRed
            4 -> R.style.AppGreen
            5 -> R.style.AppOrange
            6 -> R.style.AppViolet
            7 -> R.style.AppPink
            8 -> R.style.AppYellow
            9 -> R.style.AppBlack
            else -> R.style.AppTheme
        }
        setTheme(themeRes)
    }

    private fun updateTheme(newTheme: Int) {
        // Usando la extensión KTX .edit { ... }
        sharedPreferences.edit {
            putInt("Theme", newTheme)
        }

        finish()
        // En lugar de startActivity(intent), crea uno nuevo explícito
        val refreshIntent = Intent(this, MainActivity::class.java)
        startActivity(refreshIntent)

        // Animación
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            overrideActivityTransition(OVERRIDE_TRANSITION_OPEN, R.anim.fade_in, R.anim.fade_out)
        } else {
            @Suppress("DEPRECATION")
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
    }
}