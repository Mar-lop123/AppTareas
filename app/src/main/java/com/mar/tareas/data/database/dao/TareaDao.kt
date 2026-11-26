package com.mar.tareas.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mar.tareas.data.database.entity.TareaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TareaDao {

    @Insert
    suspend fun insertarTarea(tarea: TareaEntity)

    @Update
    suspend fun actualizarTarea(tarea: TareaEntity)

    @Delete
    suspend fun eliminarTarea(tarea: TareaEntity)

    @Query("SELECT * FROM tareas WHERE id = :id")
    fun obtenerTarea(id: Int): Flow<TareaEntity?>

    @Query("SELECT * FROM tareas ORDER BY id DESC")
    fun obtenerTareas(): Flow<List<TareaEntity>>

    @Query("UPDATE tareas SET completada = :estado WHERE id = :id")
    suspend fun cambiarEstado(id: Int, estado: Boolean)

}
