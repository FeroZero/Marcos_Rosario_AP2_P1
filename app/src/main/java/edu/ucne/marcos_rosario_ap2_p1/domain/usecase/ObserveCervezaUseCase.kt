package edu.ucne.marcos_rosario_ap2_p1.domain.usecase

import edu.ucne.marcos_rosario_ap2_p1.domain.model.Cerveza
import edu.ucne.marcos_rosario_ap2_p1.domain.repository.CervezaRepository
import kotlinx.coroutines.flow.Flow

data class ObserveCervezaUseCase(
    private val repository: CervezaRepository
) {
     operator fun invoke() : Flow<List<Cerveza?>> = repository.observeAll()
}