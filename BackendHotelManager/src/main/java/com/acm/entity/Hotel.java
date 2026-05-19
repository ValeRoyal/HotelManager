package com.acm.entity;

import com.acm.entity.enums.EstadoHotel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad que representa un hotel dentro del sistema.
 *
 * <p>Contiene información general del hotel (nombre, dirección,
 * ciudad, categoría, estado). Se relaciona con empleados,
 * habitaciones y servicios asociados.</p>
 */
@Entity
@Table(name = "hoteles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {

    /** Identificador único del hotel (PK). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre del hotel. */
    private String nombre;

    /** Dirección física del hotel. */
    private String direccion;

    /** Ciudad donde se ubica el hotel. */
    private String ciudad;

    /** Teléfono de contacto. */
    private String telefono;

    /** Correo electrónico del hotel (único). */
    @Column(unique = true)
    private String correo;

    /** Categoría del hotel (1-5 estrellas). */
    private Integer categoria;

    /** Estado operativo del hotel. */
    @Enumerated(EnumType.STRING)
    private EstadoHotel estado;

    /** Fecha de creación del registro. */
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    /** Empleados asignados al hotel. */
    @OneToMany(mappedBy = "hotel")
    private List<Usuario> empleados;

    /** Habitaciones registradas en el hotel. */
    @OneToMany(mappedBy = "hotel")
    private List<Habitacion> habitaciones;

    /** Servicios adicionales ofrecidos por el hotel. */
    @OneToMany(mappedBy = "hotel")
    private List<Servicio> servicios;
}