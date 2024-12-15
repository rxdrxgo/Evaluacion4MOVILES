package com.example.evaluacion4

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Asegúrate de usar tu layout correcto

        textView = findViewById(R.id.num)  // El TextView donde mostrarás la temperatura
        databaseReference = FirebaseDatabase.getInstance().getReference("datos/Temp")  // Ruta en Firebase

        // Escuchar cambios en la base de datos
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // Obtener el valor de "Temperatura" directamente
                val temperatura = snapshot.child("Temperatura").getValue(Int::class.java)

                // Verificar si obtenemos el valor correctamente
                if (temperatura != null) {
                    textView.text = "$temperatura"  // Mostrar la temperatura en el TextView
                } else {
                    textView.text = "0"  // Si no hay datos
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Maneja cualquier error que ocurra
            }
        })
    }
}
