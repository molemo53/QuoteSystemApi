package za.ac.cput.QuoteSystem.factory;

import za.ac.cput.QuoteSystem.domain.MakeQuote;

/**
 * Created by student on 2015/09/18.
 */
public class MakeQuoteFactory {

    public static MakeQuote createQuote( String customer, String vehicle, float price, String jobName)
    {
        MakeQuote makeQuote = new MakeQuote.Builder(customer)
                .vehicle(vehicle)
                .price(price)
                .jobName(jobName)
                .build();

        return  makeQuote;
    }
}
