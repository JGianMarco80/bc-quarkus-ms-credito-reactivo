package com.nttd.ms.credito.repository;

import com.nttd.ms.credito.entity.Credito;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreditoRepository implements PanacheMongoRepository<Credito> {
}
