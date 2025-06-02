package org.br.mineradora.client;

import org.br.mineradora.dto.ProposalDatailsDTO;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.token.propagation.reactive.AccessTokenRequestReactiveFilter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/api/proposal")
@RegisterRestClient
@RegisterProvider(AccessTokenRequestReactiveFilter.class)
@ApplicationScoped
public interface ProposalRestClient {
    @GET
    @Path("/{id}")
    ProposalDatailsDTO getProposalDatailsById(@PathParam("id") long proposalId);

    @POST
    Response createProposal(ProposalDatailsDTO proposalDatails);

    @DELETE
    @Path("/{id}")
    Response removeProposal(@PathParam("id") long id);
}
