Como **Android developer en 2026**, si quieres crear una app que permita:

* 📷 Tomar **fotos**
* 📍 Obtener **geolocalización**
* ✍️ Capturar **firma del cliente**

la recomendación no es desarrollar para **una sola versión de Android**, sino definir bien:

* **compileSdk**
* **targetSdk**
* **minSdk**

Esto permite que tu app funcione en muchos dispositivos.

---

# 📱 Versión de Android recomendada en 2026

Hoy lo más recomendable es:

| Configuración  | Recomendación 2026 |
| -------------- | ------------------ |
| **compileSdk** | Android 15         |
| **targetSdk**  | Android 15         |
| **minSdk**     | Android 8 o 9      |

Android 15 corresponde aproximadamente a **API 35**.

### Ejemplo en Gradle

```kotlin
android {
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.servicios"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
}
```

📌 Con esto tu app funcionará aproximadamente en:

* Android 8
* Android 9
* Android 10
* Android 11
* Android 12
* Android 13
* Android 14
* Android 15

Eso cubre **más del 95% de dispositivos**.

---

# 🔎 ¿Qué tanto cambia el código entre versiones?

La buena noticia:

👉 **El 90% del código no cambia.**

Android mantiene compatibilidad.

Los cambios normalmente afectan:

| Área      | Cambios frecuentes           |
| --------- | ---------------------------- |
| Permisos  | Cambian reglas de privacidad |
| Archivos  | Scoped Storage               |
| Cámara    | Nuevas APIs                  |
| Ubicación | Permisos más estrictos       |

---

# 📷 Ejemplo: tomar fotos (no cambia casi nada)

Se usa **CameraX** (mejor práctica moderna).

```kotlin
val imageCapture = ImageCapture.Builder().build()

val photoFile = File(
    externalMediaDirs.first(),
    "foto_${System.currentTimeMillis()}.jpg"
)

val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

imageCapture.takePicture(
    outputOptions,
    ContextCompat.getMainExecutor(this),
    object : ImageCapture.OnImageSavedCallback {

        override fun onImageSaved(output: ImageCapture.OutputFileResults) {
            println("Foto guardada: ${photoFile.absolutePath}")
        }

        override fun onError(exception: ImageCaptureException) {
            println("Error: ${exception.message}")
        }
    }
)
```

Esto funciona **desde Android 8 hasta Android 15**.

---

# 📍 Ejemplo: geolocalización

Se usa **FusedLocationProviderClient**.

```kotlin
val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

fusedLocationClient.lastLocation
    .addOnSuccessListener { location ->
        if (location != null) {
            val lat = location.latitude
            val lon = location.longitude
            println("Lat: $lat Lon: $lon")
        }
    }
```

La única diferencia entre versiones es **cómo pedir permisos**.

---

# ✍️ Firma del cliente

Esto se hace con un **Canvas personalizado**.

Ejemplo simple:

```kotlin
class SignatureView(context: Context) : View(context) {

    private val path = Path()
    private val paint = Paint()

    init {
        paint.color = Color.BLACK
        paint.strokeWidth = 5f
        paint.style = Paint.Style.STROKE
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        when (event.action) {

            MotionEvent.ACTION_DOWN -> {
                path.moveTo(event.x, event.y)
            }

            MotionEvent.ACTION_MOVE -> {
                path.lineTo(event.x, event.y)
            }
        }

        invalidate()
        return true
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawPath(path, paint)
    }
}
```

Luego puedes **guardar la firma como imagen**.

---

# 🏗️ Arquitectura recomendada para tu app

Para una app profesional:

```
presentation
   activities
   viewmodels
domain
   usecases
data
   repository
   datasource
```

Tecnologías recomendadas:

| Tecnología               | Uso                 |
| ------------------------ | ------------------- |
| Kotlin                   | Lenguaje            |
| Jetpack Compose o XML    | UI                  |
| CameraX                  | Fotos               |
| Google Location Services | GPS                 |
| Canvas                   | Firma               |
| Room                     | Base de datos local |
| Retrofit                 | API                 |
| MVVM                     | Arquitectura        |

---

# 📊 ¿Cuándo el código sí cambia mucho?

Cambios grandes ocurrieron en:

| Android    | Cambio                  |
| ---------- | ----------------------- |
| Android 10 | Scoped Storage          |
| Android 12 | Permisos Bluetooth      |
| Android 13 | Permisos de media       |
| Android 14 | Background restrictions |

Pero **si usas librerías modernas (Jetpack)** casi no se nota.

---

# 🚀 Recomendación real para tu caso (app de servicio técnico)

Como tú trabajas con **órdenes de servicio de aire acondicionado**, la app ideal sería:

Pantalla:

1️⃣ Crear orden
2️⃣ Tomar foto del equipo
3️⃣ Guardar geolocalización
4️⃣ Capturar firma del cliente
5️⃣ Sincronizar con API

Tecnologías ideales:

* **Kotlin**
* **MVVM**
* **Room**
* **CameraX**
* **Fused Location**
* **Canvas Signature**
* **Retrofit**

---

✅ Si quieres, puedo mostrarte **un ejemplo completo real de app profesional que incluya:**

* 📷 tomar foto
* 📍 guardar geolocalización
* ✍️ capturar firma
* 💾 guardar todo localmente
* ☁️ enviar a API

(Es el tipo de app que usan los **técnicos de campo**).

Perfecto. Te mostraré **cómo sería la arquitectura real de una app Android profesional en 2026** para tu caso:

* 📷 Tomar **foto del equipo**
* 📍 Guardar **geolocalización**
* ✍️ Capturar **firma del cliente**
* 💾 Guardar localmente
* ☁️ Enviar a una API

Esto es muy parecido a lo que usan **apps de técnicos de campo**.

---

# 🏗️ Arquitectura recomendada (2026)

La mejor práctica actual es **MVVM + Clean Architecture**.

```
com.servicios.tecnicos

data
   local
      database
      dao
      entity
   remote
      api
   repository

domain
   model
   repository
   usecase

presentation
   ui
      activities
      fragments
   viewmodel
   adapter

core
   utils
```

---

# 📁 Estructura del proyecto

```
app
 ├── data
 │     ├── local
 │     │      ├── database
 │     │      │      AppDatabase.kt
 │     │      ├── dao
 │     │      │      OrdenDao.kt
 │     │      └── entity
 │     │             OrdenEntity.kt
 │     │
 │     ├── remote
 │     │      ApiService.kt
 │     │
 │     └── repository
 │            OrdenRepositoryImpl.kt
 │
 ├── domain
 │     ├── model
 │     │      Orden.kt
 │     │
 │     ├── repository
 │     │      OrdenRepository.kt
 │     │
 │     └── usecase
 │            GuardarOrdenUseCase.kt
 │
 ├── presentation
 │     ├── ui
 │     │      MainActivity.kt
 │     │      OrdenFragment.kt
 │     │
 │     └── viewmodel
 │            OrdenViewModel.kt
 │
 └── core
        LocationHelper.kt
        CameraHelper.kt
```

---

# 📦 1. Modelo de la orden

```kotlin
data class Orden(
    val id: Int,
    val cliente: String,
    val latitud: Double,
    val longitud: Double,
    val fotoPath: String,
    val firmaPath: String
)
```

---

# 💾 2. Base de datos local (Room)

Entidad:

```kotlin
@Entity(tableName = "ordenes")
data class OrdenEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val cliente: String,
    val latitud: Double,
    val longitud: Double,
    val fotoPath: String,
    val firmaPath: String
)
```

DAO:

```kotlin
@Dao
interface OrdenDao {

    @Insert
    suspend fun insertar(orden: OrdenEntity)

    @Query("SELECT * FROM ordenes")
    suspend fun obtenerOrdenes(): List<OrdenEntity>
}
```

---

# 🌍 3. Obtener geolocalización

Helper:

```kotlin
class LocationHelper(private val context: Context) {

    private val fusedLocationClient =
        LocationServices.getFusedLocationProviderClient(context)

    fun obtenerUbicacion(callback: (Location?) -> Unit) {

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                callback(location)
            }
    }
}
```

Uso:

```kotlin
locationHelper.obtenerUbicacion { location ->

    val lat = location?.latitude
    val lon = location?.longitude

}
```

---

# 📷 4. Tomar foto con CameraX

Dependencia:

```kotlin
implementation("androidx.camera:camera-camera2:1.3.0")
implementation("androidx.camera:camera-lifecycle:1.3.0")
implementation("androidx.camera:camera-view:1.3.0")
```

Captura:

```kotlin
fun tomarFoto(imageCapture: ImageCapture, file: File) {

    val outputOptions =
        ImageCapture.OutputFileOptions.Builder(file).build()

    imageCapture.takePicture(
        outputOptions,
        ContextCompat.getMainExecutor(context),

        object : ImageCapture.OnImageSavedCallback {

            override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                println("Foto guardada")
            }

            override fun onError(exception: ImageCaptureException) {
                println("Error")
            }
        }
    )
}
```

---

# ✍️ 5. Capturar firma

Vista personalizada:

```kotlin
class SignatureView(context: Context) : View(context) {

    private val path = Path()
    private val paint = Paint()

    init {
        paint.color = Color.BLACK
        paint.strokeWidth = 8f
        paint.style = Paint.Style.STROKE
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        when (event.action) {

            MotionEvent.ACTION_DOWN -> path.moveTo(event.x, event.y)

            MotionEvent.ACTION_MOVE -> path.lineTo(event.x, event.y)
        }

        invalidate()
        return true
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawPath(path, paint)
    }
}
```

Guardar firma:

```kotlin
fun guardarFirma(view: View, file: File) {

    val bitmap = Bitmap.createBitmap(
        view.width,
        view.height,
        Bitmap.Config.ARGB_8888
    )

    val canvas = Canvas(bitmap)
    view.draw(canvas)

    val stream = FileOutputStream(file)
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)

    stream.flush()
    stream.close()
}
```

---

# 🧠 6. ViewModel

```kotlin
class OrdenViewModel(
    private val repository: OrdenRepository
) : ViewModel() {

    fun guardarOrden(orden: Orden) {

        viewModelScope.launch {

            repository.guardarOrden(orden)
        }
    }
}
```

---

# 🌐 7. Enviar a API

API:

```kotlin
interface ApiService {

    @POST("orden")
    suspend fun enviarOrden(
        @Body orden: Orden
    ): Response<Unit>
}
```

---

# 📱 Flujo de la aplicación

```
Crear Orden
     ↓
Tomar Foto
     ↓
Obtener GPS
     ↓
Capturar Firma
     ↓
Guardar local (Room)
     ↓
Enviar a API
```

---

# ⚡ Librerías que usaría en 2026

| Librería        | Uso           |
| --------------- | ------------- |
| CameraX         | Fotos         |
| Google Location | GPS           |
| Room            | Base de datos |
| Retrofit        | API           |
| Coroutines      | asincronía    |
| ViewModel       | lógica        |
| Hilt            | inyección     |

---

# 💡 Algo MUY importante para apps de técnicos

La app debería funcionar **offline primero**.

Arquitectura ideal:

```
APP
 ↓
Room DB
 ↓
WorkManager
 ↓
API
```

Si no hay internet → guarda local.

Cuando vuelve internet → sincroniza.

---

# 🚀 Si quieres, en el siguiente paso puedo enseñarte **un proyecto REAL completo** con:

* 📁 estructura profesional
* 📷 CameraX funcionando
* 📍 GPS funcionando
* ✍️ firma guardada
* 💾 Room
* ☁️ Retrofit

Como lo haría un **Android developer senior en 2026**.

Perfecto. Te mostraré **un proyecto Android realista (simplificado) que un developer profesional haría en 2026** para una app de **orden de servicio con foto, GPS y firma**.
Intentaré que sea **claro y práctico**, pensando también en tu experiencia con **backend y APIs (Spring Boot, .NET, etc.)**.

---

# 📱 Proyecto Android profesional (2026)

Nombre del proyecto:

```
ServiceOrderApp
```

Tecnologías:

* **Kotlin**
* **MVVM**
* **CameraX**
* **Room**
* **Fused Location**
* **Retrofit**
* **Coroutines**
* **WorkManager (sync offline)**

---

# 🏗️ 1. Crear el proyecto en Android Studio

Tipo:

```
Empty Activity
```

Configuración recomendada:

| Configuración | Valor          |
| ------------- | -------------- |
| Language      | Kotlin         |
| Minimum SDK   | 26 (Android 8) |
| Compile SDK   | 35             |
| Target SDK    | 35             |

---

# 📁 2. Estructura profesional

```
com.serviceorder

data
   local
   remote
   repository

domain
   model
   usecase

presentation
   ui
   viewmodel

core
   utils
```

---

# 📦 3. Dependencias principales

En **build.gradle**

```kotlin
dependencies {

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0")

    // Room
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    // CameraX
    implementation("androidx.camera:camera-camera2:1.3.3")
    implementation("androidx.camera:camera-lifecycle:1.3.3")
    implementation("androidx.camera:camera-view:1.3.3")

    // Location
    implementation("com.google.android.gms:play-services-location:21.0.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

}
```

---

# 📦 4. Modelo de la Orden

```
domain/model
```

```kotlin
data class ServiceOrder(

    val id: Int? = null,
    val clientName: String,
    val latitude: Double,
    val longitude: Double,
    val photoPath: String,
    val signaturePath: String
)
```

---

# 💾 5. Base de datos Room

Entidad:

```kotlin
@Entity(tableName = "service_orders")
data class ServiceOrderEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val clientName: String,
    val latitude: Double,
    val longitude: Double,
    val photoPath: String,
    val signaturePath: String
)
```

DAO:

```kotlin
@Dao
interface ServiceOrderDao {

    @Insert
    suspend fun insert(order: ServiceOrderEntity)

    @Query("SELECT * FROM service_orders")
    suspend fun getAll(): List<ServiceOrderEntity>
}
```

Database:

```kotlin
@Database(
    entities = [ServiceOrderEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun orderDao(): ServiceOrderDao
}
```

---

# 🌍 6. Obtener geolocalización

Clase helper:

```
core/utils
```

```kotlin
class LocationHelper(context: Context) {

    private val client =
        LocationServices.getFusedLocationProviderClient(context)

    fun getLocation(callback: (Location?) -> Unit) {

        client.lastLocation
            .addOnSuccessListener {
                callback(it)
            }
    }
}
```

Uso:

```kotlin
locationHelper.getLocation {

    val lat = it?.latitude
    val lon = it?.longitude
}
```

---

# 📷 7. Tomar foto con CameraX

En la Activity:

```kotlin
private lateinit var imageCapture: ImageCapture
```

Inicializar cámara:

```kotlin
private fun startCamera() {

    val cameraProviderFuture =
        ProcessCameraProvider.getInstance(this)

    cameraProviderFuture.addListener({

        val cameraProvider = cameraProviderFuture.get()

        val preview = Preview.Builder().build()

        imageCapture = ImageCapture.Builder().build()

        val cameraSelector =
            CameraSelector.DEFAULT_BACK_CAMERA

        cameraProvider.bindToLifecycle(
            this,
            cameraSelector,
            preview,
            imageCapture
        )

    }, ContextCompat.getMainExecutor(this))
}
```

Capturar foto:

```kotlin
fun takePhoto() {

    val photoFile = File(
        externalMediaDirs.first(),
        "photo_${System.currentTimeMillis()}.jpg"
    )

    val outputOptions =
        ImageCapture.OutputFileOptions.Builder(photoFile).build()

    imageCapture.takePicture(
        outputOptions,
        ContextCompat.getMainExecutor(this),

        object : ImageCapture.OnImageSavedCallback {

            override fun onImageSaved(output: ImageCapture.OutputFileResults) {

                println("Foto guardada")
            }

            override fun onError(exception: ImageCaptureException) {
            }
        }
    )
}
```

---

# ✍️ 8. Capturar firma

Crear un **Custom View**.

```kotlin
class SignatureView(context: Context) : View(context) {

    private val path = Path()
    private val paint = Paint()

    init {

        paint.color = Color.BLACK
        paint.strokeWidth = 6f
        paint.style = Paint.Style.STROKE
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        when (event.action) {

            MotionEvent.ACTION_DOWN ->
                path.moveTo(event.x, event.y)

            MotionEvent.ACTION_MOVE ->
                path.lineTo(event.x, event.y)
        }

        invalidate()

        return true
    }

    override fun onDraw(canvas: Canvas) {

        canvas.drawPath(path, paint)
    }
}
```

Guardar firma como imagen:

```kotlin
fun saveSignature(view: View, file: File) {

    val bitmap =
        Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)

    val canvas = Canvas(bitmap)

    view.draw(canvas)

    val stream = FileOutputStream(file)

    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)

    stream.close()
}
```

---

# 🌐 9. API REST

Retrofit:

```kotlin
interface ApiService {

    @POST("service-order")
    suspend fun sendOrder(
        @Body order: ServiceOrder
    ): Response<Unit>
}
```

---

# 🧠 10. ViewModel

```kotlin
class OrderViewModel(
    private val repository: OrderRepository
) : ViewModel() {

    fun saveOrder(order: ServiceOrder) {

        viewModelScope.launch {

            repository.save(order)
        }
    }
}
```

---

# 🔄 Flujo real de la app

```
Crear Orden
     ↓
Tomar Foto
     ↓
Capturar Firma
     ↓
Obtener GPS
     ↓
Guardar en Room
     ↓
Sincronizar con API
```

---

# 📶 Mejor práctica en apps de técnicos

Las apps de campo **siempre funcionan offline**.

Arquitectura ideal:

```
APP
 ↓
ROOM DATABASE
 ↓
WORKMANAGER
 ↓
API
```

Si no hay internet:

```
guardar local
```

Cuando vuelva internet:

```
sincronizar automáticamente
```

---

# 🚀 Algo MUY importante que muchos principiantes no saben

Para apps como la tuya también deberías guardar:

* 📷 **foto**
* ✍️ **firma**
* 📍 **latitud**
* 📍 **longitud**
* 🕒 **fecha**
* 📱 **IMEI o device ID**
* 👤 **usuario técnico**

Esto sirve para **auditoría y legalidad**.

---

# 🎯 Si quieres, en el siguiente paso puedo enseñarte algo **MUY valioso**:

## 🔥 Cómo se vería **la pantalla real de esta app**

Con:

* formulario
* botón tomar foto
* mapa
* firma
* guardar orden

Tal como lo hacen apps tipo:

* técnicos de gas
* técnicos de aire acondicionado
* instaladores de fibra
* empresas de mantenimiento.

Y además te mostraré **la UI completa en Android moderna (2026)**.

