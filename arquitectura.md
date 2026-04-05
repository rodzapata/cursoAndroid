Perfecto 👍. Vamos a crear un **mini sistema de órdenes de servicio en Kotlin**, algo muy parecido a lo que podrías usar en una **app Android o un backend**. Esto te ayudará a practicar **data class, clases, listas, `when` y arquitectura simple**.

Imaginemos un **sistema para mantenimiento de aire acondicionado** (muy parecido a tu proyecto de órdenes de servicio).

---

# 1️⃣ Modelo de datos (`data class`)

Primero definimos las **entidades**.

```kotlin
data class Cliente(
    val id: Int,
    val nombre: String
)

data class Equipo(
    val id: Int,
    val tipo: String,
    val marca: String
)

data class OrdenServicio(
    val id: Int,
    val cliente: Cliente,
    val equipo: Equipo,
    val estado: Int
)
```

---

# 2️⃣ Clase Repository (simula base de datos)

Aquí normalmente se conectaría a **SQLite, API o base de datos**.

```kotlin
class OrdenRepository {

    fun obtenerOrdenes(): List<OrdenServicio> {

        val cliente1 = Cliente(1, "Empresa ABC")
        val cliente2 = Cliente(2, "Restaurante Central")

        val equipo1 = Equipo(1, "Aire acondicionado", "LG")
        val equipo2 = Equipo(2, "Refrigerador", "Samsung")

        return listOf(
            OrdenServicio(1, cliente1, equipo1, 1),
            OrdenServicio(2, cliente2, equipo2, 3)
        )
    }

}
```

---

# 3️⃣ Clase Service (lógica del sistema)

Aquí aplicamos **lógica de negocio**.

```kotlin
class OrdenService(private val repository: OrdenRepository) {

    fun listarOrdenes() {

        val ordenes = repository.obtenerOrdenes()

        ordenes.forEach {

            println("Orden: ${it.id}")
            println("Cliente: ${it.cliente.nombre}")
            println("Equipo: ${it.equipo.tipo} - ${it.equipo.marca}")
            println("Estado: ${obtenerEstado(it.estado)}")
            println("---------------------")

        }

    }

    fun obtenerEstado(estado: Int): String {

        return when (estado) {
            1 -> "Creada"
            2 -> "Asignada"
            3 -> "En proceso"
            4 -> "Finalizada"
            else -> "Desconocido"
        }

    }

}
```

Aquí usamos **`when` para traducir estados**, algo muy común en apps.

---

# 4️⃣ Programa principal

```kotlin
fun main() {

    val repository = OrdenRepository()

    val service = OrdenService(repository)

    service.listarOrdenes()

}
```

---

# 5️⃣ Resultado en consola

```text
Orden: 1
Cliente: Empresa ABC
Equipo: Aire acondicionado - LG
Estado: Creada
---------------------

Orden: 2
Cliente: Restaurante Central
Equipo: Refrigerador - Samsung
Estado: En proceso
---------------------
```

---

# 6️⃣ Arquitectura que estás usando

Esto es muy parecido a lo que se usa en **Android o backend**:

```
model
 ├─ Cliente
 ├─ Equipo
 └─ OrdenServicio

repository
 └─ OrdenRepository

service
 └─ OrdenService

main
```

En Android sería algo así:

```
Activity / UI
     ↓
ViewModel
     ↓
Repository
     ↓
API / Database
```

---

# 🚀 Mejora profesional que usan apps modernas

En lugar de `estado: Int`, se usa un **`enum class`**, que es más seguro.

```kotlin
enum class EstadoOrden {
    CREADA,
    ASIGNADA,
    EN_PROCESO,
    FINALIZADA
}
```

Luego:

```kotlin
data class OrdenServicio(
    val id: Int,
    val cliente: Cliente,
    val equipo: Equipo,
    val estado: EstadoOrden
)
```

Esto **evita errores de números mágicos**.

---

💡 Si quieres, en el siguiente paso puedo mostrarte algo **MUY útil para dominar Kotlin y Android**:

1️⃣ **`sealed class` para manejar estados de UI** (usado en Android moderno)
2️⃣ **`object` y `companion object`**
3️⃣ **`extension functions`** (una de las cosas más poderosas de Kotlin)
4️⃣ **Un mini proyecto Kotlin más grande (tipo app real con 6 clases)**.

# 🏗️ Estructura recomendada para un proyecto profesional y escalable

Perfecto, vamos a armarte una **estructura profesional (nivel empresa)** para tu app de mantenimiento de aires tipo SAMM usando:

- Jetpack Compose
- MVVM + Clean Architecture
- Hilt (inyección de dependencias)

---

# 🏗️ Estructura de carpetas (2026 - recomendada)

```bash
com.tuempresa.sammapp
│
├── core/
│   ├── ui/
│   ├── navigation/
│   ├── utils/
│   └── common/
│
├── data/
│   ├── remote/
│   ├── local/
│   ├── repository/
│   └── mapper/
│
├── domain/
│   ├── model/
│   ├── repository/
│   └── usecase/
│
├── feature/
│   ├── login/
│   │   ├── ui/
│   │   ├── viewmodel/
│   │   └── state/
│   │
│   ├── orders/
│   ├── equipment/
│   └── customer/
│
└── di/
```

---

# 🔐 Ejemplo completo: LOGIN (bien hecho)

## 📁 feature/login/ui/LoginScreen.kt

```kotlin
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.collectAsState()

    Column {
        OutlinedTextField(
            value = state.value.username,
            onValueChange = { viewModel.onEvent(LoginEvent.OnUsernameChange(it)) },
            label = { Text("Usuario") }
        )

        OutlinedTextField(
            value = state.value.password,
            onValueChange = { viewModel.onEvent(LoginEvent.OnPasswordChange(it)) },
            label = { Text("Contraseña") }
        )

        Button(onClick = { viewModel.onEvent(LoginEvent.OnLoginClick) }) {
            Text("Ingresar")
        }
    }
}
```

---

## 📁 feature/login/viewmodel/LoginViewModel.kt

```kotlin
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnUsernameChange -> {
                _uiState.value = _uiState.value.copy(username = event.username)
            }

            is LoginEvent.OnPasswordChange -> {
                _uiState.value = _uiState.value.copy(password = event.password)
            }

            LoginEvent.OnLoginClick -> login()
        }
    }

    private fun login() {
        viewModelScope.launch {
            val result = loginUseCase(
                _uiState.value.username,
                _uiState.value.password
            )

            // manejar resultado
        }
    }
}
```

---

## 📁 feature/login/state/LoginUiState.kt

```kotlin
data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false
)
```

---

## 📁 feature/login/state/LoginEvent.kt

```kotlin
sealed class LoginEvent {
    data class OnUsernameChange(val username: String) : LoginEvent()
    data class OnPasswordChange(val password: String) : LoginEvent()
    object OnLoginClick : LoginEvent()
}
```

---

# 🧠 DOMAIN (reglas de negocio)

## 📁 domain/usecase/LoginUseCase.kt

```kotlin
class LoginUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(user: String, pass: String): Boolean {
        return repository.login(user, pass)
    }
}
```

---

## 📁 domain/repository/AuthRepository.kt

```kotlin
interface AuthRepository {
    suspend fun login(user: String, pass: String): Boolean
}
```

---

# 💾 DATA (implementación real)

## 📁 data/repository/AuthRepositoryImpl.kt

```kotlin
class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi
) : AuthRepository {

    override suspend fun login(user: String, pass: String): Boolean {
        return api.login(user, pass)
    }
}
```

---

# 💉 DI (Hilt)

```kotlin
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAuthRepository(
        api: AuthApi
    ): AuthRepository {
        return AuthRepositoryImpl(api)
    }
}
```

---

# 🚀 Navegación (importante)

```kotlin
NavHost(navController, startDestination = "login") {
    composable("login") { LoginScreen() }
    composable("home") { HomeScreen() }
}
```

---

# 🧠 Reglas de oro (nivel senior)

### ✅ Naming

- `LoginScreen` → UI
- `LoginViewModel` → lógica UI
- `LoginUseCase` → negocio
- `AuthRepository` → contrato

---

### ✅ Separación clara

- UI NO sabe de Retrofit, SQL, etc.
- Domain NO depende de Android
- Data implementa todo

---

### ❌ Error común (evítalo)

No hagas esto:

```kotlin
// ❌ MAL
LoginScreen -> llama directamente a API
```

---

# 🔥 Bonus (pro nivel real)

Para tu app tipo SAMM, luego puedes agregar:

- `CreateOrderScreen`
- `OrderDetailScreen`
- `EquipmentScreen`
- `TechnicianScreen`

---

# 🎯 Conclusión

👉 Usa siempre:

- `LoginScreen` (NO `Login`, NO `LoginView`)
- Arquitectura por features
- Eventos + State + ViewModel

---

Si quieres, en el siguiente paso te armo:

👉 🔥 **La navegación completa tipo app real (login → dashboard → órdenes)**
👉 Con menú lateral tipo acordeón (como quieres en React pero en Android)

Solo dime: **“quiero navegación completa”** 👀

Excelente pregunta — aquí es donde muchos proyectos se vuelven desordenados si no entiendes bien el **core** 👇

---

# 🧠 ¿Qué es `core`?

En una app con Jetpack Compose + Clean Architecture:

> 👉 `core` = **todo lo reutilizable y global de la app**

📌 No pertenece a una feature específica (login, orders, etc.)

---

# 🧩 ¿Qué cosas van en `core`?

## 1. 🎨 UI reutilizable (`core/ui/`)

Componentes que usas en TODAS las pantallas

### ✅ Ejemplo: Botón reutilizable

```kotlin
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit
) {
    Button(onClick = onClick) {
        Text(text)
    }
}
```

👉 Lo usas en:

- Login
- Crear orden
- Editar cliente

---

### ✅ Ejemplo: Loader global

```kotlin
@Composable
fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
```

---

## 2. 🧭 Navegación (`core/navigation/`)

Centralizas rutas

```kotlin
object Routes {
    const val LOGIN = "login"
    const val HOME = "home"
    const val ORDERS = "orders"
}
```

👉 Evitas strings mágicos 👌

---

## 3. 🛠️ Utilidades (`core/utils/`)

Funciones helper

### ✅ Ejemplo: Validaciones

```kotlin
fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
```

---

### ✅ Ejemplo: Formateo de fechas

```kotlin
fun formatDate(timestamp: Long): String {
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return sdf.format(Date(timestamp))
}
```

---

## 4. 📦 Clases comunes (`core/common/`)

### ✅ Ejemplo: manejo de estados

```kotlin
sealed class Resource<T> {
    class Loading<T> : Resource<T>()
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(val message: String) : Resource<T>()
}
```

👉 Esto lo usas en TODO el proyecto

---

## 5. 🎯 BaseScreen (nivel pro)

Aquí es donde puedes crear tu propio `Screen` 👀

```kotlin
@Composable
fun BaseScreen(
    isLoading: Boolean,
    content: @Composable () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {

        content()

        if (isLoading) {
            LoadingView()
        }
    }
}
```

👉 Ahora sí puedes hacer:

```kotlin
@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel()) {

    val state = viewModel.uiState.collectAsState()

    BaseScreen(isLoading = state.value.isLoading) {

        Column {
            Text("Login")
        }
    }
}
```

🔥 Esto es EXACTAMENTE lo que viste como `Screen` en ejemplos

---

## 6. 🌐 Manejo global de errores

```kotlin
fun mapError(e: Exception): String {
    return when (e) {
        is IOException -> "Sin conexión"
        else -> "Error inesperado"
    }
}
```

---

# 🧠 Regla de oro

👉 Si te haces esta pregunta:

> "¿Esto lo voy a usar en más de una pantalla?"

✔️ Sí → va en `core`
❌ No → va en `feature`

---

# ❌ Errores comunes

🚫 Meter ViewModels en core
🚫 Meter lógica de negocio en core
🚫 Meter APIs en core

👉 Eso va en:

- `feature`
- `domain`
- `data`

---

# 🚀 Ejemplo real aplicado a tu app SAMM

En tu caso podrías tener:

### core/ui

- `PrimaryButton`
- `TextFieldCustom`
- `LoadingView`

### core/utils

- `formatDate()`
- `validateForm()`

### core/navigation

- `Routes`

### core/common

- `Resource`
- `UiEvent`

---

# 🎯 Conclusión

👉 `core` es tu **caja de herramientas global**

- Reutilizable
- Independiente de features
- Limpio

---

Si quieres, en el siguiente paso te hago algo más avanzado 🔥

👉 Cómo construir un **BaseScreen profesional con manejo de errores, loading y snackbar global (como app real de empresa)**
