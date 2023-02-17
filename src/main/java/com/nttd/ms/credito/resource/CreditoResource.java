package com.nttd.ms.credito.resource;

import com.nttd.ms.credito.dto.CreditoMovimiento;
import com.nttd.ms.credito.service.CreditoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/credito")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreditoResource {

    @Inject
    CreditoService creditoService;

    @GET
    @Path("/movimiento-credito")
    public CreditoMovimiento movimientoCredito(@QueryParam("numeroCredito") String numeroCredito) {
        return creditoService.movimientoCredito(numeroCredito);
    }
}
