package org.br.mineradora.service;

import org.br.mineradora.client.ProposalRestClient;
import org.br.mineradora.dto.ProposalDatailsDTO;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ProposalServiceImpl implements ProposalService {

    @Inject
    @RestClient
    ProposalRestClient proposalRestClient;

    @Override
    public ProposalDatailsDTO getProposalDatailsById(long proposalId) {
        return proposalRestClient.getProposalDatailsById(proposalId);
    }

    @Override
    public Response createProposal(ProposalDatailsDTO proposalDatails) {
        return proposalRestClient.createProposal(proposalDatails); 
    }

    @Override
    public Response removeProposal(long id) {     
        return proposalRestClient.removeProposal(id);
    }

}
