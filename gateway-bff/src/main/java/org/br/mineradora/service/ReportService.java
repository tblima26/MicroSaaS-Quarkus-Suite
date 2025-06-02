package org.br.mineradora.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.br.mineradora.dto.OpportunityDTO;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ReportService {
    ByteArrayInputStream generateCSVOpportunityReport();

    List<OpportunityDTO> getOpportunitiesData();
}
