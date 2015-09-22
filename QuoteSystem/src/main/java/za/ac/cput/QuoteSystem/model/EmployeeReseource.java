package za.ac.cput.QuoteSystem.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/09/18.
 */
public class EmployeeReseource extends ResourceSupport {
    private Long resId;
    private String jobId;
    private String firstName;
    private String lastName;

    private EmployeeReseource()
    {

    }

    public String getJobId()
    {
        return  jobId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getResId() {
        return resId;
    }

    public EmployeeReseource(Builder builder)
    {
        resId= builder.resId;
        firstName=builder.firstName;
        lastName=builder.lastName;
        jobId=builder.jobId;
    }

    public static class Builder{
        private Long resId;
        private String jobId;
        private String firstName;
        private String lastName;



        public Builder(String jobId) {
            this.jobId=jobId;
        }

        public Builder resId(Long resId) {
            this.resId = resId;
            return this;
        }

        public Builder firstName(String value){
            this.firstName=value;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName=lastName;
            return this;
        }

        public Builder copy(EmployeeReseource value){
            this.resId=value.getResId();
            this.jobId=value.getJobId();
            this.firstName=value.getFirstName();
            this.lastName=value.getLastName();
            return this;
        }

        public EmployeeReseource build(){
            return new EmployeeReseource(this);
        }
    }

}
