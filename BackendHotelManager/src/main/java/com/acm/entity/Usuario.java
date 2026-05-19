package com.acm.entity;

import com.acm.entity.enums.RolUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;

    @Column(unique = true, nullable = false)
    private String correo;

    private String password;

    private String documentoIdentidad;
    private String telefono;
    private LocalDate fechaNacimiento;

    private String cargo;
    private LocalDate fechaContratacion;

    @Enumerated(EnumType.STRING)
    private RolUsuario rol;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservasCliente;

    @OneToMany(mappedBy = "empleado")
    private List<Reserva> reservasEmpleado;

    private LocalDateTime fechaCreacion = LocalDateTime.now();
}
