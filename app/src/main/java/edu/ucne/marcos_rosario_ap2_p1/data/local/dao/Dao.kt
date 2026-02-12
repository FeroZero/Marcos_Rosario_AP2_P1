package edu.ucne.marcos_rosario_ap2_p1.data.local.dao

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import edu.ucne.marcos_rosario_ap2_p1.data.local.entities.CervezaEntity
import kotlinx.coroutines.flow.Flow

interface Dao {
    @Upsert
    suspend fun upsert(entity: CervezaEntity)

    @Query("SELECT * FROM Cerveza ORDER BY id DESC")
    suspend fun observeALL() : Flow<List<CervezaEntity>>

    @Query("SELECT * FROM Cerveza WHERE id = :id")
    suspend fun getById(id: Int) : CervezaEntity?

    @Delete
    suspend fun delete(entity: CervezaEntity)

    @Query("DELETE FROM Cerveza WHERE id = :id")
    suspend fun deleteById(id: Int) : CervezaEntity
}