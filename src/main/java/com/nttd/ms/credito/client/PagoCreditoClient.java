package com.nttd.ms.credito.client;

import com.nttd.ms.credito.client.model.PagoCredito;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import java.util.List;

@RegisterRestClient
@Path("/pago-credito")
public interface PagoCreditoClient {

    @GET
    List<PagoCredito> findByNumeroCuenta(@QueryParam("numeroCuenta") String numeroCuenta,
                                         @QueryParam("tipoPago") String tipoPago);

}
