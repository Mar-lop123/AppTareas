package com.mar.tareas.domain.model

data class Tarea(

    val id: Int = 0,

    val nombre: String = "",

    val descripcion: String = "",

    val completada: Boolean = false,

    val categoriaId: Int = 1

)
