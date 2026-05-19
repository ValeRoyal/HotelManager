package com.acm.entity;

import com.acm.entity.enums.TipoServicio;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "servicios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoServicio tipo;

    private String descripcion;
    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    private Boolean activo = true;

    @OneToMany(mappedBy = "servicio")
    private List<ReservaServicio> reservas;
}