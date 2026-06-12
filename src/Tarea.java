// Clase modelo que representa una tarea
public class Tarea {
    private final String titulo;  // identificador único, no cambia
    private String etiqueta;      // categoría: "estudio", "casa", "trabajo"
    private int prioridad;        // valor del 1 al 5
    private boolean completada;

    public Tarea(String titulo, String etiqueta, int prioridad, boolean completada) {
        this.titulo = titulo;
        this.etiqueta = etiqueta;
        this.prioridad = prioridad;
        this.completada = completada;
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getEtiqueta() { return etiqueta; }
    public int getPrioridad() { return prioridad; }
    public boolean isCompletada() { return completada; }

    // Setters (titulo no tiene setter porque es final)
    public void setEtiqueta(String etiqueta) { this.etiqueta = etiqueta; }
    public void setPrioridad(int prioridad) { this.prioridad = prioridad; }
    public void setCompletada(boolean completada) { this.completada = completada; }

    // Devuelve la tarea formateada para mostrar por consola
    @Override
    public String toString() {
        return "[" + titulo + "] etiqueta=" + etiqueta +
                ", prioridad=" + prioridad +
                ", completada=" + (completada ? "sí" : "no");
    }
}
