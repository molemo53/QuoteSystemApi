package za.ac.cput.QuoteSystem.repositoryTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.QuoteSystem.App;
import za.ac.cput.QuoteSystem.domain.Vehicle;
import za.ac.cput.QuoteSystem.factory.VehicleFactory;
import za.ac.cput.QuoteSystem.repository.VehicleRepository;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/18.
 */

@SpringApplicationConfiguration(classes= {App.class})
@WebAppConfiguration
public class VehicleRepoTest extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    VehicleRepository repository;

    @Test
    public void create() throws Exception
    {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();

        Vehicle vehicle = VehicleFactory.createVehicle("Ford", "FiestaSt");

        vehicles.add(vehicle);

        this.repository.save(vehicle);
        id= vehicle.getId();
        Assert.assertNotNull(vehicle.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Vehicle vehicle = repository.findOne(id);
        Assert.assertNotNull(vehicle);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Vehicle vehicle = repository.findOne(id);

        Vehicle newVehicle = new Vehicle.Builder(vehicle.getMake())
                .copy(vehicle)
                .model("FocusSt")
                .build();

        repository.save(newVehicle);
        Vehicle updateVehicle = repository.findOne(id);

        Assert.assertEquals("FiestaSt", vehicle.getModel());
        Assert.assertEquals("FocusSt", updateVehicle.getModel());
    }
}
