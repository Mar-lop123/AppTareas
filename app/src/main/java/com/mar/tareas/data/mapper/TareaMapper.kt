package com.mar.tareas.data.mapper

import com.mar.tareas.data.database.entity.TareaEntity
import com.mar.tareas.domain.model.Tarea

fun TareaEntity.toDomain(): Tarea = Tarea(

    id = id,
    nombre = nombre,
    descripcion = descripcion,
    completada = completada,
    categoriaId = categoriaId

)

fun Tarea.toEntity(): TareaEntity = TareaEntity(

    id = id,
    nombre = nombre,
    descripcion = descripcion,
    completada = completada,
    categoriaId = categoriaId

)
