package br.com.inatel.stonks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class QuotesTest {
    
    @Id
    @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
    private String id;
    
    @ElementCollection
    // @CollectionTable(name="QUOTES", 
    //   joinColumns = {@JoinColumn(name = "STOCK_QUOTE_ID", referencedColumnName = "STOCK_QUOTE_ID")})
    @MapKeyColumn(name = "QUOTE_DATE")
    @Column(name = "QUOTE_VALUE")
    private Map<String, String> quotes;

    @ManyToOne
    private StockQuoteTest stockQuoteTest;
    
}
