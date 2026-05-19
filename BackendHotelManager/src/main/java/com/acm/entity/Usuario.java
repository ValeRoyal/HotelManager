package com.acm.entity;

import com.acm.entity.enums.RolUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad que representa a un usuario del sistema.
 *
 * <p>Puede ser cliente o empleado según su rol. Está asociado a un hotel
 * y puede participar en reservas como cliente o como empleado.</p>
 */
@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    /** Identificador único del usuario (PK). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre completo del usuario. */
    private String nombreCompleto;

    /** Correo del usuario (único y obligatorio). */
    @Column(unique = true, nullable = false)
    private String correo;

    /** Contraseña del usuario. */
    private String password;

    /** Documento de identidad del usuario. */
    private String documentoIdentidad;

    /** Teléfono de contacto. */
    private String telefono;

    /** Fecha de nacimiento. */
    private LocalDate fechaNacimiento;

    /** Cargo del usuario (si es empleado). */
    private String cargo;

    /** Fecha de contratación (si es empleado). */
    private LocalDate fechaContratacion;

    /** Rol del usuario dentro del sistema. */
    @Enumerated(EnumType.STRING)
    private RolUsuario rol;

    /** Hotel al que pertenece el usuario. */
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    /** Reservas donde el usuario es cliente. */
    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservasCliente;

    /** Reservas donde el usuario es empleado. */
    @OneToMany(mappedBy = "empleado")
    private List<Reserva> reservasEmpleado;

    /** Fecha de creación del registro. */
    private LocalDateTime fechaCreacion = LocalDateTime.now();
}