package org.br.mineradora.dto;


import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
@Jacksonized
public class ProposalDTO {
    private Long proposalID;
    private String customer;
    private BigDecimal priceTonne; 
}
