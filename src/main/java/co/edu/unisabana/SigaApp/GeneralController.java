package co.edu.unisabana.SigaApp;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

@RestController
public class GeneralController {
    private ArrayList<Asignatura> asignaturas;
    private ArrayList<Curso> cursos;
    private ArrayList<EstudianteDTO> estudiantes;
    private ArrayList<ProfesorDTO> profesores;

    public GeneralController() {
        asignaturas = new ArrayList<>();
        cursos = new ArrayList<>();
        estudiantes = new ArrayList<>();
        profesores = new ArrayList<>();
    }

    @GetMapping("/asignatura/todas")
    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
    @PostMapping("/asignatura/crear")
    public void crearAsignatura(@RequestBody Asignatura asignatura) {
        asignaturas.add(asignatura);
    }

    @DeleteMapping("/asignatura/eliminar/{codigo}")
    public void eliminarAsignatura(@PathVariable int codigo) {
        Asignatura asignaturaAEliminar = null;
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getCodigo() == codigo) {
                asignaturaAEliminar = asignatura;
                break;
            }
        }
        if (asignaturaAEliminar != null) {
            asignaturas.remove(asignaturaAEliminar);
        }
    }

    @GetMapping("/asignaturas/facultad/{facultad}")
    public void eliminarAsignatura(@PathVariable int codigo) {
        asignaturas.removeIf(asignatura -> asignatura.getCodigo() == codigo);
    }

    @GetMapping("/curso/todos")
    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    @PostMapping("/curso/crear")
    public void crearCurso(@RequestBody Curso curso) {
        cursos.add(curso);
    }
    @DeleteMapping("/cursos/eliminar/{idCurso}")
    public void eliminarCurso(@PathVariable int idCurso) {
        cursos.removeIf(curso -> curso.getIdCurso() == idCurso);
    }

    @PostMapping("/estudiante/crear")
    public void crearEstudiante(@RequestBody EstudianteDTO estudiante) {
        estudiantes.add(estudiante);
    }

    @DeleteMapping("/estudiante/eliminar/{codigo}")
    public void eliminarEstudiante(@PathVariable int codigo) {
        estudiantes.removeIf(estudiante -> estudiante.getCodigo() == codigo);
    }
    @GetMapping("/estudiante")
    public ArrayList<EstudianteDTO> getEstudiantes() {
        return estudiantes;
    }

    @GetMapping("/profesor/todos")
    public ArrayList<ProfesorDTO> getProfesores() {
        return profesores;
    }
    @PostMapping("/profesor/crear")
    public void crearProfesor(@RequestBody ProfesorDTO profesor) {
        profesores.add(profesor);
    }

    @DeleteMapping("/profesor/eliminar/{codigo}")
    public void eliminarProfesor(@PathVariable int codigo) {
        profesores.removeIf(profesor -> profesor.getCodigo() == codigo);
    }

    @GetMapping("/profesor/facultad/{facultad}")
    public ArrayList<ProfesorDTO> filtrarProfesoresPorFacultad(@PathVariable FacultadEnum facultad) {
        ArrayList<ProfesorDTO> profesoresFiltrados = new ArrayList<>();
        for (ProfesorDTO profesor : profesores) {
            if (profesor.getFacultad() == facultad) {
                profesoresFiltrados.add(profesor);
            }
        }
        return profesoresFiltrados;
    }


}

