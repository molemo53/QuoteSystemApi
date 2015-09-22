package za.ac.cput.QuoteSystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.QuoteSystem.domain.Vehicle;
import za.ac.cput.QuoteSystem.services.VehicleService;

import java.util.List;

/**
 * Created by student on 2015/09/22.
 */
@RestController
@RequestMapping("/api/**")
public class VehicleHome {

    @Autowired
    private VehicleService service;

    @RequestMapping(value = "/vehicle/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Vehicle>> listResponseEntity() {
        List<Vehicle> vehicles = service.findAll();
        if(vehicles.isEmpty()){
            return new ResponseEntity<List<Vehicle>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
    }

    @RequestMapping(value = "/vehicle/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") long id)
    {
        Vehicle vehicle= service.findById(id);
        if(vehicle == null)
        {
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
    }

    @RequestMapping(value = "/vehicle/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createVehicle(@RequestBody Vehicle vehicle, UriComponentsBuilder ucBuilder)
    {
        service.save(vehicle);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/vehicle/{id}").buildAndExpand(vehicle.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/vehicle/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") long id, @RequestBody Vehicle newVehicle)
    {
        service.update(newVehicle);
        return new ResponseEntity<Vehicle>(newVehicle, HttpStatus.OK);
    }

    @RequestMapping(value = "/vehicle/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable("id") long id)
    {
        Vehicle vehicle = service.findById(id);
        if (vehicle == null) {
            System.out.println("Unable to delete. PackageProduct with id " + id + " not found");
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
        }

        service.delete(vehicle);
        System.out.println("Deleted");
        return new ResponseEntity<Vehicle>(HttpStatus.NO_CONTENT);

    }
}
