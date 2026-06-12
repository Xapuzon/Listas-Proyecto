import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Etiqueta (estudio/casa/trabajo): ");
                    String etiqueta = scanner.nextLine();
                    System.out.print("Prioridad (1-5): ");
                    int prioridad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("¿Completada? (s/n): ");
                    boolean completada = scanner.nextLine().equalsIgnoreCase("s");
                    Tarea nueva = new Tarea(titulo, etiqueta, prioridad, completada);
                    if (gestor.anadir(nueva)) {
                        System.out.println("Tarea añadida correctamente.");
                    } else {
                        System.out.println("No se pudo añadir: tarea nula o título duplicado.");
                    }
                    break;

                case 2:
                    System.out.print("Título a eliminar: ");
                    String titElim = scanner.nextLine();
                    if (gestor.eliminarPorTitulo(titElim)) {
                        System.out.println("Tarea eliminada.");
                    } else {
                        System.out.println("No se encontró ninguna tarea con ese título.");
                    }
                    break;

                case 3:
                    System.out.print("Título a buscar: ");
                    String titBuscar = scanner.nextLine();
                    Tarea encontrada = gestor.obtenerPorTitulo(titBuscar);
                    if (encontrada != null) {
                        System.out.println("Encontrada: " + encontrada);
                    } else {
                        System.out.println("No se encontró ninguna tarea con ese título.");
                    }
                    break;

                case 4:
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

                case 5:
                    System.out.print("Etiqueta a filtrar: ");
                    String etFiltro = scanner.nextLine();
                    ArrayList<Tarea> porEtiqueta = gestor.listarPorEtiqueta(etFiltro);
                    if (porEtiqueta.isEmpty()) {
                        System.out.println("No hay tareas con esa etiqueta.");
                    } else {
                        System.out.println("--- Tareas con etiqueta '" + etFiltro + "' ---");
                        for (Tarea t : porEtiqueta) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 6:
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

                case 7:
                    System.out.print("Título de la tarea a completar: ");
                    String titCompletar = scanner.nextLine();
                    gestor.marcarCompletada(titCompletar);
                    System.out.println("Operación realizada (si existía la tarea, ya está completada).");
                    break;

                case 8:
                    double media = gestor.mediaPrioridad();
                    System.out.println("Media de prioridad: " + media);
                    break;

                case 9:
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

        scanner.close();
    }
}
