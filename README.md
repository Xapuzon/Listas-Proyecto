# Gestor de Tareas

Aplicación de consola en Java para gestionar una lista de tareas. Desarrollada con IntelliJ IDEA como ejercicio del módulo de Programación (DAW, 2º evaluación).

## Clases

### `Tarea`
Clase modelo que representa una tarea. Atributos: `titulo` (único, final), `etiqueta`, `prioridad` (1-5) y `completada`.

### `GestorTareas`
Gestiona un `ArrayList<Tarea>` con las siguientes operaciones:
- `anadir` — añade una tarea si el título no está repetido
- `eliminarPorTitulo` — elimina por título
- `obtenerPorTitulo` — busca y devuelve una tarea
- `listarTodas` — devuelve la lista completa
- `listarPorEtiqueta` — filtra por etiqueta
- `listarPendientes` — filtra las no completadas
- `marcarCompletada` — marca una tarea como completada
- `mediaPrioridad` — calcula la media de prioridad
- `limpiar` — vacía la lista

### `App`
Clase principal con menú interactivo por consola que permite usar todas las operaciones del gestor.

## Ejecución

1. Abre el proyecto en IntelliJ IDEA
2. Marca la carpeta `src` como *Sources Root*
3. Ejecuta `App.java`
