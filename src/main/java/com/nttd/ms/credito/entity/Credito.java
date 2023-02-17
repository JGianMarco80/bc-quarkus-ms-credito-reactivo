package com.nttd.ms.credito.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDate;

@MongoEntity(collection = "credito")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credito {

    private ObjectId id;

    private String numeroCredito;

    private LocalDate fechaInicio;

    private String fechaPago;

    private Double montoTotal;

    private Double montoPagado;

    private Double deudaAtrasada;

    private Integer cuotasAPagar;

    private Integer cuotasPagadas;

    private String estado = "1";

}
