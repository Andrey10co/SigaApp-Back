package co.edu.unisabana.SigaApp;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Objects;
@Data
public class ProfesorDTO {


    @NotNull(message = "Este campo es requerido")
    private String nombre;
    @NotNull(message = "Ingrese un valor para el campo")
    @Min(value = 0, message = "El código debe ser mínimo 4 dígitos")
    @Max(value = 9999, message = "El código debe ser maximo 4 dígitos")
    private int codigo;
    @NotNull(message = "Ingrese un valor para el campo")
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
