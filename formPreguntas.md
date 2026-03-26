Perfecto, ahora vamos a llevar esto a un nivel **real de producción (senior 2026)** 🚀

Te voy a enseñar:

✅ Validación por campo (errores individuales)
✅ Mostrar errores en la UI
✅ Base de datos local con Room (offline-first básico)
✅ Preparado para sincronizar con backend

---

# 🧠 1. Modelo mejorado (UI + estado)

Primero mejoramos el modelo 👇

```kotlin
data class PreguntaUI(
    val id: Int,
    val texto: String,
    val respuesta: String = "",
    val error: String? = null
)
```

👉 Ahora cada campo tiene:

* respuesta
* error

🔥 Esto elimina el Map → más limpio y mantenible

---

# 🧠 2. ViewModel PRO

```kotlin
class AskAndAnswerViewModel : ViewModel() {

    private val _state = MutableStateFlow(
        listOf(
            PreguntaUI(1, "¿Cómo te llamas?"),
            PreguntaUI(2, "¿Qué edad tienes?"),
            PreguntaUI(3, "¿Ciudad?")
        )
    )

    val state: StateFlow<List<PreguntaUI>> = _state

    fun onRespuestaChange(id: Int, valor: String) {
        _state.value = _state.value.map {
            if (it.id == id) {
                it.copy(
                    respuesta = valor,
                    error = null // limpia error al escribir
                )
            } else it
        }
    }

    fun validar(): Boolean {
        var esValido = true

        _state.value = _state.value.map {
            if (it.respuesta.isBlank()) {
                esValido = false
                it.copy(error = "Este campo es obligatorio")
            } else it
        }

        return esValido
    }
}
```

---

# 🎨 3. UI con errores (Compose)

```kotlin
@Composable
fun AskAndAnswerScreen(viewModel: AskAndAnswerViewModel = viewModel()) {

    val preguntas by viewModel.state.collectAsState()

    val focusRequesters = remember {
        preguntas.map { FocusRequester() }
    }

    Column(modifier = Modifier.padding(16.dp)) {

        preguntas.forEachIndexed { index, pregunta ->

            OutlinedTextField(
                value = pregunta.respuesta,
                onValueChange = {
                    viewModel.onRespuestaChange(pregunta.id, it)
                },
                label = { Text(pregunta.texto) },

                isError = pregunta.error != null,

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .focusRequester(focusRequesters[index]),

                keyboardOptions = KeyboardOptions(
                    imeAction = if (index < preguntas.lastIndex)
                        ImeAction.Next else ImeAction.Done
                ),

                keyboardActions = KeyboardActions(
                    onNext = {
                        focusRequesters.getOrNull(index + 1)?.requestFocus()
                    },
                    onDone = {
                        viewModel.validar()
                    }
                )
            )

            // 🔴 Mostrar error debajo
            if (pregunta.error != null) {
                Text(
                    text = pregunta.error,
                    color = Color.Red,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        Button(
            onClick = { viewModel.validar() },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Guardar")
        }
    }
}
```

---

# 💾 4. Guardado local (Room) — Offline First básico

## 🔹 Entidad

```kotlin
@Entity(tableName = "respuestas")
data class RespuestaEntity(
    @PrimaryKey val preguntaId: Int,
    val respuesta: String
)
```

---

## 🔹 DAO

```kotlin
@Dao
interface RespuestaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardar(respuesta: RespuestaEntity)

    @Query("SELECT * FROM respuestas")
    suspend fun obtenerTodas(): List<RespuestaEntity>
}
```

---

## 🔹 Guardar desde ViewModel

```kotlin
fun guardarEnLocal() {
    viewModelScope.launch {
        _state.value.forEach {
            if (it.respuesta.isNotBlank()) {
                dao.guardar(
                    RespuestaEntity(it.id, it.respuesta)
                )
            }
        }
    }
}
```

---

# 🌐 5. Preparado para sincronizar (backend)

Cuando tengas internet:

```kotlin
fun sincronizar(api: ApiService) {
    viewModelScope.launch {

        val respuestas = _state.value.map {
            RespuestaDto(it.id, it.respuesta)
        }

        try {
            api.enviarRespuestas(respuestas)
        } catch (e: Exception) {
            // guardar para reintento
        }
    }
}
```

---

# 🧠 🧠 Nivel Senior — Arquitectura final

Así quedaría en producción:

```
UI (Compose)
   ↓
ViewModel
   ↓
UseCase (opcional pero recomendado)
   ↓
Repository
   ↓
Room (local) + API (remoto)
```

---

# 🚀 Mejores prácticas que estás aplicando

✔️ Estado inmutable (`copy`)
✔️ Single source of truth (StateFlow)
✔️ Validación en ViewModel (no en UI)
✔️ UI reactiva
✔️ Preparado para offline-first
✔️ Escalable a backend

---

# 🔥 Siguiente nivel (te lo recomiendo)

Si quieres subir otro nivel más (esto ya es nivel trabajo real):

👉 Validaciones más complejas:

* edad numérica
* longitud mínima
* regex

👉 Manejo de estados:

* loading
* success
* error

👉 Sincronización automática:

* WorkManager (cuando haya internet)

---

Si quieres, en el siguiente paso te enseño:

👉 🔥 **Cómo hacer sincronización automática tipo WhatsApp (offline-first real con WorkManager + Room + API)**
