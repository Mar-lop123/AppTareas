package com.mar.tareas.data.database.entity

import androidx.room.Entity //definetablaBD
import androidx.room.PrimaryKey

@Entity(tableName = "categorias")
data class CategoriaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String
)

