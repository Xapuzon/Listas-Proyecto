import java.util.ArrayList;

// Gestiona la colección de tareas
public class GestorTareas {
    private ArrayList<Tarea> tareas;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
    }

    // Añade la tarea si no hay otra con el mismo título. Devuelve false si es null o duplicada
    public boolean anadir(Tarea t) {
        if (t == null) return false;
        for (Tarea tarea : tareas) {
            if (tarea.getTitulo().equals(t.getTitulo())) return false;
        }
        tareas.add(t);
        return true;
    }

    // Elimina todas las tareas con ese título. Recorre hacia atrás para no alterar los índices al borrar
    public boolean eliminarPorTitulo(String titulo) {
        boolean eliminado = false;
        for (int i = tareas.size() - 1; i >= 0; i--) {
            if (tareas.get(i).getTitulo().equals(titulo)) {
                tareas.remove(i);
                eliminado = true;
            }
        }
        return eliminado;
    }

    // Devuelve la primera tarea que coincida con el título, o null si no existe
    public Tarea obtenerPorTitulo(String titulo) {
        for (Tarea tarea : tareas) {
            if (tarea.getTitulo().equals(titulo)) return tarea;
        }
        return null;
    }

    // Devuelve la lista completa tal cual
    public ArrayList<Tarea> listarTodas() {
        return tareas;
    }

    // Devuelve una lista nueva solo con las tareas que tienen esa etiqueta
    public ArrayList<Tarea> listarPorEtiqueta(String etiqueta) {
        ArrayList<Tarea> resultado = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (tarea.getEtiqueta().equals(etiqueta)) resultado.add(tarea);
        }
        return resultado;
    }

    // Devuelve una lista nueva solo con las tareas no completadas
    public ArrayList<Tarea> listarPendientes() {
        ArrayList<Tarea> resultado = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (!tarea.isCompletada()) resultado.add(tarea);
        }
        return resultado;
    }

    // Busca la tarea por título y la marca como completada si existe
    public void marcarCompletada(String titulo) {
        Tarea tarea = obtenerPorTitulo(titulo);
        if (tarea != null) tarea.setCompletada(true);
    }

    // Suma todas las prioridades y divide entre el total. Devuelve 0.0 si no hay tareas
    public double mediaPrioridad() {
        if (tareas.isEmpty()) return 0.0;
        int suma = 0;
        for (Tarea tarea : tareas) {
            suma += tarea.getPrioridad();
        }
        return (double) suma / tareas.size();
    }

    // Vacía la lista completamente
    public void limpiar() {
        tareas.clear();
    }
}
