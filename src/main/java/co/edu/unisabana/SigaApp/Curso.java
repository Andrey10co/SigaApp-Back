package co.edu.unisabana.SigaApp;
import java.util.ArrayList;
public class Curso {
    private ProfesorDTO profesor;
    private ArrayList<EstudianteDTO> estudiantes;

    public Curso(ProfesorDTO profesor, ArrayList<EstudianteDTO> estudiantes) {
        this.profesor = profesor;
        this.estudiantes = estudiantes;
    }
    public Curso(ProfesorDTO profesor) {
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
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
