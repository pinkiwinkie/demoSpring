package com.hh.demoSpring.repository.model;

import lombok.*;

import java.util.Objects;

//@Data -> getters, setter, constructot, toString, equals y hash pero con
//          todos los atributos
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Usuario {
    private int id;
    private String nombre,
                    apellidos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
