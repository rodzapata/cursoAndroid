# 📝 To-Do App con Jetpack Compose y Room

¡Bienvenido/a! Esta es una aplicación de lista de tareas creada con **Jetpack Compose**, **Room (SQLite)** y arquitectura en capas para enseñar buenas prácticas en Android con Kotlin.  

> ✅ Ideal para aprender cómo guardar datos localmente, observar cambios en tiempo real y aplicar una arquitectura limpia y escalable.

---

## 🖼️ Capturas de pantalla

| Pantalla principal | Crear tarea |
|--------------------|--------------------|
| <img src="https://github.com/user-attachments/assets/433edd2e-1aaf-41f3-86d4-f733bc8fc54f" width="200"/> | <img src="https://github.com/user-attachments/assets/0e43ed5d-2a2d-4bdf-bf30-75a431d2dfb8" width="200"/> |

---

## ⚙️ Tecnologías utilizadas

- 🧠 **Jetpack Compose** (UI moderna y declarativa)
- 💾 **Room** (persistencia de datos con SQLite)
- 🔄 **StateFlow** y **ViewModel** (manejo de estado)
- 🧩 **Inyección de dependencias manual** (AppContainer)
- 🔧 **MVVM + Repository Pattern**

---

## 🧱 Estructura del proyecto

├── data/ 

│ ├── model/ → Entidad Task.kt 

│ ├── dao/ → TaskDao.kt 

│ ├── database/ → TodoDatabase.kt 

│ ├── repository/ → TaskRepository.kt

│ ├── di/ → AppContainer.kt (inyección de dependencias)

├── ui/ 

│ ├── screens/ → HomeScreen + HomeViewModel, EntryScreen + EntryViewModel

│ ├── components/ → EntryBody

└── TodoApplication.kt → inicializa la base de datos

---

## 📚 Recursos útiles
[Room Dependency](https://developer.android.com/jetpack/androidx/releases/room?hl=es-419#kts)

---

## 🚀 Cómo correr el proyecto

1. 📦 Clona el repositorio:
   ```bash
    git clone https://github.com/JGaldo-beep/todo_app
   ```
2. 📁 Abre el archivo con Android Studio o clona desde el IDE (Preferible):

   Clone Repository > `Inserta la URL del repositorio` > Clone

3. ▶️ Corre la app en un Emulador o tu Móvil

---

## 👀 ¿Te gustaría aprender a realizarlo? 

Mira mi video en YouTube, te enseño a entender el proyecto y te digo que tu puedes crear el tuyo!

- [Clase 6: Persistencia de datos](https://youtu.be/UJrqRPH1flQ?si=olfOe47H8CY6sB9z)
