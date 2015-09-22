package za.ac.cput.QuoteSystem.factory;

import za.ac.cput.QuoteSystem.domain.Vehicle;

/**
 * Created by student on 2015/09/18.
 */
public class VehicleFactory {

    public static Vehicle createVehicle(String make, String model)
    {
        Vehicle vehicle = new Vehicle.Builder(make)
                .model(model)
                .build();

        return vehicle;

    }
}
