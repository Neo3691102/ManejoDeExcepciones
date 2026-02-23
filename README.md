# ⚠️ Manejo de Excepciones en Java

## 📌 Descripción

Este proyecto demuestra el manejo de excepciones en Java mediante:

- 🔹 Excepciones Checked
- 🔹 Excepciones Runtime (Unchecked)
- 🔹 Uso de try-catch-finally
- 🔹 Propagación con throws
- 🔹 Creación de excepciones personalizadas
- 🔹 Lanzamiento manual con throw
- 🔹 Manejo en capas (negocio + contexto)

El objetivo es comprender cómo Java gestiona errores y cómo diseñar un manejo de excepciones adecuado.

---

## 🛠 Tecnologías Utilizadas

- ☕ Java 8+
- 📦 java.io
- 🧠 Programación orientada a objetos

---

## 📂 Estructura del Proyecto

```
com.ebac.modulo45
│
├── ClaseExcepciones.java
├── ClaseExcepcionesRunTime.java
└── MiExcepcion.java
```

---

# 🔹 1️⃣ Excepciones Checked

## 📌 ¿Qué son?

Son excepciones que:

- El compilador obliga a manejar.
- Deben declararse con `throws` o capturarse con `try-catch`.

Ejemplo típico: `IOException`.

---

## 📖 Ejemplo: Manejo con try-catch-finally

```java
public static void crearArchivo(String nombreArchivo){
    try{
        FileWriter fw = new FileWriter(nombreArchivo);
    }catch (IOException e){
        System.out.println("Error al generar el archivo: " + e.getMessage());
    }finally{
        System.out.println("Bloque finally");
    }
}
```

### 🔎 Explicación

- `try`: Código que puede generar excepción.
- `catch`: Captura y maneja la excepción.
- `finally`: Se ejecuta siempre (haya o no error).

---

## 📖 Ejemplo: Propagación con throws

```java
public static void crearArchivoDos(String nombreArchivo) throws IOException {
    FileWriter fw2 = new FileWriter(nombreArchivo);
}
```

Aquí:

- No se maneja la excepción.
- Se delega la responsabilidad al método que llama.

```java
public static void main(String[] args) throws IOException {
    crearArchivoDos("ruta/archivo.txt");
}
```

---

# 🔹 2️⃣ Excepciones Runtime (Unchecked)

## 📌 ¿Qué son?

- No requieren ser declaradas.
- Ocurren durante la ejecución.
- Extienden de `RuntimeException`.

Ejemplo común:
- `ArrayIndexOutOfBoundsException`
- `NullPointerException`

---

## 📖 Ejemplo

```java
char[] car = new char[2];
car[0] = 'a';
car[1] = 'b';

try{
    car[2] = 'c';
}catch(Exception e){
    System.out.println(e.getMessage());
}

System.out.println(car);
```

### 🔎 Qué ocurre

- El arreglo tiene tamaño 2.
- Se intenta acceder a la posición 2 (índices válidos: 0 y 1).
- Se lanza `ArrayIndexOutOfBoundsException`.
- Es capturada por el bloque catch.

---

# 🔹 3️⃣ Excepciones Personalizadas

## 📌 ¿Por qué crear una excepción personalizada?

Para:

- Representar errores de negocio.
- Hacer el código más expresivo.
- Separar errores técnicos de errores lógicos.

---

## 📖 Definición de la excepción

```java
public class MiExcepcion extends Exception{

    public MiExcepcion(String message) {
        super("Ocurrio un error - " + message);
    }

    public MiExcepcion() {
        super("Ocurrio un error");
    }
}
```

### 🔎 Características

- Extiende de `Exception` → Es checked.
- Permite mensajes personalizados.
- Puede tener múltiples constructores.

---

# 🔹 4️⃣ Lanzamiento Manual con throw

## 📖 Lógica de Negocio

```java
class Miclasenegocio {
    public void calcularSuma(int a, int b) throws MiExcepcion {
        if(a < 10){
            throw new MiExcepcion("El numero a no puede ser menor a 10");
        }else{
            System.out.println("La suma es: " + (a + b));
        }
    }
}
```

Aquí:

- Se valida una regla de negocio.
- Si no se cumple, se lanza excepción personalizada.
- Se usa la palabra clave `throw`.

---

# 🔹 5️⃣ Manejo en el Contexto

```java
class Contexto {
    public static void main(String[] args) {
        Miclasenegocio mcn = new Miclasenegocio();
        try{
            mcn.calcularSuma(3, 6);
        }catch(MiExcepcion e){
            System.out.println(e.getMessage());
        }
    }
}
```

### 🔎 Flujo

1. Se llama a `calcularSuma`.
2. Se incumple la regla (`a < 10`).
3. Se lanza `MiExcepcion`.
4. Se captura en `Contexto`.
5. Se imprime el mensaje personalizado.

---

# 🧠 Conceptos Clave

## 🔹 throw vs throws

| Palabra | Uso |
|---------|------|
| throw | Lanza una excepción |
| throws | Declara que un método puede lanzar excepción |

---

## 🔹 Checked vs Unchecked

| Tipo | Obliga a manejar | Ejemplo |
|------|-----------------|----------|
| Checked | Sí | IOException |
| Unchecked | No | NullPointerException |

---

## 🔹 Buenas Prácticas

- ✔ Crear excepciones personalizadas para reglas de negocio.
- ✔ No capturar `Exception` genérico sin necesidad.
- ✔ No ignorar excepciones silenciosamente.
- ✔ Usar mensajes claros y descriptivos.
- ✔ Separar errores técnicos de errores de lógica.

---

# 🎯 Objetivo Académico

Este proyecto permite comprender:

- Cómo funciona el sistema de excepciones en Java.
- Diferencias entre errores en tiempo de compilación y ejecución.
- Diseño de excepciones personalizadas.
- Propagación y manejo en distintas capas.
- Control del flujo ante errores.

---

# 📚 Requisitos

- Java 8+
- Conocimientos básicos de POO
- Comprensión básica de métodos y clases

---

# 👨‍💻 Proyecto Académico

Práctica enfocada en:

- Robustez del código
- Manejo controlado de errores
- Buenas prácticas en desarrollo Java
- Diseño orientado a dominio
