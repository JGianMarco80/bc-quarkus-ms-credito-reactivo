package com.nttd.ms.credito.service.impl;

import com.nttd.ms.credito.client.PagoCreditoClient;
import com.nttd.ms.credito.client.model.PagoCredito;
import com.nttd.ms.credito.dto.CreditoMovimiento;
import com.nttd.ms.credito.dto.Movimiento;
import com.nttd.ms.credito.entity.Credito;
import com.nttd.ms.credito.repository.CreditoRepository;
import com.nttd.ms.credito.service.CreditoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CreditoServiceImpl implements CreditoService {

    @Inject
    CreditoRepository repository;

    @RestClient
    PagoCreditoClient pagoClient;

    @Override
    public CreditoMovimiento movimientoCredito(String numeroCredito) {
        //Trater todos lss creditos
        List<Credito> creditos = repository.listAll();

        //Filtrar las creditos activos
        List<Credito> creditosActivos = new ArrayList<>();

        //Crear un objeto de CreditoMovimiento que sera la respuesta
        CreditoMovimiento cObtenido = new CreditoMovimiento();

        //Recorremos la lista de creditos y filtamos por estado 1
        for (Credito c: creditos) {
            if (c.getEstado().equals("1")) {
                creditosActivos.add(c);
            }
        }

        //Recorremos la lista tarjetasActivas y obtenemos el objeto de TCreditoMovimiento filtrado por el numeroTarjeta
        for (Credito c: creditosActivos) {
            if (c.getNumeroCredito().equals(numeroCredito)) {
                List<PagoCredito> pgObtenidos = pagoClient.findByNumeroCuenta(c.getNumeroCredito(), "1");
                cObtenido.setId(c.getId().toString());
                cObtenido.setNumeroCredito(c.getNumeroCredito());
                cObtenido.setMontoTotal(c.getMontoTotal());
                cObtenido.setMontoPagado(c.getMontoPagado());
                cObtenido.setMontoPendiente(c.getMontoTotal() - c.getMontoPagado());
                cObtenido.setDeudaAtrasada(c.getDeudaAtrasada());
                cObtenido.setCuotasAPagar(c.getCuotasAPagar());
                cObtenido.setCuotasPagadas(c.getCuotasPagadas());
                cObtenido.setCuotasPendientes(c.getCuotasAPagar() - c.getCuotasPagadas());

                if ( !(pgObtenidos == null && pgObtenidos.size() == 0) ) {
                    for (PagoCredito pg: pgObtenidos) {
                        Movimiento m = new Movimiento();
                        m.setDescripcion(pg.getDescripcion());
                        m.setMonto(pg.getMonto());
                        m.setFecha(pg.getFecha());
                        cObtenido.getMovimientos().add(m);
                    }
                }
            }
        }

        return cObtenido;
    }


}
