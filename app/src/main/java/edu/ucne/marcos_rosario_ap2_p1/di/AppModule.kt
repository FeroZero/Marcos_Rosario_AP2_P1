package edu.ucne.marcos_rosario_ap2_p1.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.marcos_rosario_ap2_p1.data.local.database.Database
import edu.ucne.marcos_rosario_ap2_p1.data.local.repository.CervezaRepositoryImpl
import edu.ucne.marcos_rosario_ap2_p1.domain.repository.CervezaRepository
import javax.inject.Singleton
import edu.ucne.marcos_rosario_ap2_p1.data.local.dao.CervezaDao

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    @Singleton
    fun bindCervezaRepository(
        impl: CervezaRepositoryImpl
    ): CervezaRepository

    companion object {
        @Provides
        @Singleton
        fun provideCervezaDb(
            @ApplicationContext appContext: Context
        ): Database = Room.databaseBuilder(
            appContext,
            Database::class.java,
            "Cerveza.db"
        )
            .fallbackToDestructiveMigration()
            .build()

        @Provides
        fun provideCervezaDao(db: Database) = db.cervezaDao()
    }
}

