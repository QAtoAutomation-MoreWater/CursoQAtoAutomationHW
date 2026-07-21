# 🧪 CursoQAtoAutomation — Homework

Repositorio oficial de tareas del curso **QA to Automation** de [QAtoAutomation-MoreWater](https://github.com/QAtoAutomation-MoreWater).

Aquí cada alumno sube sus tareas semanales en su **propia rama**. 🚀

---

## 📌 Tarea Semana 02 — Validador de Login (Java + Consola)

### 🎯 Objetivo

Crear un programa en Java que funcione como un **login por consola**: el programa debe **pedir el usuario y la contraseña directamente en la consola** (usando `Scanner`) y validar contra los 4 usuarios de prueba.

> 💡 El parámetro debe ser **escrito directamente por el usuario en la consola** (preferido). Como alternativa opcional, puedes ofrecer un menú de selección (1, 2, 3, 4...), pero la entrada escrita es la forma preferida.

### 👥 Usuarios a validar

La contraseña para todos los usuarios es: `secret_sauce`

| Usuario | Comportamiento esperado |
|---|---|
| `standard_user` | ✅ Login exitoso |
| `locked_out_user` | 🔒 Usuario bloqueado — mostrar mensaje de bloqueo |
| `problem_user` | ⚠️ Entra, pero avisar que las imágenes no cargan correctamente |
| `performance_glitch_user` | 🐢 Entra, pero simular lentitud: tarda entre 10 y 20 segundos en ingresar |
| Cualquier otro usuario / contraseña incorrecta | ❌ Login fallido |

### 📁 Estructura del proyecto

La tarea se genera **dentro de tu proyecto `semana02`**, en la ruta de paquetes con **tu nombre**:

```
semana02/
└── src/
    └── main/
        └── java/
            └── com/
                └── <tunombre>/
                    └── qa/
                        └── ValidadorLogin.java
```

Ejemplo: si te llamas Ana, tu clase vive en `src/main/java/com/ana/qa/ValidadorLogin.java` y el paquete es:

```java
package com.ana.qa;
```

### ✅ Requisitos mínimos

1. Pedir **usuario** y **contraseña** por consola con `Scanner`.
2. Validar los **4 usuarios** de la tabla y mostrar el mensaje correspondiente a cada uno.
3. Manejar el caso de credenciales incorrectas (login fallido).
4. Para `performance_glitch_user`, simular la espera de 10–20 segundos antes de mostrar el resultado.

### 🌟 Reto

Queremos ver un **código impresionante**. Está permitido apoyarte de la IA, pero recuerda:

> ⚠️ **Cada cosa que generes la debes poder explicar**, porque lo harás frente al grupo, y cada alumno propondrá mejoras al código de sus compañeros.

Ideas para destacar: validación de intentos máximos, mensajes con formato, uso de `switch`, enums, métodos separados, manejo de excepciones, colores en consola, etc.

---

## 📤 Cómo entregar tu tarea (Git paso a paso)

Cada alumno debe subir su tarea a este repositorio en **su propia rama**.

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/QAtoAutomation-MoreWater/CursoQAtoAutomationHW.git
cd CursoQAtoAutomationHW
```

### 2️⃣ Crear tu rama (usa tu nombre, sin espacios)

```bash
git checkout -b semana02-tunombre
```

Ejemplo:

```bash
git checkout -b semana02-ana
```

### 3️⃣ Copiar tu carpeta con la tarea

Copia tu carpeta `semana02` (con todo tu proyecto: `pom.xml`, `src`, etc.) dentro de una carpeta con tu nombre en la raíz del repositorio, y **reemplaza todo** si ya existía:

```
CursoQAtoAutomationHW/
└── tunombre/
    └── semana02/
        ├── pom.xml
        └── src/
            └── main/
                └── java/
                    └── com/
                        └── tunombre/
                            └── qa/
                                └── ValidadorLogin.java
```

> 🗑️ No copies la carpeta `target/` (es código compilado, no se sube al repo).

### 4️⃣ Agregar y confirmar tus cambios

```bash
git add .
git commit -m "Tarea semana02 - ValidadorLogin - TuNombre"
```

### 5️⃣ Subir tu rama al repositorio

```bash
git push -u origin semana02-tunombre
```

### 6️⃣ Verificar

Entra a [https://github.com/QAtoAutomation-MoreWater/CursoQAtoAutomationHW](https://github.com/QAtoAutomation-MoreWater/CursoQAtoAutomationHW), selecciona tu rama en el menú desplegable y confirma que tu carpeta y tu `ValidadorLogin.java` estén ahí. ✔️

---

## 📋 Checklist de entrega

- [ ] Mi clase se llama `ValidadorLogin.java`
- [ ] Está en el paquete `com.<minombre>.qa` dentro de `semana02`
- [ ] Pide usuario y contraseña por consola (escrito, no hardcodeado)
- [ ] Valida los 4 usuarios con su comportamiento correspondiente
- [ ] Maneja el login fallido
- [ ] Creé mi rama `semana02-minombre` y subí mi carpeta
- [ ] Puedo explicar **cada línea** de mi código

---

## 🧑‍🏫 Dinámica de revisión

En la siguiente sesión, cada alumno:

1. Ejecutará y **explicará su código** frente al grupo.
2. Recibirá **propuestas de mejora** de sus compañeros.

¡Éxito! 💪
