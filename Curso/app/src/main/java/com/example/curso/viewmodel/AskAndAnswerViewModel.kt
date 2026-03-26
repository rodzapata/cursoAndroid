package com.example.curso.viewmodel

import androidx.lifecycle.ViewModel
import com.example.curso.model.Pregunta
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AskAndAnswerViewModel : ViewModel() {
    private val _preguntas = MutableStateFlow(
        listOf(
            Pregunta(1, "¿Cómo te llamas?"),
            Pregunta(2, "¿Qué edad tienes?"),
            Pregunta(3, "¿Ciudad?")
        )
    )
    val preguntas: StateFlow<List<Pregunta>> = _preguntas

    private val _respuestas = MutableStateFlow<Map<Int, String>>(emptyMap())
    val respuestas: StateFlow<Map<Int, String>> = _respuestas

    fun onRespuestaChange(id: Int, valor: String) {
        _respuestas.value = _respuestas.value.toMutableMap().apply {
            put(id, valor)
        }
    }

    fun validar(): Boolean {
        return _preguntas.value.all {
            !_respuestas.value[it.id].isNullOrBlank()
        }
    }
}