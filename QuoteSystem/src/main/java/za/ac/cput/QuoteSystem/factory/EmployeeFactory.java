package za.ac.cput.QuoteSystem.factory;


import za.ac.cput.QuoteSystem.domain.Employee;

/**
 * Created by student on 2015/09/18.
 */
public class EmployeeFactory {

    public static Employee createEmployee( String jobId, String firstName, String lastName)
    {

        Employee employee = new Employee.Builder(jobId)
                .firstName(firstName)
                .lastName(lastName)
                .build();

        return  employee;
    }
}
