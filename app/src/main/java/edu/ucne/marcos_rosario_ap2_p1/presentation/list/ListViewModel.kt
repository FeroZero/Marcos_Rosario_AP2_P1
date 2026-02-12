package edu.ucne.marcos_rosario_ap2_p1.presentation.list

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.marcos_rosario_ap2_p1.domain.usecase.DeleteCervezaUseCase
import edu.ucne.marcos_rosario_ap2_p1.domain.usecase.ObserveCervezaUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
private val observeCervezasUseCase: ObserveCervezaUseCase,
private val deleteCervezaUseCase: DeleteCervezaUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ListUiState(isLoading = true))
    val state: StateFlow<ListUiState> = _state.asStateFlow()

    init {
        loadCervezas()
    }

    fun onEvent(event: ListUiEvent) {
        when (event) {
            ListUiEvent.Load -> loadCervezas()
            ListUiEvent.Refresh -> loadCervezas()
            is ListUiEvent.Delete -> onDelete(event.id)
            is ListUiEvent.ShowMessage -> _state.update {
                it.copy(message = event.message)
            }
            ListUiEvent.ClearMessage -> _state.update {
                it.copy(message = null)
            }
            ListUiEvent.CreateNew -> _state.update {
                it.copy(navigateToCreate = true)
            }
            is ListUiEvent.Edit -> _state.update {
                it.copy(navigateToEditId = event.id)
            }
        }
    }

    private fun loadCervezas() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            observeCervezasUseCase().collectLatest { list ->
                _state.update {
                    it.copy(isLoading = false, cervezas = list, message = null)
                }
            }
        }
    }

    private fun onDelete(id: Int) {
        viewModelScope.launch {
            deleteCervezaUseCase(id)
            onEvent(ListUiEvent.ShowMessage("Cerveza eliminada con éxito"))
        }
    }

    fun onNavigatedToCreate() {
        _state.update { it.copy(navigateToCreate = false) }
    }

    fun onNavigatedToEdit() {
        _state.update { it.copy(navigateToEditId = null) }
    }
}