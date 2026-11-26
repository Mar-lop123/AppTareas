package com.mar.tareas.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.mar.tareas.data.database.entity.CategoriaEntity
import com.mar.tareas.data.database.relaciones.CategoriaConTareas
import kotlinx.coroutines.flow.Flow
//define operaciones
@Dao
interface CategoriaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertarCategoria(categoria: CategoriaEntity): Long

    @Query("SELECT * FROM categorias")
    fun obtenerCategorias(): Flow<List<CategoriaEntity>>

    @Transaction
    @Query("SELECT * FROM categorias")
    fun obtenerCategoriasConTareas(): Flow<List<CategoriaConTareas>>

}
