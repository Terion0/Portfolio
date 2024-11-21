package Modelo.Dataclasses;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tiendas")
public  @Data class Tiendas {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(name ="nombre")
        private String nombre;
        @Column(name ="localidad")
        private String localidad;
        @Column(name ="beneficiosAnuales")
        private double benefAnuales;
        @Column(name ="beneficiosMensuales")
        private double benefMensuales;

    }
