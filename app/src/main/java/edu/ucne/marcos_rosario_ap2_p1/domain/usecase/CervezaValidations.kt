package edu.ucne.marcos_rosario_ap2_p1.domain.usecase

import kotlin.text.isBlank

data class ValidationResult(
    val isValid: Boolean,
    val errorMessage: String = "",
)

fun ValidateNombre(value: String) : ValidationResult{
    if(value.isBlank()) return ValidationResult(false,"Campo Obligatorio.")
    return ValidationResult(true)
}

fun ValidateMarca(value: String) : ValidationResult{
    if(value.isBlank()) return ValidationResult(false, "Campo Obligatorio.")
    if(value.contains("1,2,3,4,5,6,7,8,9,0")) return ValidationResult(false, "Caracter Invalido.")
    return ValidationResult(true)
}

fun ValidatePuntuacion(value: Int?) : ValidationResult{
    if(value == null) return ValidationResult(false, "Campo Obligatorio.")
    if(value < 0) return ValidationResult(false, "El rango tiene que ser del 1 al 5.")
    if(value > 6) return ValidationResult(false, "El rango tiene que ser del 1 al 5.")
    return ValidationResult(true)
}