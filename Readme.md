# Change Color App 🎨

Una aplicación de Android desarrollada en **Kotlin** que demuestra cómo implementar un sistema de cambio de temas dinámicos en tiempo real, utilizando `SharedPreferences` para la persistencia y un `ListView` para la interfaz de selección.

## ✨ Características

- **Cambio de Tema Dinámico:** Selecciona entre 9 colores diferentes y observa cómo cambia toda la interfaz (StatusBar, Fondo y Textos).
- **Persistencia de Datos:** El tema seleccionado se guarda localmente para que la app lo recuerde al reiniciarla.
- **Animaciones Suaves:** Transiciones de fundido (_fade_) al aplicar nuevos temas para una mejor experiencia de usuario (UX).
- **Arquitectura Kotlin:** Código migrado desde Java, utilizando `Data Classes`, `KTX Extensions` y `Lambdas`.
- **Adaptabilidad:** Iconos de la barra de estado que cambian automáticamente entre claro y oscuro según el fondo.

## 🚀 Tecnologías Utilizadas

- **Lenguaje:** [Kotlin](https://kotlinlang.org/)
- **Android KTX:** Para una manipulación de `SharedPreferences` más limpia.
- **Material Components:** Para una interfaz moderna y coherente.
- **Animaciones XML:** Definición de transiciones personalizadas.

## 🛠️ Instalación y Configuración

1. **Clona el repositorio:**

   ```bash
   git clone [https://github.com/tu-usuario/change-color-android.git](https://github.com/tu-usuario/change-color-android.git)
   ```

   1. Importa el proyecto en Android Studio.
   2. Sincroniza Gradle para descargar las dependencias necesarias.
   3. Ejecuta en un emulador o dispositivo físico con Android 6.0 (API 23) o superior.

📂 Estructura del Proyecto
• Datos.kt: Data Class que define el modelo de icono y nombre.
• DatosAdapter.kt: Adaptador personalizado para la lista de selección.
• MainActivity.kt: Lógica principal para la aplicación de temas y gestión de clics.
• res/values/themes.xml: Definición de las 9 variantes de temas (Azul, Rojo, Verde, etc.).
• res/anim/: Archivos XML para las animaciones de entrada y salida.

🎨 Paleta de Colores (Ejemplo Rojo)
Para mantener la legibilidad, se implementó una estrategia de contraste:
• Color Primario: #CA0000 (Rojo Intenso)
• Fondo: #FFD1D1 (Rojo Pastel)
• Texto: #4A0000 (Rojo Oscuro)

📄 Licencia
Este proyecto está bajo la Licencia MIT - consulta el archivo LICENSE.md para más detalles.
Generado con ❤️ para la comunidad de Android.
