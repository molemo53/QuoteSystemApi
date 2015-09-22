package za.ac.cput.QuoteSystem.factory;

import za.ac.cput.QuoteSystem.domain.AddJob;

/**
 * Created by student on 2015/09/18.
 */
public class AddJobFactory {

    public static AddJob createAddJob(String jobName, String vehicle, float price, int jobDuration)
    {

        AddJob addJob = new AddJob.Builder(jobName)
                .vehicle(vehicle)
                .price(price)
                .jobDuration(jobDuration)
                .build();

                return  addJob;
    }
}
