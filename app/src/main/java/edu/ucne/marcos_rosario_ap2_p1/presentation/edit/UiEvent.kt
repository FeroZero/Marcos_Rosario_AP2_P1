package edu.ucne.marcos_rosario_ap2_p1.presentation.edit


sealed interface UiEvent {
    data class Load(val id: Int) : UiEvent
    data class CodigoChanged(val value: String) : UiEvent
    class NombreChanged(val value: String) : UiEvent
    data class AulaChanged(val value: String) : UiEvent
    data class CreditosChanged(val value: String) : UiEvent
    data object Save : UiEvent
    data class Delete(val id: Int) : UiEvent
    data object New : UiEvent
}