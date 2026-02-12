package edu.ucne.marcos_rosario_ap2_p1.data.local.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.marcos_rosario_ap2_p1.data.local.entities.CervezaEntity

@Database(
    entities = [CervezaEntity::class],
    version = 2,
    exportSchema = false

)
abstract class Database : RoomDatabase(){
    abstract fun cervezaDao() : Dao
}
