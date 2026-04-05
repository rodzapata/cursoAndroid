En Kotlin (especialmente con **Jetpack Compose**), el concepto de **“Screen” (pantalla)** se utiliza para **representar una vista completa de la UI dentro de tu aplicación**.

No es una clase obligatoria del lenguaje, sino **un patrón de diseño muy usado**.

---

## 🧠 ¿Qué es un Screen?

Un **Screen** es básicamente:

👉 Una función `@Composable` que representa **una pantalla completa de la app**

Ejemplos típicos:

- LoginScreen
- HomeScreen
- DetailScreen
- FormScreen

---

## 📱 ¿Para qué se utiliza?

### 1. Separar la UI por pantallas

Cada funcionalidad importante tiene su propia pantalla.

```kotlin
@Composable
fun LoginScreen() {
    Text("Pantalla de Login")
}
```

```kotlin
@Composable
fun HomeScreen() {
    Text("Pantalla principal")
}
```

---

### 2. Trabajar con navegación (Navigation Compose)

Las **screens son clave cuando usas navegación**.

```kotlin
NavHost(navController, startDestination = "login") {
    composable("login") { LoginScreen() }
    composable("home") { HomeScreen() }
}
```

👉 Aquí cada ruta representa una **Screen**

---

### 3. Aplicar Clean Architecture

Cada Screen normalmente tiene:

- Su **ViewModel**
- Su **estado**
- Su **lógica de UI**

Ejemplo:

```kotlin
@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val state = viewModel.state

    Column {
        TextField(value = state.user, onValueChange = { })
        Button(onClick = { viewModel.login() }) {
            Text("Ingresar")
        }
    }
}
```

---

### 4. Mantener código organizado (nivel profesional)

En proyectos reales (como el que tú quieres hacer tipo SAMM):

📂 Estructura típica:

```
ui/
 ├── login/
 │    ├── LoginScreen.kt
 │    ├── LoginViewModel.kt
 │    └── LoginState.kt
 ├── home/
 │    ├── HomeScreen.kt
 │    └── HomeViewModel.kt
```

---

## 🔥 Diferencia clave (IMPORTANTE)

| Concepto | Qué es                             |
| -------- | ---------------------------------- |
| Activity | Contenedor Android tradicional     |
| Fragment | Parte reutilizable (viejo enfoque) |
| Screen   | Pantalla en Compose (moderno)      |

👉 En 2026:

- ❌ Fragment → casi no se usa en apps nuevas
- ✅ Screen + Navigation Compose → estándar actual

---

## 🧩 Ejemplo real (como senior)

```kotlin
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Scaffold(
        topBar = { TopAppBar(title = { Text("Inicio") }) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Text("Bienvenido ${state.username}")
        }
    }
}
```

---

## 🚀 Resumen claro

Un **Screen en Kotlin (Compose)** se usa para:

✅ Representar una pantalla completa
✅ Organizar la UI
✅ Manejar navegación
✅ Conectar con ViewModel
✅ Aplicar arquitectura limpia

---

Si quieres, en el siguiente paso puedo enseñarte:

👉 Cómo estructurar **todas las Screens** para tu app de mantenimiento de aire acondicionado tipo SAMM (nivel profesional real)

Muy buena pregunta — aquí es donde muchos se confunden al aplicar **Clean Architecture en Android (2026)**. Vamos directo, como lo haría un senior 👇

---

# 🧠 ¿Qué va en cada archivo?

## 📄 `LoginState.kt` → SOLO ESTADO (UI State)

Este archivo representa **cómo se ve la pantalla en un momento dado**.

👉 No tiene lógica
👉 No tiene funciones
👉 Solo datos

---

### ✅ Ejemplo correcto

```kotlin
data class LoginState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false
)
```

---

### 🧩 ¿Qué representa esto?

| Campo     | Para qué sirve            |
| --------- | ------------------------- |
| email     | lo que escribe el usuario |
| password  | lo que escribe el usuario |
| isLoading | mostrar loader            |
| error     | mostrar mensaje de error  |
| isSuccess | navegación o éxito        |

---

## 📄 `LoginViewModel.kt` → LÓGICA + MANEJO DE ESTADO

Aquí va TODO lo importante:

👉 Manejo del estado
👉 Eventos del usuario
👉 Llamadas a casos de uso (backend)
👉 Reglas de negocio simples de UI

---

## ✅ Ejemplo PRO (usando StateFlow + Hilt)

```kotlin
@HiltViewModel
class LoginViewModel @Inject constructor(
    // aquí irían tus casos de uso (UseCases)
    // private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state

    // 📌 Evento: usuario escribe email
    fun onEmailChange(email: String) {
        _state.value = _state.value.copy(email = email)
    }

    // 📌 Evento: usuario escribe password
    fun onPasswordChange(password: String) {
        _state.value = _state.value.copy(password = password)
    }

    // 📌 Evento: botón login
    fun onLoginClick() {
        val currentState = _state.value

        if (currentState.email.isBlank() || currentState.password.isBlank()) {
            _state.value = currentState.copy(
                error = "Campos vacíos"
            )
            return
        }

        login()
    }

    private fun login() {
        // Simulación (luego conectas con backend Spring Boot)
        _state.value = _state.value.copy(isLoading = true)

        // Simulación de respuesta
        _state.value = _state.value.copy(
            isLoading = false,
            isSuccess = true
        )
    }
}
```

---

# 🔥 Cómo se conecta con la Screen

```kotlin
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()

    Column {
        OutlinedTextField(
            value = state.value.email,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("Email") }
        )

        OutlinedTextField(
            value = state.value.password,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = { Text("Password") }
        )

        Button(onClick = { viewModel.onLoginClick() }) {
            Text("Login")
        }

        if (state.value.isLoading) {
            CircularProgressIndicator()
        }

        state.value.error?.let {
            Text(it, color = Color.Red)
        }
    }
}
```

---

# ⚠️ ERRORES comunes (evítalos)

❌ Meter lógica en el `State`
❌ Llamar API directamente desde la Screen
❌ Usar variables sueltas en vez de un solo State
❌ No usar `.copy()`

---

# 🏗️ Estructura profesional (tu caso SAMM)

```plaintext
login/
 ├── LoginScreen.kt      ← UI
 ├── LoginViewModel.kt   ← lógica
 ├── LoginState.kt       ← estado
 ├── LoginEvent.kt       ← (opcional, avanzado)
```

---

# 🚀 Nivel siguiente (lo que harías como senior)

Después evolucionas a:

- `LoginEvent` (MVI)
- `LoginUiEffect` (navegación, toasts)
- UseCase (`LoginUseCase`)
- Repository (API Spring Boot)

---

# 🎯 Resumen brutalmente claro

- **LoginState** → qué se muestra
- **LoginViewModel** → qué pasa
- **LoginScreen** → cómo se ve

---

Si quieres, en el siguiente paso te armo:

👉 La versión **real conectada a tu backend Spring Boot con JWT** (nivel producción, como lo necesitas para tu proyecto grande)
