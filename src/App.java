import java.util.ArrayList;
import java.util.Scanner;

// Menú interactivo para usar todas las operaciones del GestorTareas
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();
        int opcion;

        do {
            System.out.println("\n=== GESTOR DE TAREAS ===");
            System.out.println("1. Añadir tarea");
            System.out.println("2. Eliminar tarea por título");
            System.out.println("3. Buscar tarea por título");
            System.out.println("4. Listar todas las tareas");
            System.out.println("5. Listar tareas por etiqueta");
            System.out.println("6. Listar tareas pendientes");
            System.out.println("7. Marcar tarea como completada");
            System.out.println("8. Ver media de prioridad");
            System.out.println("9. Limpiar todas las tareas");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpia el salto de línea que deja nextInt()

            switch (opcion) {
                case 1: // pide datos al usuario y añade la tarea
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Etiqueta (estudio/casa/trabajo): ");
                    String etiqueta = sc.nextLine();
                    System.out.print("Prioridad (1-5): ");
                    int prioridad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("¿Completada? (s/n): ");
                    boolean completada = sc.nextLine().equalsIgnoreCase("s");
                    Tarea nueva = new Tarea(titulo, etiqueta, prioridad, completada);
                    if (gestor.anadir(nueva)) {
                        System.out.println("Tarea añadida correctamente.");
                    } else {
                        System.out.println("No se pudo añadir: tarea nula o título duplicado.");
                    }
                    break;

                case 2: // elimina por título, avisa si no existe
                    System.out.print("Título a eliminar: ");
                    String tituloEliminar = sc.nextLine();
                    if (gestor.eliminarPorTitulo(tituloEliminar)) {
                        System.out.println("Tarea eliminada.");
                    } else {
                        System.out.println("No se encontró ninguna tarea con ese título.");
                    }
                    break;

                case 3: // busca y muestra la tarea, o avisa si no existe
                    System.out.print("Título a buscar: ");
                    String tituloBuscar = sc.nextLine();
                    Tarea encontrada = gestor.obtenerPorTitulo(tituloBuscar);
                    if (encontrada != null) {
                        System.out.println("Encontrada: " + encontrada);
                    } else {
                        System.out.println("No se encontró ninguna tarea con ese título.");
                    }
                    break;

                case 4: // muestra todas las tareas de la lista
                    ArrayList<Tarea> todas = gestor.listarTodas();
                    if (todas.isEmpty()) {
                        System.out.println("No hay tareas.");
                    } else {
                        System.out.println("--- Todas las tareas ---");
                        for (Tarea t : todas) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 5: // filtra y muestra solo las tareas con la etiqueta indicada
                    System.out.print("Etiqueta a filtrar: ");
                    String etiquetaFiltro = sc.nextLine();
                    ArrayList<Tarea> tareasPorEtiqueta = gestor.listarPorEtiqueta(etiquetaFiltro);
                    if (tareasPorEtiqueta.isEmpty()) {
                        System.out.println("No hay tareas con esa etiqueta.");
                    } else {
                        System.out.println("--- Tareas con etiqueta '" + etiquetaFiltro + "' ---");
                        for (Tarea t : tareasPorEtiqueta) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 6: // muestra solo las tareas con completada=false
                    ArrayList<Tarea> pendientes = gestor.listarPendientes();
                    if (pendientes.isEmpty()) {
                        System.out.println("No hay tareas pendientes.");
                    } else {
                        System.out.println("--- Tareas pendientes ---");
                        for (Tarea t : pendientes) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 7: // busca la tarea por título y pone completada=true
                    System.out.print("Título de la tarea a completar: ");
                    String tituloCompletar = sc.nextLine();
                    gestor.marcarCompletada(tituloCompletar);
                    System.out.println("Operación realizada (si existía la tarea, ya está completada).");
                    break;

                case 8: // calcula y muestra la media de prioridad de todas las tareas
                    double media = gestor.mediaPrioridad();
                    System.out.println("Media de prioridad: " + media);
                    break;

                case 9: // borra todas las tareas de la lista
                    gestor.limpiar();
                    System.out.println("Lista limpiada.");
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
