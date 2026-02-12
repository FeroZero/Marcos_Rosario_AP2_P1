package edu.ucne.marcos_rosario_ap2_p1.presentation.edit

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.marcos_rosario_ap2_p1.domain.usecase.DeleteCervezaUseCase
import edu.ucne.marcos_rosario_ap2_p1.domain.usecase.GetCervezaUseCase
import edu.ucne.marcos_rosario_ap2_p1.domain.usecase.ObserveCervezaUseCase
import edu.ucne.marcos_rosario_ap2_p1.domain.usecase.UpsertCervezaUseCase
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val getCervezaUseCase: GetCervezaUseCase,
    private val upsertCervezaUseCase: UpsertCervezaUseCase,
    private val deleteCervezaUseCase: DeleteCervezaUseCase,
    private val observeCervezaUseCase: ObserveCervezaUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
