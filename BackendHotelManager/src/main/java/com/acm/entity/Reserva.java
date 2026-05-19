package com.acm.entity;

import com.acm.entity.enums.EstadoReserva;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reservas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "habitacion_id")
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Usuario empleado;

    private LocalDate fechaCheckIn;
    private LocalDate fechaCheckOut;
    private Integer numeroHuespedes;

    private BigDecimal precioTotal;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    private String observaciones;
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @OneToMany(mappedBy = "reserva")
    private List<Pago> pagos;

    @OneToMany(mappedBy = "reserva")
    private List<Factura> facturas;

    @OneToMany(mappedBy = "reserva")
    private List<ReservaServicio> servicios;
}
