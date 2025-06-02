package org.br.mineradora.service;

import org.br.mineradora.dto.ProposalDatailsDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public interface ProposalService {
    ProposalDatailsDTO getProposalDatailsById(@PathParam("id") long proposalId);

    Response createProposal(ProposalDatailsDTO proposalDatails);

    Response removeProposal(long id);
}
