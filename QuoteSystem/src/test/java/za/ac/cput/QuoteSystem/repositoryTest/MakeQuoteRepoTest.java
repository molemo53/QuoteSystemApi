package za.ac.cput.QuoteSystem.repositoryTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.QuoteSystem.App;
import za.ac.cput.QuoteSystem.domain.MakeQuote;
import za.ac.cput.QuoteSystem.factory.MakeQuoteFactory;
import za.ac.cput.QuoteSystem.repository.MakeQuoteRepository;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/18.
 */
@SpringApplicationConfiguration(classes= {App.class})
@WebAppConfiguration
public class MakeQuoteRepoTest extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    MakeQuoteRepository repository;

    @Test
    public void create() throws Exception
    {
        List<MakeQuote> makeQuotes= new ArrayList<MakeQuote>();

        MakeQuote makeQuote = MakeQuoteFactory.createQuote("Kevin", "Polo",1000, "Brakes");

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
}

