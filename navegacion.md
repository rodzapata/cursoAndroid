Perfecto 🔥 vamos a construir una **navegación CRUD completa (nivel empresa)** usando **Jetpack Compose**.

👉 Tendrás:

* Lista (READ)
* Detalle (READ 1)
* Crear (CREATE)
* Editar (UPDATE)
* (Delete opcional)

---

# 🧩 🏗️ Estructura general

```text
MainActivity
   ↓
Navigation
   ↓
Screens:
   - ListScreen
   - DetailScreen
   - FormScreen (Create / Edit)
```

---

# 🧠 1. Modelo (tu entidad)

```kotlin
data class ServiceOrder(
    val id: Int,
    val customer: String,
    val equipment: String,
    val status: String
)
```

---

# 🧭 2. Navegación completa

```kotlin
@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = "list") {

        // 📋 LISTA
        composable("list") {
            ListScreen(
                onDetail = { id ->
                    navController.navigate("detail/$id")
                },
                onCreate = {
                    navController.navigate("form")
                }
            )
        }

        // 🔍 DETALLE
        composable("detail/{id}") { backStack ->
            val id = backStack.arguments?.getString("id")

            DetailScreen(
                id = id,
                onEdit = {
                    navController.navigate("form/$id")
                }
            )
        }

        // 📝 FORM (CREATE)
        composable("form") {
            FormScreen(
                onSave = {
                    navController.popBackStack()
                }
            )
        }

        // ✏️ FORM (EDIT)
        composable("form/{id}") { backStack ->
            val id = backStack.arguments?.getString("id")

            FormScreen(
                id = id,
                onSave = {
                    navController.popBackStack()
                }
            )
        }
    }
}
```

---

# 📋 3. ListScreen (READ)

```kotlin
@Composable
fun ListScreen(
    onDetail: (Int) -> Unit,
    onCreate: () -> Unit
) {

    val orders = listOf(
        ServiceOrder(1, "Carlos", "Aire 12000BTU", "Pendiente"),
        ServiceOrder(2, "Ana", "Split 18000BTU", "Completado")
    )

    Column {

        Button(onClick = onCreate) {
            Text("Crear Orden")
        }

        LazyColumn {
            items(orders) { order ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { onDetail(order.id) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(order.customer)
                        Text(order.status)
                    }
                }
            }
        }
    }
}
```

---

# 🔍 4. DetailScreen (READ ONE + DELETE)

```kotlin
@Composable
fun DetailScreen(
    id: String?,
    onEdit: () -> Unit
) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Detalle de orden: $id")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onEdit) {
            Text("Editar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            // DELETE lógica aquí
        }) {
            Text("Eliminar")
        }
    }
}
```

---

# 📝 5. FormScreen (CREATE + UPDATE)

```kotlin
@Composable
fun FormScreen(
    id: String? = null,
    onSave: () -> Unit
) {

    var customer by remember { mutableStateOf("") }
    var equipment by remember { mutableStateOf("") }

    val isEdit = id != null

    Column(modifier = Modifier.padding(16.dp)) {

        Text(if (isEdit) "Editar Orden" else "Crear Orden")

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = customer,
            onValueChange = { customer = it },
            label = { Text("Cliente") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = equipment,
            onValueChange = { equipment = it },
            label = { Text("Equipo") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (isEdit) {
                // UPDATE
            } else {
                // CREATE
            }
            onSave()
        }) {
            Text("Guardar")
        }
    }
}
```

---

# 🔄 Flujo completo

```text
LIST → DETAIL → EDIT
  ↓
CREATE
```

---

# 🧠 Nivel PRO (lo que falta para producción)

Esto que hicimos es la base. En empresa debes agregar:

---

## 🔥 1. ViewModel

* Manejar estado
* Conectar API (.NET / Spring Boot 👀)

---

## 🔥 2. Repository

```text
UI → ViewModel → Repository → API
```

---

## 🔥 3. Manejo de estado

* Loading
* Error
* Success

---

## 🔥 4. Validaciones

* Campos obligatorios
* Mensajes de error

---

# ⚠️ Errores comunes

❌ Navegar sin pasar ID
❌ Meter lógica en UI
❌ No usar ViewModel
❌ No manejar estado

---

# 🚀 Versión mental (clave)

👉 En moderno:

```text
Navigation Compose = reemplazo de Fragment
```

---

# 🎯 Conclusión

✔ Ya tienes un CRUD completo
✔ Usando navegación moderna
✔ Listo para conectar backend

---

# 🚀 Siguiente paso (MUY recomendado)

Dado tu perfil backend 🔥:

👉 Te enseño a conectar esto con API real usando:

* Retrofit
* ViewModel
* DTOs
* JWT

Solo dime:
👉 *“quiero conectar CRUD a API real”*


Sí—en **2026 con Jetpack Compose**, la navegación **sí se maneja en un paquete (o módulo) independiente**, pero con un enfoque más **modular por features + separación clara de responsabilidades**. Ya no es solo “un paquete navigation”, sino una arquitectura pensada para escalar (muy alineada con Clean Architecture + MVVM).

Te explico cómo se hace hoy de forma profesional 👇

---

# 🧱 Estructura recomendada (2026)

## 🔹 1. Enfoque moderno: **feature-based + navigation centralizada**

```plaintext
com.tuapp
│
├── core/                  # reutilizable
│   ├── ui/
│   ├── designsystem/
│   ├── utils/
│
├── navigation/            # 🔥 navegación global
│   ├── AppNavHost.kt
│   ├── Routes.kt
│   ├── Navigator.kt (opcional)
│
├── features/
│   ├── auth/
│   │   ├── ui/
│   │   │   ├── LoginScreen.kt
│   │   │   ├── RegisterScreen.kt
│   │   ├── viewmodel/
│   │   ├── navigation/   # 👈 navegación interna del feature
│   │   │   ├── AuthNavGraph.kt
│   │
│   ├── home/
│   │   ├── ui/
│   │   ├── viewmodel/
│   │   ├── navigation/
│   │       ├── HomeNavGraph.kt
│
├── MainActivity.kt
```

---

# 🧭 2. ¿Por qué separar `navigation/`?

Porque en apps reales:

* Evitas dependencias circulares
* Puedes escalar a múltiples módulos
* Facilita testing
* Permite navegación desacoplada (clave en proyectos grandes)

---

# 🔥 3. Conceptos clave modernos

## ✅ A. `Routes.kt` (centralizado)

```kotlin
sealed class Routes(val route: String) {
    object Login : Routes("login")
    object Home : Routes("home")
    object Detail : Routes("detail/{id}") {
        fun createRoute(id: Int) = "detail/$id"
    }
}
```

✔️ Evita strings hardcodeados
✔️ Mejores prácticas actuales

---

## ✅ B. `AppNavHost.kt` (orquestador global)

```kotlin
@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        authNavGraph(navController)
        homeNavGraph(navController)
    }
}
```

👉 Aquí solo “conectas” features

---

## ✅ C. Navegación por feature (muy importante)

### `AuthNavGraph.kt`

```kotlin
fun NavGraphBuilder.authNavGraph(navController: NavController) {
    composable(Routes.Login.route) {
        LoginScreen(
            onLoginSuccess = {
                navController.navigate(Routes.Home.route) {
                    popUpTo(Routes.Login.route) { inclusive = true }
                }
            }
        )
    }
}
```

✔️ Cada feature maneja su navegación
✔️ Súper escalable

---

# 🧠 4. Patrón moderno (clave en 2026)

👉 Se usa mucho esto:

### 🔹 Navigation + State Hoisting

```kotlin
LoginScreen(
    onLoginSuccess = { /* navegación afuera */ }
)
```

💡 La UI **NO navega directamente**
💡 Solo emite eventos → la navegación se maneja arriba

---

# 🚀 5. Nivel PRO (lo que hacen apps grandes)

Si quieres arquitectura profesional real:

## 🔥 Navigator pattern (opcional pero potente)

```kotlin
interface Navigator {
    fun navigateTo(route: String)
    fun goBack()
}
```

Implementación:

```kotlin
class AppNavigator(
    private val navController: NavHostController
) : Navigator {

    override fun navigateTo(route: String) {
        navController.navigate(route)
    }

    override fun goBack() {
        navController.popBackStack()
    }
}
```

✔️ Desacoplas ViewModel de NavController
✔️ Testeable

---

# ⚠️ Cosas que ya NO se recomiendan

❌ Navegar directamente desde ViewModel con NavController
❌ Tener toda la navegación en un solo archivo gigante
❌ Usar strings sueltos tipo `"home_screen"`
❌ Mezclar UI + navegación en el mismo composable

---

# 🧩 6. Resumen claro

✔️ Sí, se usa paquete `navigation/`
✔️ Pero ahora:

* 🔹 Navegación global → `navigation/`
* 🔹 Navegación por feature → `feature/navigation/`
* 🔹 Rutas centralizadas
* 🔹 UI desacoplada de navegación

---

# 🎯 Recomendación para ti (muy importante)

Como estás construyendo una app tipo **mantenimiento de aires (SAMM)**:

👉 Usa desde el inicio:

* Feature: `auth`, `orders`, `clients`, `equipment`
* Cada uno con su `NavGraph`
* Un `AppNavHost` central

---

Si quieres, en el siguiente paso te puedo armar 🔥:

👉 Un **CRUD completo con navegación real (Login → Home → Orders → Detail → Create)**
👉 Con arquitectura limpia + ViewModel + estado + navegación moderna

Solo dime: **“quiero CRUD con navegación completa”** 🚀

Perfecto—vamos a construir un **CRUD completo con navegación moderna en Jetpack Compose (2026)**, usando:

* ✅ Arquitectura por **features**
* ✅ **Navigation desacoplada**
* ✅ **State + ViewModel**
* ✅ Flujo real tipo: **Login → Home → Orders (CRUD)**

Te lo explico paso a paso como en un proyecto profesional 👇

---

# 🧱 1. Estructura del proyecto

```plaintext
com.tuapp
│
├── navigation/
│   ├── AppNavHost.kt
│   ├── Routes.kt
│
├── features/
│   ├── auth/
│   │   ├── ui/LoginScreen.kt
│   │   ├── viewmodel/LoginViewModel.kt
│   │   ├── navigation/AuthNavGraph.kt
│
│   ├── orders/
│       ├── ui/
│       │   ├── OrderListScreen.kt
│       │   ├── OrderFormScreen.kt
│       │   ├── OrderDetailScreen.kt
│       ├── viewmodel/
│       │   ├── OrderViewModel.kt
│       ├── navigation/OrdersNavGraph.kt
│
├── MainActivity.kt
```

---

# 🧭 2. Rutas (Routes.kt)

```kotlin
sealed class Routes(val route: String) {
    object Login : Routes("login")
    object Home : Routes("home")

    object Orders : Routes("orders")
    object OrderForm : Routes("order_form")
    object OrderDetail : Routes("order_detail/{id}") {
        fun create(id: Int) = "order_detail/$id"
    }
}
```

---

# 🧭 3. NavHost principal

## AppNavHost.kt

```kotlin
@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        authNavGraph(navController)
        ordersNavGraph(navController)
    }
}
```

---

# 🔐 4. Feature AUTH (Login)

## AuthNavGraph.kt

```kotlin
fun NavGraphBuilder.authNavGraph(navController: NavController) {

    composable(Routes.Login.route) {
        LoginScreen(
            onLoginSuccess = {
                navController.navigate(Routes.Orders.route) {
                    popUpTo(Routes.Login.route) { inclusive = true }
                }
            }
        )
    }
}
```

---

## LoginScreen.kt

```kotlin
@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = { onLoginSuccess() }) {
            Text("Login")
        }
    }
}
```

---

# 📦 5. Feature ORDERS (CRUD completo)

---

## OrdersNavGraph.kt

```kotlin
fun NavGraphBuilder.ordersNavGraph(navController: NavController) {

    composable(Routes.Orders.route) {
        OrderListScreen(
            onCreate = {
                navController.navigate(Routes.OrderForm.route)
            },
            onDetail = { id ->
                navController.navigate(Routes.OrderDetail.create(id))
            }
        )
    }

    composable(Routes.OrderForm.route) {
        OrderFormScreen(
            onSave = {
                navController.popBackStack()
            }
        )
    }

    composable(Routes.OrderDetail.route) { backStack ->
        val id = backStack.arguments?.getString("id")?.toInt() ?: 0

        OrderDetailScreen(
            id = id,
            onDelete = {
                navController.popBackStack()
            }
        )
    }
}
```

---

# 🧠 6. ViewModel (lógica CRUD)

## OrderViewModel.kt

```kotlin
class OrderViewModel : ViewModel() {

    private val _orders = mutableStateListOf<String>()
    val orders: List<String> = _orders

    fun addOrder(name: String) {
        _orders.add(name)
    }

    fun deleteOrder(index: Int) {
        _orders.removeAt(index)
    }
}
```

---

# 📋 7. Pantalla LIST (READ)

## OrderListScreen.kt

```kotlin
@Composable
fun OrderListScreen(
    onCreate: () -> Unit,
    onDetail: (Int) -> Unit,
    viewModel: OrderViewModel = viewModel()
) {

    Column {

        Button(onClick = onCreate) {
            Text("Nueva Orden")
        }

        LazyColumn {
            itemsIndexed(viewModel.orders) { index, order ->
                Text(
                    text = order,
                    modifier = Modifier.clickable {
                        onDetail(index)
                    }
                )
            }
        }
    }
}
```

---

# ➕ 8. Pantalla CREATE

## OrderFormScreen.kt

```kotlin
@Composable
fun OrderFormScreen(
    onSave: () -> Unit,
    viewModel: OrderViewModel = viewModel()
) {

    var text by remember { mutableStateOf("") }

    Column {

        TextField(
            value = text,
            onValueChange = { text = it }
        )

        Button(onClick = {
            viewModel.addOrder(text)
            onSave()
        }) {
            Text("Guardar")
        }
    }
}
```

---

# 🔍 9. Pantalla DETAIL + DELETE

## OrderDetailScreen.kt

```kotlin
@Composable
fun OrderDetailScreen(
    id: Int,
    onDelete: () -> Unit,
    viewModel: OrderViewModel = viewModel()
) {

    val order = viewModel.orders.getOrNull(id)

    Column {

        Text("Detalle: $order")

        Button(onClick = {
            viewModel.deleteOrder(id)
            onDelete()
        }) {
            Text("Eliminar")
        }
    }
}
```

---

# 🚀 10. MainActivity

```kotlin
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            AppNavHost(navController)
        }
    }
}
```

---

# 🔥 Flujo completo

1. Login
2. Lista de órdenes
3. Crear orden
4. Ver detalle
5. Eliminar

✔️ Navegación desacoplada
✔️ Feature-based
✔️ CRUD funcional

---

# 🧠 11. Nivel PRO (lo que sigue)

Para llevar esto a nivel real (tipo empresa):

* 🔹 Reemplazar lista en memoria → **Repository + Room / API REST**
* 🔹 Usar **StateFlow en vez de mutableStateList**
* 🔹 Validaciones en formulario
* 🔹 Manejo de errores
* 🔹 DTOs + UseCases (Clean Architecture)

---

# 🎯 Siguiente paso (te lo recomiendo)

Puedo ayudarte a convertir esto en algo **100% real profesional**:

👉 Conectar este CRUD a tu backend en **Spring Boot o .NET**
👉 Persistencia real (PostgreSQL o SQL Server)
👉 Autenticación JWT
👉 Arquitectura limpia completa

Solo dime:

👉 **“quiero versión profesional con API real”** 🚀
