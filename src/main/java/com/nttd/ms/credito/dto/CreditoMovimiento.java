package com.nttd.ms.credito.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreditoMovimiento {

    private String id;

    private String numeroCredito;

    private Double montoTotal;

    private Double montoPagado;

    private Double montoPendiente;

    private Double deudaAtrasada;

    private Integer cuotasAPagar;

    private Integer cuotasPagadas;

    private Integer cuotasPendientes;

    //Movimientos
    private List<Movimiento> movimientos = new ArrayList<>();

}
