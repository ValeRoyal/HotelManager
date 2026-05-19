package com.acm.entity;

import com.acm.entity.enums.EstadoHotel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "hoteles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private String ciudad;
    private String telefono;

    @Column(unique = true)
    private String correo;

    private Integer categoria;

    @Enumerated(EnumType.STRING)
    private EstadoHotel estado;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @OneToMany(mappedBy = "hotel")
    private List<Usuario> empleados;

    @OneToMany(mappedBy = "hotel")
    private List<Habitacion> habitaciones;

    @OneToMany(mappedBy = "hotel")
    private List<Servicio> servicios;
}
