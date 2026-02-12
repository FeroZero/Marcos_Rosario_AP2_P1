package edu.ucne.marcos_rosario_ap2_p1.data.local.repository

import edu.ucne.marcos_rosario_ap2_p1.data.local.dao.CervezaDao
import edu.ucne.marcos_rosario_ap2_p1.data.local.mapper.toDomain
import edu.ucne.marcos_rosario_ap2_p1.data.local.mapper.toEntity
import edu.ucne.marcos_rosario_ap2_p1.domain.model.Cerveza
import edu.ucne.marcos_rosario_ap2_p1.domain.repository.CervezaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CervezaRepositoryImpl @Inject constructor(
    private val dao: CervezaDao
) : CervezaRepository {

    override fun observeAll(): Flow<List<Cerveza>> = dao.observeALL().map { list ->
        list.map { it.toDomain() }
    }

    override suspend fun getById(id: Int): Cerveza? = dao.getById(id)?.toDomain()

    override suspend fun upsert(cerveza: Cerveza): Int {
        dao.upsert(entity = cerveza.toEntity())
        return cerveza.id ?: 0
    }

    override suspend fun delete(id: Int) {
        dao.deleteById(id)
    }
}
