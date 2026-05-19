package com.acm.entity;

import com.acm.entity.enums.TipoServicio;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Entidad que representa un servicio ofrecido por un hotel.
 *
 * <p>Ejemplos: desayuno, lavandería, transporte, spa, etc.
 * Puede ser consumido por múltiples reservas.</p>
 */
@Entity
@Table(name = "servicios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servicio {

    /** Identificador único del servicio (PK). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre del servicio. */
    private String nombre;

    /** Tipo de servicio (ej. RESTAURANTE, SPA, TRANSPORTE). */
    @Enumerated(EnumType.STRING)
    private TipoServicio tipo;

    /** Descripción breve del servicio. */
    private String descripcion;

    /** Precio del servicio. */
    private BigDecimal precio;

    /** Hotel al que pertenece el servicio. */
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    /** Indica si el servicio está activo. */
    private Boolean activo = true;

    /** Reservas en las que se ha utilizado este servicio. */
    @OneToMany(mappedBy = "servicio")
    private List<ReservaServicio> reservas;
}