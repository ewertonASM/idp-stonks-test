package br.com.inatel.stonks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.annotations.SerializedName;

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
    
    // @ElementCollection
    // @CollectionTable(name="STOCK_QUOTES", 
    //   joinColumns = {@JoinColumn(name = "STOCK_QUOTE_TEST_ID")})
    // @MapKeyColumn(name = "QUOTE_DATE")
    // @Column(name = "QUOTE_VALUE")
    // private Map<String, String> quotes;

    private String date;

    private String value;

    @ManyToOne
    // @JoinColumn(name = "STOCK_QUOTE_TEST_ID")
    // @JsonBackReference
    // @JsonManagedReference

    private StockQuoteTest stockQuoteTest;
    
}
