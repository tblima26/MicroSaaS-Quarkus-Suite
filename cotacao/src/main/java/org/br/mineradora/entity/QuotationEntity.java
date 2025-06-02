package org.br.mineradora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Entity // Essa classe vai representar uma entidade no banco
@Table(name = "quotation")
@Data
@NoArgsConstructor
public class QuotationEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Date date;

    @Column(name = "price")
    private BigDecimal price;
    
    @Column(name = "change")
    private String change;
    private String pair;
}
