package org.br.mineradora.controller;

import java.util.List;

import org.br.mineradora.dto.OpportunityDTO;
import org.br.mineradora.service.OpportunityService;
import org.eclipse.microprofile.jwt.JsonWebToken;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api/opportunity")
@Authenticated
public class OpportunityController {
    @Inject
    JsonWebToken token;

    @Inject
    OpportunityService opportunityService;
    // Não sera mais utilizado o endpoint abaixo:
    
    // @GET
    // @Path("/report")
    // @Produces(MediaType.APPLICATION_OCTET_STREAM)
    // public Response generateReport(){
    //     try {
    //         return Response.ok(opportunityService.generateCSVOpportunityReport())
    //             .header("content-disposition", "attachment;"+new Date()+"filename = opportunity_report.csv")
    //             .build();
    //     } catch (Exception e) {
    //         return Response.serverError().build();
    //     }
    // }

    @GET
    @Path("/data")
    @RolesAllowed({"user","manager"})
    public List<OpportunityDTO> generateReport() {
        return opportunityService.generateOpportunityData();
        
    }
}
