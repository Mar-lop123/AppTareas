
package com.mar.tareas.data.di

import com.mar.tareas.data.repository.TareaRepositoryImp
import com.mar.tareas.domain.repository.TareaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton//restringeLacreaciondeobjetos

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTareaRepository(
        repository: TareaRepositoryImp
    ): TareaRepository
}

