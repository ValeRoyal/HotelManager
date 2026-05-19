package com.acm.entity;

import com.acm.entity.enums.EstadoReserva;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad que representa una reserva de habitación.
 *
 * <p>Incluye información del cliente, empleado que gestiona,
 * habitación asignada, fechas de estadía y estado de la reserva.
 * También se relaciona con pagos, facturas y servicios consumidos.</p>
 */
@Entity
@Table(name = "reservas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    /** Identificador único de la reserva (PK). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Cliente que realiza la reserva. */
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    /** Habitación reservada. */
    @ManyToOne
    @JoinColumn(name = "habitacion_id")
    private Habitacion habitacion;

    /** Empleado que gestiona la reserva. */
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Usuario empleado;

    /** Fecha de ingreso del huésped. */
    private LocalDate fechaCheckIn;

    /** Fecha de salida del huésped. */
    private LocalDate fechaCheckOut;

    /** Número de huéspedes en la reserva. */
    private Integer numeroHuespedes;

    /** Precio total de la reserva. */
    private BigDecimal precioTotal;

    /** Estado actual de la reserva. */
    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    /** Observaciones adicionales de la reserva. */
    private String observaciones;

    /** Fecha y hora de creación del registro. */
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    /** Pagos asociados a la reserva. */
    @OneToMany(mappedBy = "reserva")
    private List<Pago> pagos;

    /** Facturas generadas para la reserva. */
    @OneToMany(mappedBy = "reserva")
    private List<Factura> facturas;

    /** Servicios adicionales consumidos durante la reserva. */
    @OneToMany(mappedBy = "reserva")
    private List<ReservaServicio> servicios;
}
