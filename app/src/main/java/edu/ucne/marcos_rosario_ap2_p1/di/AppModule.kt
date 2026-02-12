package edu.ucne.marcos_rosario_ap2_p1.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.marcos_rosario_ap2_p1.data.local.database.Database
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideEstudianteDb(
        @ApplicationContext appContext: Context
    ): Database = Room.databaseBuilder(
        appContext,
        Database::class.java,
        "Cerveza.db"
    )
        .fallbackToDestructiveMigration()
        .build()
}