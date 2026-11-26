package com.mar.tareas.data.repository

import com.mar.tareas.data.database.dao.CategoriaDao
import com.mar.tareas.data.database.dao.TareaDao
import com.mar.tareas.data.database.entity.CategoriaEntity
import com.mar.tareas.data.mapper.toDomain
import com.mar.tareas.data.mapper.toEntity
import com.mar.tareas.domain.model.Tarea
import com.mar.tareas.domain.repository.TareaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TareaRepositoryImp @Inject constructor(
    private val tareaDao: TareaDao,
    private val categoriaDao: CategoriaDao
) : TareaRepository {

    override fun obtenerTareas(): Flow<List<Tarea>> {
        return tareaDao.obtenerTareas().map { lista ->
            lista.map { it.toDomain() }
        }
    }

    override suspend fun insertarTarea(tarea: Tarea) {
        categoriaDao.insertarCategoria(
            CategoriaEntity(id = 1, nombre = "General")
        )
        tareaDao.insertarTarea(tarea.toEntity())
    }

    override suspend fun actualizarTarea(tarea: Tarea) {
        tareaDao.actualizarTarea(tarea.toEntity())
    }

    override suspend fun eliminarTarea(tarea: Tarea) {
        tareaDao.eliminarTarea(tarea.toEntity())
    }

    override suspend fun cambiarEstado(id: Int, estado: Boolean) {
        tareaDao.cambiarEstado(id, estado)
    }
}
