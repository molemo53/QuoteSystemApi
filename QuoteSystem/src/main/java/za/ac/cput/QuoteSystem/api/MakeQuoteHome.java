package za.ac.cput.QuoteSystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.QuoteSystem.domain.MakeQuote;
import za.ac.cput.QuoteSystem.model.MakeQuoteResource;
import za.ac.cput.QuoteSystem.services.MakeQuoteService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by student on 2015/09/22.
 */
@RestController
@RequestMapping("/quote/")
public class MakeQuoteHome {

    @Autowired
    private MakeQuoteService service;



    //-------------------Retrieve All Jobs--------------------------------------------------------
    @RequestMapping(value = "/quotes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MakeQuoteResource>> getAllQuotes() {

        List <MakeQuoteResource> quoteHatoes = new ArrayList<MakeQuoteResource>();
        List<MakeQuote> makeQuotes = service.findAll();


        if(makeQuotes.isEmpty()){
            return new ResponseEntity<List<MakeQuoteResource>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }

        for(MakeQuote quote: makeQuotes)
        {
            MakeQuoteResource makeQuoteTemp = new MakeQuoteResource
                    .Builder(quote.getCustomer())
                    .resId(quote.getId())
                    .jobName(quote.getJobName())
                    .price(quote.getPrice())
                    .vehicle(quote.getVehicle())
                    .build();

            //Link link = (new Link(linkTo(methodOn(MakeQuoteHome.class))
                //.slash(makeQuoteTemp.getResId()).toString()).withSelfRel());

            //makeQuoteTemp.add(link);
            //System.out.println(makeQuoteTemp.getId());


            quoteHatoes.add(makeQuoteTemp);

        }


        return new ResponseEntity<List<MakeQuoteResource>>(quoteHatoes, HttpStatus.OK);
    }

    //-------------------Retrieve Single Job--------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MakeQuoteResource> getQuotes(@PathVariable("id") long id)
    {
        MakeQuote makeQuote = service.findById(id);
        if(makeQuote == null)
        {
            return new ResponseEntity<MakeQuoteResource>(HttpStatus.NOT_FOUND);
        }

        MakeQuoteResource makeQuoteTemp = new MakeQuoteResource
                .Builder(makeQuote.getCustomer())
                .resId(makeQuote.getId())
                .jobName(makeQuote.getJobName())
                .price(makeQuote.getPrice())
                .vehicle(makeQuote.getVehicle())
                .build();

        Link link = (new Link(linkTo(methodOn(MakeQuoteHome.class)
                .getQuotes(makeQuoteTemp.getResId()))
                .toString()).withSelfRel());

        makeQuoteTemp.add(link);

        return new ResponseEntity<MakeQuoteResource>(makeQuoteTemp, HttpStatus.OK);
    }

    //-------------------Create a PackageProduct--------------------------------------------------------

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createQuote(@RequestBody MakeQuote makeQuote, UriComponentsBuilder ucBuilder)
    {
        service.save(makeQuote);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/quotes/{id}").buildAndExpand(makeQuote.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Subject --------------------------------------------------------

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MakeQuote> updateQuotes(@PathVariable("id") long id, @RequestBody MakeQuote newQuote)
    {
        HttpHeaders headers = new HttpHeaders();
        service.update(newQuote);
        return new ResponseEntity<MakeQuote>(headers, HttpStatus.OK);
    }

    //------------------- Delete a Job --------------------------------------------------------

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<MakeQuote> deleteQuote(@PathVariable("id") long id)
    {
        MakeQuote makeQuote = service.findById(id);
        if (makeQuote == null) {
            return new ResponseEntity<MakeQuote>(HttpStatus.NOT_FOUND);
        }

        service.delete(makeQuote);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<MakeQuote>(headers,HttpStatus.NO_CONTENT);

    }

}
