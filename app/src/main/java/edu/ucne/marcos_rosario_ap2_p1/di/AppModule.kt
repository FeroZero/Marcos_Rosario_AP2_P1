package edu.ucne.marcos_rosario_ap2_p1.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class AppModule {

    companion object {
        @Provides
        @Singleton
        fun provideEstudianteDb(@ApplicationContext appContext: Context) =
            databaseBuilder(
                appContext,
                klass = ,
                name =
            ).fallbackToDestructiveMigration()
                .build()
    }
}