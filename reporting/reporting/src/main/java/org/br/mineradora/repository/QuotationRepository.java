package org.br.mineradora.repository;

import org.br.mineradora.entity.QuotationEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuotationRepository implements PanacheRepository<QuotationEntity> {

    // Additional methods for querying quotations can be added here
    // For example, methods to find quotations by date, customer, etc.
    
}
