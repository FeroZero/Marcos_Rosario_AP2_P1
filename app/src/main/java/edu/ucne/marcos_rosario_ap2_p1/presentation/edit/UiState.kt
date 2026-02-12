package edu.ucne.marcos_rosario_ap2_p1.presentation.edit

import edu.ucne.marcos_rosario_ap2_p1.domain.model.Cerveza

data class UiState(
    val asignaturaId: Int? = null,
    val codigo: String = "",
    val nombre: String = "",
    val aula: String = "",
    val creditos: String = "",

    val codigoError: String? = null,
    val nombreError: String? = null,
    val aulaError: String? = null,
    val creditosError: String? = null,

    val isSaving: Boolean = false,
    val isDeleting: Boolean = false,
    val isNew: Boolean = true,
    val saved: Boolean = false,
    val deleted: Boolean = false,
    val cervezas: List<Cerveza> = emptyList()
)