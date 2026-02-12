package edu.ucne.marcos_rosario_ap2_p1.Navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object ListScreen : Screen()
    @Serializable
    data class EditScreen(val id: Int) : Screen()

}