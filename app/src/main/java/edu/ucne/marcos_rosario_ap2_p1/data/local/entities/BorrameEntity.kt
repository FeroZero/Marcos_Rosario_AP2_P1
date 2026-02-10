package edu.ucne.marcos_rosario_ap2_p1.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Borrame")
data class BorrameEntity(
    @PrimaryKey(true)
    val id: Int = 0,

)
