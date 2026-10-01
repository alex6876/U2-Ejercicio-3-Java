## 📖 Explicación de la Arquitectura y Funcionamiento

### 🎯 Propósito del Sistema
El objetivo de este proyecto es modelar la interacción entre un dispositivo físico (`ReproductorAudio`) y una interfaz de control a distancia (`ControlRemoto`), garantizando la separación de responsabilidades, la encapsulación de variables de estado y la validación de parámetros en tiempo de ejecución.

---

### 🧩 Patrón de Diseño y Principios Aplicados

1. **Patrón de Delegación / Adaptador (Delegation Pattern):**
   * La clase `ControlRemoto` no implementa directamente la lógica de reproducción ni modifica variables internas; en su lugar, delega todas las órdenes al objeto `ReproductorAudio` que recibe en su constructor.
   * Esto desacopla al cliente/usuario de la implementación interna del dispositivo.

2. **Encapsulamiento y Ocultamiento de Datos:**
   * Los atributos de las clases (`volumenActual`, `estado`, `reproductorAudio`) están declarados como `private` para evitar modificaciones directas no autorizadas desde clases externas.
   * La interacción se realiza únicamente a través de los métodos públicos provistos por la interfaz de cada clase.

3. **Manejo de Estados y Validaciones:**
   * **Control de Volumen:** Contempla un rango estricto de $0\%$ a $100\%$. Cualquier intento de asignación fuera de este límite es rechazado sin alterar el estado previo.
   * **Flujo de Ejecución:** El reproductor mantiene trazabilidad de su estado operativo (`"Detenido"`, `"Reproduciendose"`, `"Pausado"`), impidiendo transiciones inválidas (por ejemplo, intentar pausar cuando la música ya está detenida).

---

### 🔍 Estructura de Componentes

| Componente | Responsabilidad Principal |
| :--- | :--- |
| **`ReproductorAudio`** | Contiene la lógica del dominio, el estado del volumen, el estado de reproducción y las validaciones correspondientes. |
| **`ControlRemoto`** | Actúa como interfaz intermedia para enviar comandos (`play`, `pause`, `volumen`) al reproductor asociado. |
| **`Main`** | Clase de entrada que orquesta la creación del reproductor, vincula el control remoto y simula una secuencia de uso. |

---

### ⚡ Flujo de Control en la Ejecución

1. **Instanciación:** Se crea un objeto `ReproductorAudio` asignando por defecto el volumen en $50\%$ y el estado en `"Detenido"`.
2. **Asociación:** Se instancia `ControlRemoto` pasándole la referencia del reproductor mediante inyección por constructor.
3. **Acción `play()`:** El control invoca `reproductor.play()`, cambiando el estado a `"Reproduciendose"`.
4. **Acción `volumen(75)`:** El control invoca `reproductor.cambiarVolume(75)`, validando que $75$ esté entre $0$ y $100$, y actualiza el valor.
5. **Acción `pause()`:** El control invoca `reproductor.pause()`, verifica que el estado sea `"Reproduciendose"` y transiciona a `"Pausado"`.
