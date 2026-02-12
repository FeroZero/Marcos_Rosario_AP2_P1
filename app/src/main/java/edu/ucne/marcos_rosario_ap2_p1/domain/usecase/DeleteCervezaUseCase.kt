package edu.ucne.marcos_rosario_ap2_p1.domain.usecase

import edu.ucne.marcos_rosario_ap2_p1.domain.repository.CervezaRepository

class DeleteCervezaUseCase(
    private val repository: CervezaRepository
) {
    suspend operator fun invoke(id: Int) = repository.delete(id)
}