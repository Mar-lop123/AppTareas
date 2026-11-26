package com.mar.tareas.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mar.tareas.domain.model.Tarea
import com.mar.tareas.domain.repository.TareaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TareaViewModel @Inject constructor(

    private val repository: TareaRepository

) : ViewModel() {

    val tareas: StateFlow<List<Tarea>> =
        repository.obtenerTareas().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun agregarTarea(nombre: String, descripcion: String) {

        val trimNombre: String = nombre.trim()
        if (trimNombre.isEmpty()) return

        viewModelScope.launch {
            repository.insertarTarea(
                Tarea(
                    nombre = trimNombre,
                    descripcion = descripcion.trim()
                )
            )

        }

    }

    fun eliminarTarea(tarea: Tarea) {
        viewModelScope.launch {
            repository.eliminarTarea(tarea)

        }

    }

    fun actualizarTarea(tarea: Tarea) {
        viewModelScope.launch {
            repository.actualizarTarea(tarea)

        }
    }

    fun cambiarEstado(tarea: Tarea, estado: Boolean) {
        viewModelScope.launch {
            repository.cambiarEstado(tarea.id, estado)

        }
    }
}
