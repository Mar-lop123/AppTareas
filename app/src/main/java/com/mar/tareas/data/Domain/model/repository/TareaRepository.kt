package com.mar.tareas.domain.repository

import com.mar.tareas.domain.model.Tarea
import kotlinx.coroutines.flow.Flow

interface TareaRepository {

    fun obtenerTareas(): Flow<List<Tarea>>

    suspend fun insertarTarea(tarea: Tarea)

    suspend fun actualizarTarea(tarea: Tarea)

    suspend fun eliminarTarea(tarea: Tarea)

    suspend fun cambiarEstado(id: Int, estado: Boolean)

}
