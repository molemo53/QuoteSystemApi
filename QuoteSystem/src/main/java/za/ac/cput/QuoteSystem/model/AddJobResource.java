package za.ac.cput.QuoteSystem.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/09/18.
 */
public class AddJobResource extends ResourceSupport{

    private Long resid;
    private String jobName;
    private String vehicle;
    private float price;
    private int jobDuration;

    private  AddJobResource()
    {

    }

    public Long getResid()
    {
        return  resid;
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

    public AddJobResource(Builder builder) {
        resid = builder.resid;
        jobName=builder.jobName;
        vehicle=builder.vehicle;
        price=builder.price;
        jobDuration=builder.jobDuration;

    }
    public static class Builder{
        private Long resid;
        private String jobName;
        private String vehicle;
        private float price;
        private int jobDuration;

        public  Builder(String jobName)
        {
            this.jobName=jobName;
        }

        public Builder vehicle(String vehicle)
        {
            this.vehicle=vehicle;
            return  this;
        }

        public Builder resid(Long resid){
            this.resid = resid;
            return this;
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

        public Builder copy(AddJobResource value)
        {
            this.resid= value.getResid();
            this.jobName=value.getJobName();
            this.vehicle=value.getVehicle();
            this.price=value.getPrice();
            this.jobDuration=value.getJobDuration();
            return  this;
        }

        public AddJobResource build()
        {
            return  new AddJobResource(this);
        }
    }
}
