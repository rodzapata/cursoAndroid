package com.example.curso.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.curso.viewmodel.AskAndAnswerViewModel

@Composable
fun AskAndAnswer(modifier: Modifier = Modifier) {
    val vm: AskAndAnswerViewModel = viewModel()

    val preguntas by vm.preguntas.collectAsState()
    val respuestas by vm.respuestas.collectAsState()

    val focusList = remember { List(preguntas.size) { FocusRequester() } }

    Column(modifier = Modifier.padding(16.dp)) {

        preguntas.forEachIndexed { index, pregunta ->

            OutlinedTextField(
                value = respuestas[pregunta.id] ?: "",
                onValueChange = {
                    vm.onRespuestaChange(pregunta.id, it)
                },
                label = { Text(pregunta.texto) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .focusRequester(focusList[index]),

                keyboardOptions = KeyboardOptions(
                    imeAction = if (index < preguntas.lastIndex)
                        ImeAction.Next else ImeAction.Done
                ),

                keyboardActions = KeyboardActions(
                    onNext = {
                        focusList[index + 1].requestFocus()
                    },
                    onDone = {
                        // enviar
                    }
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (vm.validar()) {
                    println("Formulario válido ✅")
                } else {
                    println("Faltan campos ❌")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar")
        }
    }
}