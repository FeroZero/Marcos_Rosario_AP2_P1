package edu.ucne.marcos_rosario_ap2_p1.presentation.list

import edu.ucne.marcos_rosario_ap2_p1.domain.model.Cerveza

data class ListUiState(
    val isLoading: Boolean = false,
    val cervezas: List<Cerveza?> = emptyList(),
    val message: String? = null,
    val navigateToCreate: Boolean = false,
    val navigateToEditId: Int? = null,
    val error: String? = null
)