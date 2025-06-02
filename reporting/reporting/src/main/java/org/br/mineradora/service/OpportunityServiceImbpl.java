package org.br.mineradora.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.br.mineradora.dto.OpportunityDTO;
import org.br.mineradora.dto.ProposalDTO;
import org.br.mineradora.dto.QuotationDTO;
import org.br.mineradora.entity.OpportunityEntity;
import org.br.mineradora.entity.QuotationEntity;
import org.br.mineradora.repository.OpportunityRepository;
import org.br.mineradora.repository.QuotationRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OpportunityServiceImbpl implements OpportunityService {

    @Inject
    QuotationRepository quotationRepository;

    @Inject
    OpportunityRepository opportunityRepository;

    @Override
    public void buildOpportunity(ProposalDTO proposal) {
        List<QuotationEntity> quotationEntities = quotationRepository.findAll().list();
        Collections.reverse(quotationEntities);

        OpportunityEntity opportunity = new OpportunityEntity();
        opportunity.setDate(new Date());
        opportunity.setProposalId(proposal.getProposalId());
        opportunity.setCustomer(proposal.getCustomer());
        opportunity.setPriceTonne(proposal.getPriceTonne());
        opportunity.setLastCurrencyQuotation(quotationEntities.get(0).getCurrencyPrice());

        opportunityRepository.persist(opportunity);
    }

    @Override
    public void saveQuotation(QuotationDTO quotation) {
        QuotationEntity createQuotation = new QuotationEntity();
        createQuotation.setCurrencyPrice(quotation.getCurrencyPrice());
        createQuotation.setDate(new Date());
        quotationRepository.persist(createQuotation);
    }

    @Override
    public List<OpportunityDTO> generateOpportunityData() {
        List<OpportunityDTO> opportunities = new ArrayList<>();

        opportunityRepository.findAll().stream().forEach(item -> {
            opportunities.add(OpportunityDTO.builder()
                    .proposalId(item.getProposalId())
                    .customer(item.getCustomer())
                    .priceTonne(item.getPriceTonne())
                    .lastDollarQuotation(item.getLastCurrencyQuotation())
                    .build());
        });

        return opportunities;
    }

    // @Override
    // public ByteArrayInputStream generateCSVOpportunityReport() {
    //     List<OpportunityDTO> opportunityList = new ArrayList<>();
    //     opportunityRepository.findAll().list().forEach(item -> {
    //         opportunityList.add(OpportunityDTO.builder()
    //                 .proposalId(item.getProposalId())
    //                 .customer(item.getCustomer())
    //                 .priceTonne(item.getPriceTonne())
    //                 .lastDollarQuotation(item.getLastCurrencyQuotation())
    //                 .build());
    //     });

    //     return CSVHelper.OpportunitiesToCSV(opportunityList); // Replace with actual implementation
    // }

}
