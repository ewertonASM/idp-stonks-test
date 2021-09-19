package br.com.inatel.stonks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.annotations.SerializedName;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
// @DynamicUpdate
public class StockQuoteTest {

    @Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
    private String id;
    
    @Column(unique = true)
    private String stockId;

    // @ElementCollection
    // @CollectionTable(name="STOCK_QUOTES", 
    //   joinColumns = {@JoinColumn(name = "STOCK_QUOTE_TEST_ID")})
    // @JoinColumn(name = "STOCK_QUOTE_TEST_ID", referencedColumnName = "ID")
    // @JsonBackReference
    // @JoinColumn(name = "STOCK_QUOTE_TEST_ID")
    @OneToMany
    // @JoinColumn(name = "STOCK_QUOTE_TEST_ID")
    private List<QuotesTest> quotesTest;


}
