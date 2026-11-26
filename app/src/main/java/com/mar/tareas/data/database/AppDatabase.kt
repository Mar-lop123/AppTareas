package com.mar.tareas.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mar.tareas.data.database.dao.CategoriaDao
import com.mar.tareas.data.database.dao.TareaDao
import com.mar.tareas.data.database.entity.CategoriaEntity
import com.mar.tareas.data.database.entity.TareaEntity

@Database(
    entities = [
        TareaEntity::class,
        CategoriaEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tareaDao(): TareaDao

    abstract fun categoriaDao(): CategoriaDao

}
