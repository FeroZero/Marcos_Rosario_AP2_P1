package edu.ucne.marcos_rosario_ap2_p1.data.local.dao

import androidx.room.Upsert
import edu.ucne.marcos_rosario_ap2_p1.data.local.entities.BorrameEntity

interface Dao {
    @Upsert
    suspend fun upsert(entity: BorrameEntity)
}