package com.mar.tareas.data.database.relaciones

import androidx.room.Embedded
import androidx.room.Relation
import com.mar.tareas.data.database.entity.CategoriaEntity
import com.mar.tareas.data.database.entity.TareaEntity

data class CategoriaConTareas(

    @Embedded
    val categoria: CategoriaEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "categoriaId"
    )
    val tareas: List<TareaEntity>

)
