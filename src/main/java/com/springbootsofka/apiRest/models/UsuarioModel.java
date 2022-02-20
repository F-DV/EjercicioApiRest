package com.springbootsofka.apiRest.models;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioModel {
    /**
     * Model trata las tabla de base de datos como clases en java
     * @Entity :  Reconoce a esta clase como una entidad
     * @Table(name = "usuario") : Nos permite darle un nombre a la tabla
     * @Id : Reconoce atributo como un id
     * @GeneratedValue(strategy = GenerationType.IDENTITY) : Genera valor auuto incrementa
     * @Column : Nos permite ponerle las restricciones a esta columna, primarykey
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String email;
    private Integer prioridad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
}
