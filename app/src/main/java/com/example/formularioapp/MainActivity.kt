package com.example.formularioapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var cicloSeleccionado: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        val editTextApellido1 = findViewById<EditText>(R.id.editTextApellido1)
        val editTextApellido2 = findViewById<EditText>(R.id.editTextApellido2)
        val listViewCiclos = findViewById<ListView>(R.id.listViewCiclos)
        val buttonEnviar = findViewById<Button>(R.id.buttonEnviar)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)
        val buttonLimpiar = findViewById<Button>(R.id.buttonLimpiar)

        val ciclos = arrayOf("DAM", "DAW", "ASIR")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ciclos)
        listViewCiclos.adapter = adapter


        listViewCiclos.setOnItemClickListener { _, _, position, _ ->
            cicloSeleccionado = ciclos[position]
        }

        // Botón enviar
        buttonEnviar.setOnClickListener {
            val nombre = editTextNombre.text.toString()
            val apellido1 = editTextApellido1.text.toString()
            val apellido2 = editTextApellido2.text.toString()


            if (nombre.isNotEmpty() && apellido1.isNotEmpty() && apellido2.isNotEmpty() && cicloSeleccionado != null) {
                textViewResultado.text = "$nombre $apellido1 $apellido2\nHas solicitado matrícula en el ciclo $cicloSeleccionado."
            } else {
                textViewResultado.text = "Por favor, completa todos los campos y selecciona un ciclo."
            }
        }

        buttonLimpiar.setOnClickListener{
            editTextNombre.text.clear()
            editTextApellido1.text.clear()
            editTextApellido2.text.clear()
        }
    }
}


