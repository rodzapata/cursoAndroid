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
