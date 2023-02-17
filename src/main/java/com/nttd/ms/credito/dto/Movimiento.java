package com.nttd.ms.credito.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Movimiento {

    private LocalDate fecha;

    private String descripcion;

    private Double monto;

}
