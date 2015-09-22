package za.ac.cput.QuoteSystem.factory;

import za.ac.cput.QuoteSystem.domain.Customer;

/**
 * Created by student on 2015/09/18.
 */
public class CustomerFactory {

    public static Customer createCustomer( String firstName, String lastName, String cellnumber, String email, String homeAddress)
    {
        Customer customer = new Customer.Builder(firstName)
                .lastName(lastName)
                .cellnumber(cellnumber)
                .email(email)
                .homeAddress(homeAddress)
                .build();

        return customer;
    }
}
