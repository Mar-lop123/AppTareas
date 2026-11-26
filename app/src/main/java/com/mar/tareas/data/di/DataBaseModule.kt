package com.mar.tareas.data.di

import android.content.Context
import androidx.room.Room
import com.mar.tareas.data.database.AppDatabase
import com.mar.tareas.data.database.dao.CategoriaDao
import com.mar.tareas.data.database.dao.TareaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
//ComparteUnaSolaInstancia


    @Singleton
    @Provides
    fun getInstance(
        @ApplicationContext context: Context
    ): AppDatabase {

        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "lista_tareas.db"
        ).build()

    }

    @Provides
    fun provideTareaDao(database: AppDatabase): TareaDao {
        return database.tareaDao()

    }

    @Provides
    fun provideCategoriaDao(database: AppDatabase): CategoriaDao {
        return database.categoriaDao()

    }

}
