package za.ac.cput.QuoteSystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.QuoteSystem.domain.AddJob;
import za.ac.cput.QuoteSystem.model.AddJobResource;
import za.ac.cput.QuoteSystem.services.AddJobService;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/21.
 */
@RestController
@RequestMapping(value = "/addJob")
public class AddJobHome {

    @Autowired
    private AddJobService service;



    @RequestMapping(value="/job/", method= RequestMethod.GET)
    public List<AddJobResource> getAddJobs()
    {
        List<AddJobResource> hateos = new ArrayList<AddJobResource>();

        List<AddJob> addJobs = service.findAll();
        AddJobResource res;
        Link jobs;
        for(AddJob addJob: addJobs)
        {
             res = new AddJobResource.Builder(addJob.getJobName())
                    .resid(addJob.getId())
                    .vehicle(addJob.getVehicle())
                    .price(addJob.getPrice())
                    .jobDuration(addJob.getJobDuration())
                    .build();

            /*jobs = new Link ("http://localhost:8080/addJob/"+res.getResid().toString())
                    .withRel("job");
           */

            jobs = (new

                    // create a link to this method on
                    Link(
                    linkTo(methodOn(AddJobHome.class).getAddJobs())
                            .slash(res.getResid()).toString()).withSelfRel()
            );
            res.add(jobs);
            hateos.add(res);

        }

       return hateos;
    }
}
