package co.edu.unisabana.SigaApp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ProfesorDTO {
    @JsonProperty
    private String nombre;
    private int codigo;
    private FacultadEnum facultad;


    public ProfesorDTO(String nombre, int codigo, FacultadEnum facultad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.facultad = facultad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfesorDTO that)) return false;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
