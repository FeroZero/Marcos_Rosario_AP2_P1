package edu.ucne.marcos_rosario_ap2_p1.presentation.edit

import edu.ucne.marcos_rosario_ap2_p1.domain.model.Cerveza

data class UiState(
    val id: Int? = null,
    val nombre: String = "",
    val marca: String = "",
    val puntuacion: Int,

    val nombreError: String? = null,
    val marcaError: String? = null,
    val puntuacionError: String? = null,

    val isSaving: Boolean = false,
    val isDeleting: Boolean = false,
    val isNew: Boolean = true,
    val saved: Boolean = false,
    val deleted: Boolean = false,
    val cervezas: List<Cerveza?> = emptyList()
)
