package com.acm.entity;

import com.acm.entity.enums.EstadoPago;
import com.acm.entity.enums.MetodoPago;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidad que representa un pago asociado a una reserva.
 *
 * <p>Registra el monto, método, fecha, referencia y estado del pago.</p>
 */
@Entity
@Table(name = "pagos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    /** Identificador único del pago (PK). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Reserva a la cual pertenece el pago. */
    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    /** Monto pagado. */
    private BigDecimal monto;

    /** Método de pago utilizado. */
    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    /** Fecha y hora en la que se realizó el pago. */
    private LocalDateTime fechaPago;

    /** Referencia o código del pago. */
    private String referencia;

    /** Estado actual del pago. */
    @Enumerated(EnumType.STRING)
    private EstadoPago estado;
}