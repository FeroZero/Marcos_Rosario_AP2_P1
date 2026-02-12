package edu.ucne.marcos_rosario_ap2_p1.domain.usecase

import edu.ucne.marcos_rosario_ap2_p1.domain.model.Cerveza
import edu.ucne.marcos_rosario_ap2_p1.domain.repository.CervezaRepository
import javax.inject.Inject

data class UpsertCervezaUseCase @Inject constructor(
    private val repository: CervezaRepository
) {
    suspend operator fun invoke(cerveza: Cerveza) : Result<Int>{
        val nombreResult = ValidateNombre(cerveza.nombre)
        if(!nombreResult.isValid){
            return Result.failure(IllegalArgumentException(nombreResult.errorMessage))
        }

        val marcaResult = ValidateMarca(cerveza.Marca)
        if(!marcaResult.isValid){
            return Result.failure(IllegalArgumentException(marcaResult.errorMessage))
        }

        val puntuacionResult = ValidatePuntuacion(cerveza.Puntuacion)
        if(!puntuacionResult.isValid){
            return Result.failure(IllegalArgumentException(puntuacionResult.errorMessage))
        }

        return runCatching { repository.upsert(cerveza) }
    }
}