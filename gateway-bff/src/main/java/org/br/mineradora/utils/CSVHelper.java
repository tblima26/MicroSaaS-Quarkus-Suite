package org.br.mineradora.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.br.mineradora.dto.OpportunityDTO;

public class CSVHelper {
    public static ByteArrayInputStream OpportunitiesToCSV(List<OpportunityDTO> opportunities) {
        final CSVFormat format = CSVFormat.DEFAULT.builder()
        .setHeader("ID Proposta", "Cliente", "Preço por Tonelada", "Melhor cotação em Dólar")
        .setRecordSeparator("\n")
        .build();

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try (CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(out), format)) {
            for (OpportunityDTO opp : opportunities) {
                List<String> data = Arrays.asList(
                        String.valueOf(opp.getProposalId()),
                        opp.getCustomer(),
                        String.valueOf(opp.getPricePerTon()),
                        String.valueOf(opp.getLastDollarQuotation()));
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
