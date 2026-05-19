package com.acm.entity;

import com.acm.entity.enums.EstadoHabitacion;
import com.acm.entity.enums.TipoHabitacion;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "habitaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @Enumerated(EnumType.STRING)
    private TipoHabitacion tipo;

    private Integer piso;
    private Integer capacidad;

    @Column(nullable = false)
    private BigDecimal precioPorNoche;

    @Enumerated(EnumType.STRING)
    private EstadoHabitacion estado;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "habitacion")
    private List<Reserva> reservas;
}
