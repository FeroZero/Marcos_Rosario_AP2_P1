package edu.ucne.marcos_rosario_ap2_p1.presentation.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.marcos_rosario_ap2_p1.domain.model.Cerveza
import edu.ucne.marcos_rosario_ap2_p1.domain.usecase.DeleteCervezaUseCase
import edu.ucne.marcos_rosario_ap2_p1.domain.usecase.GetCervezaUseCase
import edu.ucne.marcos_rosario_ap2_p1.domain.usecase.ObserveCervezaUseCase
import edu.ucne.marcos_rosario_ap2_p1.domain.usecase.UpsertCervezaUseCase
import edu.ucne.marcos_rosario_ap2_p1.domain.usecase.ValidateMarca
import edu.ucne.marcos_rosario_ap2_p1.domain.usecase.ValidateNombre
import edu.ucne.marcos_rosario_ap2_p1.domain.usecase.ValidatePuntuacion
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.text.equals

@HiltViewModel
class ViewModel @Inject constructor(
    private val getCervezaUseCase: GetCervezaUseCase,
    private val upsertCervezaUseCase: UpsertCervezaUseCase,
    private val deleteCervezaUseCase: DeleteCervezaUseCase,
    private val observeCervezasUseCase: ObserveCervezaUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = MutableStateFlow(UiState(puntuacion = 0))
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            observeCervezasUseCase().collect { lista ->
                _state.update { it.copy(cervezas = lista) }
            }
        }

        val id: Int? = savedStateHandle["id"]
        if (id != null && id > 0) {
            onLoad(id)
        } else {
            onEvent(UiEvent.New)
        }
    }

    private fun validar(): Boolean {
        val nombreRes = ValidateNombre(state.value.nombre)
        val marcaRes = ValidateMarca(state.value.marca)
        val puntuacionRes = ValidatePuntuacion(state.value.puntuacion)

        _state.update {
            it.copy(
                nombreError = nombreRes.errorMessage,
                marcaError = marcaRes.errorMessage,
                puntuacionError = puntuacionRes.errorMessage
            )
        }

        return nombreRes.isValid && marcaRes.isValid && puntuacionRes.isValid
    }

    fun onEvent(event: UiEvent) {
        when (event) {
            is UiEvent.Load -> onLoad(event.id)
            is UiEvent.Delete -> onDelete(event.id)
            is UiEvent.NombreChanged -> {
                _state.update { it.copy(nombre = event.value, nombreError = null) }
            }
            is UiEvent.MarcaChanged -> {
                _state.update { it.copy(marca = event.value, marcaError = null) }
            }
            is UiEvent.PuntuacionChanged -> {
                _state.update { it.copy(puntuacion = event.value, puntuacionError = null) }
            }
            UiEvent.Save -> onSave()
            UiEvent.New -> {
                _state.update {
                    UiState(
                        puntuacion = 0,
                        cervezas = _state.value.cervezas,
                        saved = false,
                        deleted = false
                    )
                }
            }
        }
    }

    private fun onLoad(id: Int?) {
        if (id == null || id == 0) return

        viewModelScope.launch {
            val cerveza = getCervezaUseCase(id)
            cerveza?.let { item ->
                _state.update {
                    it.copy(
                        isNew = false,
                        id = item.id,
                        nombre = item.nombre,
                        marca = item.Marca,
                        puntuacion = item.Puntuacion,
                        nombreError = null,
                        marcaError = null,
                        puntuacionError = null
                    )
                }
            }
        }
    }

    private fun onSave() {
        if (!validar()) return

        viewModelScope.launch {
            _state.update { it.copy(isSaving = true) }

            val lista = observeCervezasUseCase().first()
            val existe = lista.filterNotNull().any {
                it.nombre.equals(state.value.nombre, ignoreCase = true) && it.id != state.value.id
            }

            if (existe) {
                _state.update {
                    it.copy(
                        nombreError = "Ya existe una cerveza con este nombre",
                        isSaving = false
                    )
                }
                return@launch
            }

            val cerveza = Cerveza(
                id = state.value.id,
                nombre = state.value.nombre,
                Marca = state.value.marca,
                Puntuacion = state.value.puntuacion
            )

            upsertCervezaUseCase(cerveza)
            _state.update { it.copy(isSaving = false, saved = true) }
        }
    }

    private fun onDelete(id: Int) {
        viewModelScope.launch {
            _state.update { it.copy(isDeleting = true) }
            deleteCervezaUseCase(id)
            _state.update { it.copy(isDeleting = false, deleted = true) }
        }
    }

    fun resetSavedStatus() {
        _state.update {
            it.copy(
                saved = false,
                deleted = false
            )
        }
    }
}