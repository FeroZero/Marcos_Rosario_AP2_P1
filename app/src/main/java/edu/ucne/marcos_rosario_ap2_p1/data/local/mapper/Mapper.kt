package edu.ucne.marcos_rosario_ap2_p1.data.local.mapper

import edu.ucne.marcos_rosario_ap2_p1.data.local.entities.CervezaEntity
import edu.ucne.marcos_rosario_ap2_p1.domain.model.Cerveza

fun CervezaEntity.toDomain(): Cerveza = Cerveza(
    id = id,
    nombre = nombre,
    Marca = Marca,
    Puntuacion = Puntuacion
)

fun Cerveza.toEntity(): CervezaEntity = CervezaEntity(
    id = id,
    nombre = nombre,
    Marca = Marca,
    Puntuacion = Puntuacion
)
