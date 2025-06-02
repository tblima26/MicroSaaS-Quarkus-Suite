package org.br.mineradora.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized //facilita com uso do Json
@Data
@Builder
@AllArgsConstructor
public class CurrencyPriceDTO {
    public USDBRL usdbrl;
}
