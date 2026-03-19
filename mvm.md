Perfecto, vamos a hacerlo **como en un proyecto real (nivel profesional 2026)** usando:

* 🧠 `ViewModel`
* 🔄 `StateFlow`
* 🎯 Arquitectura limpia (UI desacoplada)

Esto es exactamente lo que usarías en una app como la tuya de órdenes de servicio 👇

---

# 🧩 1. ViewModel (manejo del estado)

```kotlin
class MainViewModel : ViewModel() {

    private val _nombre = MutableStateFlow("")
    val nombre: StateFlow<String> = _nombre

    fun onNombreChange(nuevo: String) {
        _nombre.value = nuevo
    }
}
```

---

# 🖥️ 2. UI (Composable limpio)

```kotlin
@Composable
fun MainView(
    viewModel: MainViewModel = viewModel(),
    modifier: Modifier = Modifier
) {

    val nombre by viewModel.nombre.collectAsState()

    Column(modifier = modifier) {

        Text(text = "Comprar")

        TextField(
            value = nombre,
            onValueChange = { viewModel.onNombreChange(it) },
            placeholder = {
                Text("nombre")
            }
        )
    }
}
```

---

# 🔁 3. Flujo completo (muy importante entender esto)

```
Usuario escribe → TextField → onValueChange →
ViewModel → StateFlow → UI se actualiza automáticamente
```

👉 Esto es el patrón recomendado en Jetpack Compose

---

# ✅ 4. Validación del campo (como app real)

Vamos a validar que no esté vacío:

## ViewModel

```kotlin
class MainViewModel : ViewModel() {

    private val _nombre = MutableStateFlow("")
    val nombre: StateFlow<String> = _nombre

    val esValido: StateFlow<Boolean> =
        _nombre.map { it.isNotBlank() }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

    fun onNombreChange(nuevo: String) {
        _nombre.value = nuevo
    }
}
```

---

## UI

```kotlin
@Composable
fun MainView(viewModel: MainViewModel = viewModel()) {

    val nombre by viewModel.nombre.collectAsState()
    val esValido by viewModel.esValido.collectAsState()

    Column {

        Text(text = "Comprar")

        TextField(
            value = nombre,
            onValueChange = { viewModel.onNombreChange(it) },
            placeholder = { Text("nombre") },
            isError = !esValido
        )

        if (!esValido) {
            Text(
                text = "El nombre es obligatorio",
                color = Color.Red
            )
        }
    }
}
```

---

# 🚀 5. Botón para enviar (listo para backend)

```kotlin
Button(
    onClick = {
        // Aquí llamas API (Spring Boot / .NET)
        println("Nombre: $nombre")
    },
    enabled = esValido
) {
    Text("Guardar")
}
```

---

# 🏗️ 6. Cómo se conecta con tu backend (tu caso real)

Dado que tú trabajas con:

* Spring Boot
* .NET 8
* APIs REST

👉 el siguiente paso sería:

```kotlin
fun guardar() {
    viewModelScope.launch {
        repository.guardarCliente(nombre.value)
    }
}
```

---

# 🧠 Mejores prácticas clave (esto es lo que te hace pro)

✔ UI sin lógica
✔ ViewModel maneja estado
✔ Uso de `StateFlow` (NO LiveData en 2026)
✔ Validaciones reactivas
✔ Listo para Clean Architecture

---

# 🔥 Siguiente nivel (te lo recomiendo)

Si quieres avanzar de verdad en Android moderno, el siguiente paso sería:

👉 Formularios completos (como órdenes de servicio)
👉 Múltiples campos (cliente, equipo, estado)
👉 Conexión real con API
👉 Guardado offline + sincronización (como me preguntaste antes)

---

Si quieres, en el siguiente paso te armo:

✅ un **formulario completo tipo orden de servicio (como tu proyecto real)**
✅ con varios `TextField`, dropdowns y botón guardar
✅ conectado a un backend simulado

Eso ya sería nivel semi-profesional 🚀
