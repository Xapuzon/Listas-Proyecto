import java.util.ArrayList;

public class GestorTareas {
    private ArrayList<Tarea> tareas;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
    }

    public boolean anadir(Tarea t) {
        if (t == null) return false;
        for (Tarea tarea : tareas) {
            if (tarea.getTitulo().equals(t.getTitulo())) return false;
        }
        tareas.add(t);
        return true;
    }

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

    public Tarea obtenerPorTitulo(String titulo) {
        for (Tarea tarea : tareas) {
            if (tarea.getTitulo().equals(titulo)) return tarea;
        }
        return null;
    }

    public ArrayList<Tarea> listarTodas() {
        return tareas;
    }

    public ArrayList<Tarea> listarPorEtiqueta(String etiqueta) {
        ArrayList<Tarea> resultado = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (tarea.getEtiqueta().equals(etiqueta)) resultado.add(tarea);
        }
        return resultado;
    }

    public ArrayList<Tarea> listarPendientes() {
        ArrayList<Tarea> resultado = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (!tarea.isCompletada()) resultado.add(tarea);
        }
        return resultado;
    }

    public void marcarCompletada(String titulo) {
        Tarea tarea = obtenerPorTitulo(titulo);
        if (tarea != null) tarea.setCompletada(true);
    }

    public double mediaPrioridad() {
        if (tareas.isEmpty()) return 0.0;
        int suma = 0;
        for (Tarea tarea : tareas) {
            suma += tarea.getPrioridad();
        }
        return (double) suma / tareas.size();
    }

    public void limpiar() {
        tareas.clear();
    }
}
