package edu.ucne.marcos_rosario_ap2_p1.presentation.edit


sealed interface UiEvent {
    data class Load(val id: Int) : UiEvent
    data class NombreChanged(val value: String) : UiEvent
    data class MarcaChanged(val value: String) : UiEvent
    data class PuntuacionChanged(val value: Int) : UiEvent
    data object Save : UiEvent
    data class Delete(val id: Int) : UiEvent
    data object New : UiEvent
}