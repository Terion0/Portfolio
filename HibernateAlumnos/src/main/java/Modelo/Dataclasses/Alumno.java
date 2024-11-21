package Modelo.Dataclasses;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Alumno")
public @Data class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="nombre")
    private String nombre;
    @Column(name ="apellido")
    private String apellido;
    @Column(name ="edad")
    private int edad;
    @Column(name ="nota")
    private double nota;

}
