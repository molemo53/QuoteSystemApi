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
public class AddJob implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jobName;
    private String vehicle;
    private float price;
    private int jobDuration;

    private AddJob()
    {

    }

    public Long getId() {
        return id;
    }

    public String getJobName()
    {
        return jobName;
    }

    public String getVehicle()
    {
        return vehicle;
    }

    public float getPrice()
    {
        return price;
    }

    public int getJobDuration()
    {
        return jobDuration;
    }

    public AddJob(Builder builder)
    {
        id=builder.id;
        jobName=builder.jobName;
        vehicle=builder.vehicle;
        price=builder.price;
        jobDuration=builder.jobDuration;
    }

    public static class Builder{
        private Long id;
        private String jobName;
        private String vehicle;
        private float price;
        private int jobDuration;

        public Builder(String jobName)
        {
            this.jobName=jobName;
        }

        public Builder vehicle(String vehicle)
        {
            this.vehicle=vehicle;
            return  this;
        }

        public Builder price(float price)
        {
            this.price=price;
            return this;
        }

        public Builder jobDuration(int jobDuration)
        {
            this.jobDuration=jobDuration;
            return this;
        }

        public Builder copy(AddJob value)
        {
            this.id=value.getId();
            this.jobName=value.getJobName();
            this.vehicle=value.getVehicle();
            this.price=value.getPrice();
            this.jobDuration=value.getJobDuration();
            return this;
        }

        public AddJob build()
        {
            return  new AddJob(this);
        }

    }

    @Override
    public String toString() {
        return "AddJob{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", price=" + price +
                ", jobDuration=" + jobDuration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddJob)) return false;

        AddJob addJob = (AddJob) o;

        if (jobDuration != addJob.jobDuration) return false;
        if (Float.compare(addJob.price, price) != 0) return false;
        if (id != null ? !id.equals(addJob.id) : addJob.id != null) return false;
        if (jobName != null ? !jobName.equals(addJob.jobName) : addJob.jobName != null) return false;
        if (vehicle != null ? !vehicle.equals(addJob.vehicle) : addJob.vehicle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (jobName != null ? jobName.hashCode() : 0);
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + jobDuration;
        return result;
    }
}
