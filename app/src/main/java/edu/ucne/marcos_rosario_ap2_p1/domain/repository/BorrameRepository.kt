package edu.ucne.marcos_rosario_ap2_p1.domain.repository

import edu.ucne.marcos_rosario_ap2_p1.domain.model.Borrame
import kotlinx.coroutines.flow.Flow

interface BorrameRepository {

    fun observeById(id: Int): Flow<Borrame?>
}