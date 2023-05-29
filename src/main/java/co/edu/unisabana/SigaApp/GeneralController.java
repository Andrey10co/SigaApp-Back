package co.edu.unisabana.SigaApp;
import java.util.ArrayList;

import jakarta.validation.Valid;
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
    public void crearAsignatura(@RequestBody @Valid Asignatura asignatura) {
        asignaturas.add(asignatura);
    }

    @DeleteMapping("/asignatura/eliminar/{codigo}")
    public void eliminarAsignatura(@PathVariable int codigo) {
        asignaturas.removeIf(asignatura -> asignatura.getCodigo() == codigo);
    }

    @GetMapping("/asignaturas/facultad/{facultad}")
    public ArrayList<Asignatura> filtrarAsignaturasPorFacultad(@PathVariable FacultadEnum facultad) {
        ArrayList<Asignatura> asignaturasFiltradas = new ArrayList<>();
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getFacultad() == facultad) {
                asignaturasFiltradas.add(asignatura);
            }
        }
        return asignaturasFiltradas;
    }

    @GetMapping("/curso/todos")
    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    @PostMapping("/curso/crear")
    public void crearCurso(@RequestBody @Valid Curso curso) {
        ProfesorDTO profesor = curso.getProfesor();
        Curso newCurso = new Curso(profesor);
        cursos.add(curso);
    }
    @DeleteMapping("/cursos/eliminar/{idCurso}")
    public void eliminarCurso(@PathVariable int idCurso) {
        cursos.removeIf(curso -> curso.getIdCurso() == idCurso);
    }

    @PostMapping("/curso/{cursoId}/estudiante/agregar")
    public void agregarEstudianteACurso(@PathVariable int cursoId, @RequestBody EstudianteDTO estudianteDTO) {
        Curso curso = obtenerCursoPorId(cursoId);
        if (curso != null) {
            curso.agregarEstudiante(estudianteDTO);
            actualizarCursoEnFuenteDeDatos(curso);
        }
    }

    private void actualizarCursoEnFuenteDeDatos(Curso curso) {
        // Lógica para actualizar el curso en la fuente de datos (base de datos, archivo, etc.)
    }

    private Curso obtenerCursoPorId(int cursoId) {
        for (Curso curso : cursos) {
            if (curso.getIdCurso() == cursoId) {
                return curso;
            }
        }
        return null;
    }

    @GetMapping("/estudiante/todos")
    public ArrayList<EstudianteDTO> getEstudiantes() {
        return estudiantes;
    }
    @PostMapping("/estudiante/crear")
    public void crearEstudiante(@RequestBody @Valid EstudianteDTO estudiante) {
        estudiantes.add(estudiante);
    }


    @DeleteMapping("/estudiante/eliminar/{codigo}")
    public void eliminarEstudiante(@PathVariable int codigo) {
        estudiantes.removeIf(estudiante -> estudiante.getCodigo() == codigo);
    }


    @GetMapping("/profesor/todos")
    public ArrayList<ProfesorDTO> getProfesores() {
        return profesores;
    }
    @PostMapping("/profesor/crear")
    public void crearProfesor(@RequestBody @Valid ProfesorDTO profesor) {
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

