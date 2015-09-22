package za.ac.cput.QuoteSystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.QuoteSystem.domain.MakeQuote;
import za.ac.cput.QuoteSystem.services.MakeQuoteService;

import java.util.List;

/**
 * Created by student on 2015/09/22.
 */
@RestController
@RequestMapping("/api/**")
public class MakeQuoteHome {
    @Autowired
    private MakeQuoteService service;

    @RequestMapping(value = "/quotes/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MakeQuote>> listResponseEntity() {
        List<MakeQuote> makeQuotes = service.findAll();
        if(makeQuotes.isEmpty()){
            return new ResponseEntity<List<MakeQuote>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<MakeQuote>>(makeQuotes, HttpStatus.OK);
    }

    @RequestMapping(value = "/quotes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MakeQuote> getQuotes(@PathVariable("id") long id)
    {
        MakeQuote makeQuote = service.findById(id);
        if(makeQuote == null)
        {
            return new ResponseEntity<MakeQuote>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<MakeQuote>(makeQuote, HttpStatus.OK);
    }

    @RequestMapping(value = "/quotes/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createQuote(@RequestBody MakeQuote makeQuote, UriComponentsBuilder ucBuilder)
    {
        service.save(makeQuote);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/quotes/{id}").buildAndExpand(makeQuote.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/quotes/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MakeQuote> updateQuotes(@PathVariable("id") long id, @RequestBody MakeQuote newQuote)
    {
        service.update(newQuote);
        return new ResponseEntity<MakeQuote>(newQuote, HttpStatus.OK);
    }

    @RequestMapping(value = "/quotes/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<MakeQuote> deleteQuote(@PathVariable("id") long id)
    {
        MakeQuote makeQuote = service.findById(id);
        if (makeQuote == null) {
            System.out.println("Unable to delete. PackageProduct with id " + id + " not found");
            return new ResponseEntity<MakeQuote>(HttpStatus.NOT_FOUND);
        }

        service.delete(makeQuote);
        System.out.println("Deleted");
        return new ResponseEntity<MakeQuote>(HttpStatus.NO_CONTENT);

    }

}
