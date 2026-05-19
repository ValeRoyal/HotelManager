package com.acm.entity;

import com.acm.entity.enums.EstadoHabitacion;
import com.acm.entity.enums.TipoHabitacion;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Entidad que representa una habitación dentro de un hotel.
 *
 * <p>Incluye datos básicos (número, tipo, piso, capacidad, precio)
 * y su estado operativo. Está asociada a un hotel y puede tener
 * múltiples reservas.</p>
 */
@Entity
@Table(name = "habitaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Habitacion {

    /** Identificador único de la habitación (PK). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Número o código interno de la habitación. */
    private String numero;

    /** Tipo de habitación (sencilla, doble, suite, presidencial). */
    @Enumerated(EnumType.STRING)
    private TipoHabitacion tipo;

    /** Piso donde se ubica la habitación. */
    private Integer piso;

    /** Capacidad máxima de huéspedes. */
    private Integer capacidad;

    /** Precio base por noche. */
    @Column(nullable = false)
    private BigDecimal precioPorNoche;

    /** Estado operativo de la habitación. */
    @Enumerated(EnumType.STRING)
    private EstadoHabitacion estado;

    /** Descripción opcional de la habitación. */
    private String descripcion;

    /** Hotel al que pertenece la habitación. */
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    /** Reservas asociadas a la habitación. */
    @OneToMany(mappedBy = "habitacion")
    private List<Reserva> reservas;
}