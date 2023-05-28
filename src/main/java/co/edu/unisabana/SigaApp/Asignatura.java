package co.edu.unisabana.SigaApp;
import java.util.ArrayList;
import java.util.Objects;

public class Asignatura {
    private String nombre;
    private String facultad;
    private ArrayList<Curso> cursos;

    public Asignatura(String nombre, int codigo, String facultad) {
        this.nombre = nombre;
        this.facultad = facultad;
        this.cursos = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asignatura that)) return false;
        return nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void eliminarCurso(Curso curso) {
        cursos.remove(curso);
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }
}
