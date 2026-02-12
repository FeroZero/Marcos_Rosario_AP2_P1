package edu.ucne.marcos_rosario_ap2_p1.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cerveza")
data class CervezaEntity(
    @PrimaryKey(true)
    val id: Int? = null,
    val nombre: String,
    val Marca: String,
    val Puntuacion: Int,
)
