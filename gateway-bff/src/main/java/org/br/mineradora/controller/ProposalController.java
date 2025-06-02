package org.br.mineradora.controller;

import org.br.mineradora.dto.ProposalDatailsDTO;
import org.br.mineradora.service.ProposalService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/trade")
public class ProposalController {
    @Inject
    ProposalService proposalService;

    @GET
    @Path("/{id}")
    @RolesAllowed({ "manager", "user" })
    public Response getProposalDatailsById(@PathParam("id") long proposalId) {
        try {
            return Response.ok(
                    proposalService.getProposalDatailsById(proposalId),
                    MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @POST
    @RolesAllowed("proposal-customer")
    public Response createNewProposal(ProposalDatailsDTO proposalDatails) {
        int proposalRequestStatus = proposalService.createProposal(proposalDatails).getStatus();
        if(proposalRequestStatus > 199 || proposalRequestStatus <205) {
            return Response.ok().build();
        } else {
            return Response.status(proposalRequestStatus).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("manager")
    public Response removeProposal(@PathParam("id") long id) {
        int proposalRequestStatus = proposalService.removeProposal(id).getStatus();
        if(proposalRequestStatus > 199 || proposalRequestStatus <205) {
            return Response.ok().build();
        } else {
            return Response.status(proposalRequestStatus).build();
        }
    }
}
