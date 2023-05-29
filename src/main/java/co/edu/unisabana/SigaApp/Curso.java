package co.edu.unisabana.SigaApp;
import lombok.Data;

import java.util.ArrayList;
import java.util.Random;
@Data
public class Curso {
    private ProfesorDTO profesor;
    private int idCurso;
    private ArrayList<EstudianteDTO> estudiantes;

    public Curso(ProfesorDTO profesor) {
        this.idCurso = generarIdCurso();
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
    }
    public int getIdCurso() {
        return idCurso;
    }

    private int generarIdCurso() {
        Random random = new Random();
        return random.nextInt(10000);
    }
    public void agregarEstudiante(EstudianteDTO estudiante) {
        estudiantes.add(estudiante);
    }

    public void eliminarEstudiante(EstudianteDTO estudiante) {
        estudiantes.remove(estudiante);
    }

    public ArrayList<EstudianteDTO> getEstudiantes() {
        return estudiantes;
    }

}
