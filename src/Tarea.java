// === CLASE DADA: NO MODIFICAR (implementación del esqueleto dado) ===
public class Tarea {
    private final String titulo;
    private String etiqueta;
    private int prioridad;
    private boolean completada;

    public Tarea(String titulo, String etiqueta, int prioridad, boolean completada) {
        this.titulo = titulo;
        this.etiqueta = etiqueta;
        this.prioridad = prioridad;
        this.completada = completada;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "[" + titulo + "] etiqueta=" + etiqueta +
                ", prioridad=" + prioridad +
                ", completada=" + (completada ? "sí" : "no");
    }
}
