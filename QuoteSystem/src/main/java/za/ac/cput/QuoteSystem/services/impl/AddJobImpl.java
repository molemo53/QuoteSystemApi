package za.ac.cput.QuoteSystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.QuoteSystem.domain.AddJob;
import za.ac.cput.QuoteSystem.repository.AddJobRepository;
import za.ac.cput.QuoteSystem.services.AddJobService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/18.
 */
@Service
public class AddJobImpl implements AddJobService {

    @Autowired
    private AddJobRepository repository;

    @Override
    public AddJob findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public AddJob  save(AddJob entity) {
        return repository.save(entity);
    }

    @Override
    public AddJob  update(AddJob  entity) {
        return repository.save(entity);

    }

    @Override
    public void delete(AddJob entity) {
        repository.delete(entity);
    }

    @Override
    public List<AddJob > findAll() {
        List<AddJob > addJobs= new ArrayList<AddJob >();
        Iterable<AddJob> values= repository.findAll();


        for(AddJob  value: values ){
            addJobs.add(value);
        }
        return addJobs;
    }
}
