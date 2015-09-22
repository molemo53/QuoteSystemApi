package za.ac.cput.QuoteSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.QuoteSystem.App;
import za.ac.cput.QuoteSystem.domain.AddJob;
import za.ac.cput.QuoteSystem.factory.AddJobFactory;
import za.ac.cput.QuoteSystem.repository.AddJobRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/21.
 */
@SpringApplicationConfiguration(classes= {App.class})
@WebAppConfiguration
public class AddJobServiceTest extends AbstractTestNGSpringContextTests {


    private Long id;
    @Autowired
    private AddJobRepository repository;

    private AddJobService service;

    @Test
    public void create() throws Exception
    {
        List <AddJob> addJobs = new ArrayList<AddJob>();

        AddJob addJob = AddJobFactory.createAddJob("Brakes", "Audi", 5000, 2);

        addJobs.add(addJob);

        this.repository.save(addJob);
        id=addJob.getId();
        Assert.assertNotNull(addJob.getId());
    }


    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {

        AddJob addJob = repository.findOne(id);
        Assert.assertNotNull(addJob);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        AddJob addJob = repository.findOne(id);

        AddJob newAddJob = new AddJob.Builder(addJob.getJobName())
                .copy(addJob)
                .vehicle("Vw")
                .price(1500)
                .build();

        repository.save(newAddJob);

        AddJob updateJOb = repository.findOne(id);

        Assert.assertEquals("Audi", addJob.getVehicle());
        Assert.assertEquals("Vw", newAddJob.getVehicle());
    }



}
