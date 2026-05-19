package com.acm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidad que representa la factura generada por una reserva.
 *
 * <p>La factura se asocia a una reserva, un pago y un cliente.
 * Contiene los valores de subtotal, impuestos y total, además de
 * la fecha de emisión y el detalle del cobro.</p>
 */
@Entity
@Table(name = "facturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura {

    /** Identificador único de la factura (PK). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Número de factura único y secuencial. */
    @Column(unique = true)
    private String numeroFactura;

    /** Reserva asociada a la factura. */
    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    /** Pago asociado a la factura. */
    @ManyToOne
    @JoinColumn(name = "pago_id")
    private Pago pago;

    /** Cliente al que se emite la factura. */
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    /** Valor parcial antes de impuestos. */
    private BigDecimal subtotal;

    /** Valor de impuestos aplicados. */
    private BigDecimal impuestos;

    /** Total final de la factura. */
    private BigDecimal total;

    /** Fecha y hora en la que se genera la factura. */
    private LocalDateTime fechaEmision;

    /** Descripción o detalle del cobro. */
    private String detalle;
}