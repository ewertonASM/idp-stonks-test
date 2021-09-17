package br.com.inatel.stonks.view;

import java.util.HashMap;
import java.util.List;

import br.com.inatel.stonks.model.Quote;

public class QuoteView {

    public static HashMap<String, HashMap<String, String>> generateView(List<Quote> quotes){

        HashMap<String, HashMap<String, String>> mapView = new HashMap<String, HashMap<String, String>>();

        for(Quote quote:quotes){

            if(!mapView.containsKey(quote.getStockId())) {
                mapView.put(quote.getStockId(), new HashMap<String, String>());
            }

            mapView.get(quote.getStockId()).put(quote.getDate(), quote.getQuote());

        }

        return mapView;

    }
    
}
