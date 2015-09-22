package za.ac.cput.QuoteSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.QuoteSystem.App;
import za.ac.cput.QuoteSystem.domain.Employee;
import za.ac.cput.QuoteSystem.factory.EmployeeFactory;
import za.ac.cput.QuoteSystem.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/21.
 */
@SpringApplicationConfiguration(classes= {App.class})
@WebAppConfiguration
public class EmployeeServiceTest extends AbstractTestNGSpringContextTests {


    private Long id;
    @Autowired
    EmployeeRepository repository;

    @Test
    public void create() throws Exception
    {
        List<Employee> employees = new ArrayList<Employee>();

        Employee employee = EmployeeFactory.createEmployee("Dev", "Molemo", "Tseleng");

        employees.add(employee);

        this.repository.save(employee);
        id=employee.getId();
        Assert.assertNotNull(employee.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Employee employee = repository.findOne(id);

        Assert.assertNotNull(employee);
    }


    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Employee employee = repository.findOne(id);

        Employee newemployee = new Employee.Builder(employee.getJobId())
                .copy(employee)
                .firstName("Phelang")
                .lastName("Qhu")
                .build();

        repository.save(newemployee);
        Employee updateEmployee = repository.findOne(id);

        Assert.assertEquals("Dev", employee.getJobId());
        Assert.assertEquals("Qhu", updateEmployee.getLastName());


    }
}
