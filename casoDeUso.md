Perfecto 🔥 vamos a armar algo **real, moderno y profesional (nivel 2026)** usando:

* Clean Architecture
* MVVM
* Hilt
* Room
* Retrofit
* Backend en Spring Boot

Todo enfocado a algo parecido a tu proyecto de **facturación / usuarios**.

---

# 🏗️ 1. Estructura del proyecto (IMPORTANTE)

```text
data/
   local/        (Room)
   remote/       (Retrofit)
   repository/

domain/
   model/
   repository/
   usecase/

presentation/
   viewmodel/
   ui/

di/              (Hilt)
```

---

# 🧠 2. MODELOS (3 capas → regla PRO)

## 🔵 Domain (lo que usa la app)

```kotlin
data class User(
    val id: Long,
    val name: String
)
```

---

## 🟢 DTO (lo que viene del backend)

```kotlin
data class UserDto(
    val id: Long,
    val name: String
)
```

---

## 🟡 Entity (Room)

```kotlin
@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Long,
    val name: String
)
```

---

## 🔄 Mapper (CLAVE en Clean Architecture)

```kotlin
fun UserDto.toEntity() = UserEntity(id, name)

fun UserEntity.toDomain() = User(id, name)
```

---

# 🌐 3. Retrofit (API - Spring Boot)

```kotlin
interface UserApi {

    @GET("users")
    suspend fun getUsers(): List<UserDto>
}
```

---

# 💾 4. Room (local DB)

## DAO

```kotlin
@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getUsers(): Flow<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<UserEntity>)
}
```

---

## Database

```kotlin
@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
```

---

# 🧩 5. Repository (el corazón 🔥)

```kotlin
class UserRepositoryImpl(
    private val api: UserApi,
    private val dao: UserDao
) : UserRepository {

    override fun getUsers(): Flow<List<User>> {

        // 🔥 1. datos locales (UI inmediata)
        val local = dao.getUsers()

        // 🔥 2. sincronización en background
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val remote = api.getUsers()
                dao.insertAll(remote.map { it.toEntity() })
            } catch (e: Exception) {
                // manejar error (offline)
            }
        }

        return local.map { list -> list.map { it.toDomain() } }
    }
}
```

---

# 📦 6. Use Case (Android)

```kotlin
class GetUsersUseCase(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<List<User>> {
        return repository.getUsers()
    }
}
```

👉 Este es el **caso de uso de Android (orquestación)**

---

# 🎯 7. ViewModel (MVVM)

```kotlin
@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    val users = getUsersUseCase()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )
}
```

---

# 🎨 8. UI (Jetpack Compose)

```kotlin
@Composable
fun UserScreen(viewModel: UserViewModel = hiltViewModel()) {

    val users by viewModel.users.collectAsState()

    LazyColumn {
        items(users) { user ->
            Text(text = user.name)
        }
    }
}
```

---

# 🪛 9. Hilt (inyección de dependencias)

```kotlin
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApi(): UserApi {
        return Retrofit.Builder()
            .baseUrl("https://tu-api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_db"
        ).build()
    }

    @Provides
    fun provideDao(db: AppDatabase) = db.userDao()

    @Provides
    fun provideRepository(
        api: UserApi,
        dao: UserDao
    ): UserRepository {
        return UserRepositoryImpl(api, dao)
    }
}
```

---

# 🔥 Flujo completo (esto es lo que debes entender)

```text
UI (Compose)
   ↓
ViewModel
   ↓
UseCase
   ↓
Repository
   ↓           ↓
Room        Retrofit (Spring Boot)
```

---

# 🚀 Lo que acabas de aprender (nivel senior)

✔ No duplicas lógica → solo capas
✔ Room = cache + offline
✔ UseCase en Android = orquestador
✔ Backend = reglas de negocio
✔ Flow = UI reactiva automática

---

# 💡 Siguiente nivel (te lo recomiendo 👀)

Podemos llevar esto a tu proyecto real de facturación:

* 🔐 Login con JWT (Spring Boot + Android)
* 📄 Facturas con detalle (maestro-detalle)
* 🔄 Sincronización offline
* 📊 Manejo de estados (Loading, Error, Success)
* 🧱 MVI vs MVVM en Compose

---

Si quieres, en el siguiente paso te armo:
👉 **Login completo con JWT + Spring Boot + Retrofit + Hilt + Room** (como en una app real de empresa).
