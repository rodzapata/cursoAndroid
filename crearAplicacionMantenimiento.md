Perfecto — te voy a construir un **prompt refinado de nivel profesional**, pensado para que aprendas _paso a paso_ pero con mentalidad de **senior Android developer en 2026**.

La idea es que este prompt lo puedas reutilizar en ChatGPT u otra IA para que te guíe como si fuera un mentor técnico.

---

# 🚀 PROMPT REFINADO (COPIAR Y USAR)

Actúa como un experto desarrollador Android senior especializado en Kotlin, Jetpack Compose, Clean Architecture, MVI/MVVM, y mejores prácticas modernas (2026).

Quiero que me guíes paso a paso para construir una aplicación real de gestión de mantenimiento de aires acondicionados, similar a un sistema tipo SAMM (Sistema Administrativo de Mantenimiento Moderno).

## 🎯 Objetivo

Desarrollar una app profesional que incluya:

- Gestión de órdenes de servicio
- Clientes
- Equipos (aires acondicionados)
- Técnicos
- Actividades de mantenimiento
- Historial de servicios
- Formularios dinámicos de preguntas y respuestas
- Sincronización con API REST (Spring Boot o .NET)
- Autenticación con JWT

## 🧠 Enfoque de aprendizaje

Quiero aprender de forma progresiva (de básico a avanzado), por lo tanto:

1. Divide el desarrollo en fases (nivel básico → intermedio → avanzado)
2. Explica cada decisión técnica como si fueras mi mentor
3. No solo muestres código, explica el POR QUÉ
4. Aplica siempre buenas prácticas reales de la industria

## 🏗️ Arquitectura requerida

- Clean Architecture
- Separación en capas:
  - Presentation (UI - Compose)
  - Domain (Use Cases)
  - Data (Repository, API, DB)

- Uso de:
  - ViewModel
  - StateFlow
  - Hilt (inyección de dependencias)
  - Navigation Compose
  - Retrofit o Ktor (API)
  - Room (opcional offline-first)

## 📱 UI/UX (Jetpack Compose)

- Diseño moderno (Material 3)
- Uso de:
  - Scaffold
  - Cards
  - LazyColumn
  - Formularios dinámicos

- Buenas prácticas UX (validaciones, loading, estados vacíos)

## ⚙️ Funcionalidades progresivas

Guíame en este orden:

### 🔹 Fase 1 - Fundamentos

- Estructura del proyecto
- Primera pantalla (lista de órdenes)
- Navegación básica

### 🔹 Fase 2 - Formularios

- Crear orden de servicio
- Formularios dinámicos (preguntas/respuestas)

### 🔹 Fase 3 - Arquitectura real

- Implementar Use Cases
- Repository pattern
- Separación real de capas

### 🔹 Fase 4 - Integración backend

- Consumir API REST
- Manejo de errores
- DTOs y mappers

### 🔹 Fase 5 - Avanzado

- Offline-first con Room
- Sincronización
- Manejo de estados complejos (MVI o MVVM avanzado)

## 📌 Reglas importantes

- Usa nombres reales del dominio (ServiceOrder, Technician, Equipment, etc.)
- Usa buenas prácticas de naming
- Aplica principios SOLID
- Evita código “de ejemplo simple”, quiero código cercano a producción
- Si hay varias opciones, dime cuál es la mejor y por qué

## 📚 Formato de respuesta

En cada paso quiero:

1. Explicación clara
2. Código completo
3. Buenas prácticas aplicadas
4. Posibles errores comunes

## 🚨 Muy importante

No avances al siguiente paso sin que yo lo indique.

Comienza por la Fase 1: estructura del proyecto y configuración inicial con Hilt + Navigation + arquitectura base.

---

# 💡 Cómo usar este prompt (estrategia real)

Te explico como un senior:

- Este prompt convierte la IA en tu **mentor técnico**
- Evita respuestas genéricas
- Te obliga a aprender como en un entorno real de trabajo

---

# 🔥 Mejora adicional (nivel PRO)

Cuando ya avances, puedes usar este tipo de prompts:

👉 Para arquitectura:

> “Refactoriza este código a Clean Architecture como lo haría un senior en una app productiva”

👉 Para UI:

> “Optimiza este Compose para recomposición eficiente y escalabilidad”

👉 Para backend:

> “Diseña los endpoints ideales para esta app móvil siguiendo buenas prácticas REST”

---

# 🚀 Siguiente paso

Si quieres, puedo:

✅ Empezar contigo la **Fase 1 real (proyecto base listo para producción)**
✅ O ayudarte a definir primero el **modelo de datos completo (como analista)**
✅ O conectarlo con tu backend en **Spring Boot o .NET (según tu experiencia)**

Solo dime:
👉 _“empezamos fase 1”_ y lo construimos como si estuvieras en una empresa real 💼
