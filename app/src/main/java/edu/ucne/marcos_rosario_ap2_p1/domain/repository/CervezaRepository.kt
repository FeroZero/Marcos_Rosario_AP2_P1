package edu.ucne.marcos_rosario_ap2_p1.domain.repository

import edu.ucne.marcos_rosario_ap2_p1.domain.model.Cerveza
import kotlinx.coroutines.flow.Flow

interface CervezaRepository {

    fun observeAll(): Flow<List<Cerveza?>>

    suspend fun getById(id: Int) : Cerveza?

    suspend fun upsert(cerveza: Cerveza) : Int

    suspend fun delete(id: Int)
}