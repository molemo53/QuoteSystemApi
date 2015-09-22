package za.ac.cput.QuoteSystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/09/18.
 */
@Entity
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String make;
    private String model;


    private Vehicle()
    {

    }

    public Vehicle(Builder builder)
    {
        id=builder.id;
        make=builder.make;
        model=builder.model;

    }

    public Long getId() {
        return id;
    }

    public String getMake(){
        return make;
    }

    public String getModel() {
        return model;
    }



    public static class Builder {
        private Long id;
        private String make;
        private String model;


        public Builder(String make) {
            this.make = make;
        }

        public Builder make(String make){
            this.make=make;
            return this;
        }

        public Builder model(String value){
            this.model=value;
            return this;
        }



        public Builder copy(Vehicle value){
            this.id=value.getId();
            this.make=value.getMake();
            this.model=value.getModel();
            return this;
        }

        public Vehicle build()
        {
            return new Vehicle(this);
        }
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        if (id != null ? !id.equals(vehicle.id) : vehicle.id != null) return false;
        if (make != null ? !make.equals(vehicle.make) : vehicle.make != null) return false;
        if (model != null ? !model.equals(vehicle.model) : vehicle.model != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (make != null ? make.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }
}



