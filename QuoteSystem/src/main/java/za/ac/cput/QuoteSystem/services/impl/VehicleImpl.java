package za.ac.cput.QuoteSystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.QuoteSystem.domain.Vehicle;
import za.ac.cput.QuoteSystem.repository.VehicleRepository;
import za.ac.cput.QuoteSystem.services.VehicleService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/18.
 */
@Service
public class VehicleImpl implements VehicleService {
    @Autowired
    private VehicleRepository repository;

    @Override
    public Vehicle findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Vehicle save(Vehicle entity) {
        return repository.save(entity);
    }

    @Override
    public Vehicle update(Vehicle entity) {
        return repository.save(entity);

    }

    @Override
    public void delete(Vehicle entity) {
        repository.delete(entity);
    }

    @Override
    public List<Vehicle> findAll() {
        List<Vehicle> vehicles= new ArrayList<Vehicle>();
        Iterable<Vehicle> values = repository.findAll();

        for(Vehicle value: values ){
            vehicles.add(value);
        }
        return vehicles;
    }
}
