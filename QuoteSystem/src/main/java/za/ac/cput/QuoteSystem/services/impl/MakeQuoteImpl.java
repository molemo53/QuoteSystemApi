package za.ac.cput.QuoteSystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.QuoteSystem.domain.MakeQuote;
import za.ac.cput.QuoteSystem.repository.MakeQuoteRepository;
import za.ac.cput.QuoteSystem.services.MakeQuoteService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/18.
 */
@Service
public class MakeQuoteImpl implements MakeQuoteService {
    @Autowired
    private MakeQuoteRepository repository;

    @Override
    public MakeQuote findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public MakeQuote save(MakeQuote entity) {
        return repository.save(entity);
    }

    @Override
    public MakeQuote update(MakeQuote entity) {
        return repository.save(entity);

    }

    @Override
    public void delete(MakeQuote entity) {
        repository.delete(entity);
    }

    @Override
    public List<MakeQuote> findAll() {
        List<MakeQuote> makeQuotes= new ArrayList<MakeQuote>();
        Iterable<MakeQuote> values = repository.findAll();

        for(MakeQuote value: values ){
            makeQuotes.add(value);
        }
        return makeQuotes;
    }
}
