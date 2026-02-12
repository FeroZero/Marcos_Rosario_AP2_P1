package edu.ucne.marcos_rosario_ap2_p1.presentation.list

sealed class ListUiEvent {
    data object Load : ListUiEvent()
    data object Refresh : ListUiEvent()
    data class Delete(val id: Int) : ListUiEvent()
    data class ShowMessage(val message: String) : ListUiEvent()
    data object ClearMessage : ListUiEvent()
    data object CreateNew : ListUiEvent()
    data class Edit(val id: Int) : ListUiEvent()
}