package com.example.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.PrintStream
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
        lateinit var myAdapter : ArrayAdapter<String>
        var ListaTareas = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        agregar_Id.setOnClickListener {obtenerDatos()}

        cargarDatos()
        leerDatos()
        mostrarTareas()
        borrarDatos()
    }

    fun mostrarTareas (){
        Log.d("lpl", "lista es lll ${ListaTareas.toString()}")
        myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListaTareas)
        lista_Id.adapter = myAdapter
        myAdapter.notifyDataSetChanged()

    }

    fun cargarDatos(){
        val outStream = PrintStream(openFileOutput("Tareas.txt", Context.MODE_PRIVATE))
        outStream.println("Sonrie")
        outStream.println("jugar")
        outStream.println("a")
        outStream.close()
    }

    fun leerDatos(){
        var leerArchivo = Scanner(openFileInput("Tareas.txt"))
        while(leerArchivo.hasNextLine()) {
            var linea = leerArchivo.nextLine()
            ListaTareas.add(linea)
        }

        }
    fun borrarDatos(){
        lista_Id.setOnItemClickListener { parent, view, position, id ->
            ListaTareas.removeAt(position)
            myAdapter.notifyDataSetChanged()
        }

        }

    fun obtenerDatos(){
        var obtarea = texto_Id.text.toString()
        val outStream = PrintStream(openFileOutput("Tareas.txt", Context.MODE_PRIVATE))
        outStream.println(obtarea)
        var leerArchivo = Scanner(openFileInput("Tareas.txt"))
        while(leerArchivo.hasNextLine()){
        Log.d("lep", "- ${leerArchivo.nextLine()}")
        }
        outStream.close()
        ListaTareas.add(obtarea)
        mostrarTareas ()
    }

    fun poblarArchivo (){
        val outStream = PrintStream(openFileOutput("Tareas.txt", Context.MODE_PRIVATE))
        for (l in ListaTareas){
         outStream.println(l)
        }

    }
}
