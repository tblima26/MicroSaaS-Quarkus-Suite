package org.br.mineradora.repository;

import org.br.mineradora.entity.QuotationEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped  //tudo que é relacionado a framework, pode ser usado nessa classe
public class QuotationRepository implements PanacheRepository<QuotationEntity>{
    

    
}
