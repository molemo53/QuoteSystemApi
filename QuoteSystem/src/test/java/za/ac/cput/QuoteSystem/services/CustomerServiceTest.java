package za.ac.cput.QuoteSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.QuoteSystem.App;
import za.ac.cput.QuoteSystem.domain.Customer;
import za.ac.cput.QuoteSystem.factory.CustomerFactory;
import za.ac.cput.QuoteSystem.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/21.
 */
@SpringApplicationConfiguration(classes= {App.class})
@WebAppConfiguration
public class CustomerServiceTest extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    CustomerRepository repository;

    @Test
    public void create() throws Exception
    {
        List<Customer> customers = new ArrayList<Customer>();


        Customer customer = CustomerFactory.createCustomer("Bontle", "Tseleng", "0837311339", "Bontle53", "CapeTown");

        customers.add(customer);

        this.repository.save(customer);
        id=customer.getId();
        Assert.assertNotNull(customer.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Customer customer = repository.findOne(id);
        Assert.assertNotNull(customer);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Customer customer = repository.findOne(id);

        Customer newcustomer = new Customer.Builder(customer.getFirstName())
                .copy(customer)
                .lastName("Moore")
                .cellnumber("0836473343")
                .email("B989")
                .homeAddress("Pretoria")
                .build();

        repository.save(newcustomer);
        Customer updateCustomer = repository.findOne(id);

        Assert.assertEquals("Bontle", customer.getFirstName());
        Assert.assertEquals("Moore", updateCustomer.getLastName());
    }
}
