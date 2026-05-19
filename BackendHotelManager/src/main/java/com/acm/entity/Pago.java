package com.acm.entity;

import com.acm.entity.enums.EstadoPago;
import com.acm.entity.enums.MetodoPago;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    private LocalDateTime fechaPago;
    private String referencia;

    @Enumerated(EnumType.STRING)
    private EstadoPago estado;
}
