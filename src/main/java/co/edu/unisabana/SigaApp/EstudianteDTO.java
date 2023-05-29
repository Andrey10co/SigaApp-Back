package co.edu.unisabana.SigaApp;

import java.util.Objects;

import jakarta.validation.constraints.*;
import lombok.Data;
@Data
class EstudianteDTO {

    @NotNull(message = "Este campo es requerido")
    private String nombre;
    @NotNull(message = "Ingrese un valor para el campo")
    @Min(value = 0, message = "El código debe ser mínimo 4 dígitos")
    @Max(value = 9999, message = "El código debe ser maximo 4 dígitos")
    private int codigo;

    @NotNull(message = "Ingrese un valor para el campo")
    private FacultadEnum facultad;



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
