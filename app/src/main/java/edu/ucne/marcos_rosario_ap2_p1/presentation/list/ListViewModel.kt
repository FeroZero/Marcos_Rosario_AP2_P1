package edu.ucne.marcos_rosario_ap2_p1.presentation.list

import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.marcos_rosario_ap2_p1.domain.usecase.DeleteCervezaUseCase
import edu.ucne.marcos_rosario_ap2_p1.domain.usecase.ObserveCervezaUseCase
import edu.ucne.marcos_rosario_ap2_p1.presentation.edit.ViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val observeCervezaUseCase: ObserveCervezaUseCase,
    private val deleteCervezaUseCase: DeleteCervezaUseCase
) : ViewModel() {

