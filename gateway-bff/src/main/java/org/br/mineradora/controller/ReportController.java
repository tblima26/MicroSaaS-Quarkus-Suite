package org.br.mineradora.controller;

import org.br.mineradora.service.ReportService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/oportunity")
public class ReportController {
    @Inject
    ReportService reportService;

    @GET
    @Path("/report")
    @RolesAllowed({ "manager", "user" })
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response generateReport() {
        try {

            return Response.ok(reportService.generateCSVOpportunityReport(),
                    MediaType.APPLICATION_OCTET_STREAM)
                    .header("Content-Disposition", "attachment; filename=\"oportunidades-venda.csv\"")
                    .build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/data")
    @RolesAllowed({ "manager", "user" })
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response generateOpportunitiesData() {
        try {

            return Response.ok(reportService.getOpportunitiesData(),
                    MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
