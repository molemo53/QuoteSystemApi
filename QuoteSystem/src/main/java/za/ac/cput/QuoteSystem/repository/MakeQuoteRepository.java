package za.ac.cput.QuoteSystem.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.QuoteSystem.domain.MakeQuote;

/**
 * Created by student on 2015/09/18.
 */
public interface MakeQuoteRepository extends CrudRepository<MakeQuote, Long> {
}
