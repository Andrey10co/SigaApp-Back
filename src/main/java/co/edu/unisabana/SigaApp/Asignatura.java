package co.edu.unisabana.SigaApp;
import java.util.ArrayList;
import java.util.Objects;

import jakarta.validation.constraints.*;
import lombok.Data;
@Data
public class Asignatura {
    @NotNull
    @Size(min = 3,max = 50,message = "No cumple los caracteres minimos o maximos")
    private String nombre;
    @NotNull(message = "Ingrese un valor para el campo")
    @Min(value = 0, message = "El código debe ser mínimo 4 dígitos")
    @Max(value = 9999, message = "El código debe ser maximo 4 dígitos")
    private int codigo;
    @NotNull(message = "Ingrese un valor para el campo")
    private FacultadEnum facultad;
    @NotEmpty(message = "La lista de curs no puede estar vacía")
    private ArrayList<Curso> cursos;

    public Asignatura(String nombre, int codigo, FacultadEnum facultad) {
        this.codigo=codigo;
        this.nombre = nombre;
        this.facultad = facultad;
        this.cursos = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asignatura that)) return false;
        return getCodigo() == that.getCodigo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    public Curso obtenerCursoPorId(int cursoId) {
        for (Curso curso : cursos) {
            if (curso.getIdCurso() == cursoId) {
                return curso;
            }
        }
        return null; // Si no se encuentra el curso con el ID buscado
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
