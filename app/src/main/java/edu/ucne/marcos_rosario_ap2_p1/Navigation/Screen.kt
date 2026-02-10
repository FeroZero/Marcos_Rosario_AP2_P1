package edu.ucne.marcos_rosario_ap2_p1.Navigation

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object ListScreen : Screen()
    data object EditScreen : Screen()

}