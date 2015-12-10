package za.ac.cput.QuoteSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.QuoteSystem.App;
import za.ac.cput.QuoteSystem.domain.MakeQuote;
import za.ac.cput.QuoteSystem.factory.MakeQuoteFactory;
import za.ac.cput.QuoteSystem.repository.MakeQuoteRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/21.
 */

@SpringApplicationConfiguration(classes= {App.class})
@WebAppConfiguration
public class MakeQuoteServiceTest extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    MakeQuoteRepository repository;

    @Test
    public void create() throws Exception
    {
        List<MakeQuote> makeQuotes= new ArrayList<MakeQuote>();

        MakeQuote makeQuote = MakeQuoteFactory.createQuote("Bontle", "Fiesta", 1000, "Oil");

        makeQuotes.add(makeQuote);

        this.repository.save(makeQuote);
        id = makeQuote.getId();
        Assert.assertNotNull(makeQuote.getId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        MakeQuote makeQuote = repository.findOne(id);

        Assert.assertNotNull(makeQuote);
    }


    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        MakeQuote makeQuote = repository.findOne(id);

        MakeQuote newQuote = new MakeQuote.Builder(makeQuote.getCustomer())
                .copy(makeQuote)
                .jobName("Oil")
                .build();

        repository.save(newQuote);
        MakeQuote updateQuote = repository.findOne(id);

        Assert.assertEquals("Oil", updateQuote.getJobName());
    }

/*
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete(id);

        MakeQuote makeQuote = repository.findOne(id);


        Assert.assertNull(makeQuote);
    }
    */
}
