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
public class MakeQuote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customer;
    private String vehicle;
    private float price;
    private String jobName;

    private  MakeQuote()
    {

    }

    public Long getId() {
        return id;
    }

    public String getCustomer()
    {
        return customer;
    }

    public String getVehicle()
    {
        return vehicle;
    }

    public float getPrice()
    {
        return  price;
    }

    public String getJobName()
    {
        return  jobName;
    }

    public MakeQuote(Builder builder)
    {
        id=builder.id;
        customer=builder.customer;
        vehicle=builder.vehicle;
        price=builder.price;
        jobName=builder.jobName;
    }

    public static class Builder{
        private Long id;
        private String customer;
        private String vehicle;
        private float price;
        private String jobName;

        public Builder(String customer)
        {
            this.customer=customer;
        }

        public Builder vehicle(String  vehicle)
        {
            this.vehicle=vehicle;
            return  this;
        }

        public Builder price(float price)
        {
            this.price=price;
            return  this;
        }

        public Builder jobName(String jobName)
        {
            this.jobName=jobName;
            return  this;
        }

        public Builder copy(MakeQuote value)
        {
            this.id=value.getId();
            this.customer=value.getCustomer();
            this.jobName=value.getJobName();
            this.price=value.getPrice();
            this.vehicle=value.getVehicle();
            return this;
        }

        public MakeQuote build()
        {
            return new MakeQuote(this);
        }

    }

    @Override
    public String toString() {
        return "MakeQuote{" +
                "id=" + id +
                ", customer='" + customer + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", price=" + price +
                ", jobName='" + jobName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MakeQuote)) return false;

        MakeQuote makeQuote = (MakeQuote) o;

        if (Float.compare(makeQuote.price, price) != 0) return false;
        if (customer != null ? !customer.equals(makeQuote.customer) : makeQuote.customer != null) return false;
        if (id != null ? !id.equals(makeQuote.id) : makeQuote.id != null) return false;
        if (jobName != null ? !jobName.equals(makeQuote.jobName) : makeQuote.jobName != null) return false;
        if (vehicle != null ? !vehicle.equals(makeQuote.vehicle) : makeQuote.vehicle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + (jobName != null ? jobName.hashCode() : 0);
        return result;
    }
}
