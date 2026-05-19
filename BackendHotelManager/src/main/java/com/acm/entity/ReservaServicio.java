package com.acm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidad intermedia que representa el consumo de un servicio en una reserva.
 *
 * <p>Relaciona una reserva con un servicio específico,
 * e incluye datos como cantidad, fecha de uso y subtotal.</p>
 */
@Entity
@Table(name = "reserva_servicio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaServicio {

    /** Identificador único del registro (PK). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Reserva en la que se consumió el servicio. */
    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    /** Servicio consumido. */
    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    /** Cantidad consumida del servicio. */
    private Integer cantidad;

    /** Fecha y hora en que se usó el servicio. */
    private LocalDateTime fechaUso;

    /** Subtotal generado por este consumo. */
    private BigDecimal subtotal;
}