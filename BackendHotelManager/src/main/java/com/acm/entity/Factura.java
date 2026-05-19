package com.acm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numeroFactura;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "pago_id")
    private Pago pago;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    private BigDecimal subtotal;
    private BigDecimal impuestos;
    private BigDecimal total;

    private LocalDateTime fechaEmision;
    private String detalle;
}