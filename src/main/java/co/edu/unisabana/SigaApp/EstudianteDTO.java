package co.edu.unisabana.SigaApp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

class EstudianteDTO {
    @JsonProperty
    private String nombre;
    private int codigo;
    private FacultadEnum facultad;


    public EstudianteDTO(String nombre, int codigo, FacultadEnum facultad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.facultad = facultad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstudianteDTO that = (EstudianteDTO) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
