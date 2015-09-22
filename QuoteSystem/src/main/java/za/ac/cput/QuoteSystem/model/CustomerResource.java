package za.ac.cput.QuoteSystem.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/09/18.
 */
public class CustomerResource extends ResourceSupport {

    private Long resid;
    private String firstName;
    private String lastName;
    private String cellnumber;
    private String email;
    private String homeAddress;

    public Long getResid() {
        return resid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCellnumber() {return cellnumber;}

    public String getEmail() {return email;}

    public String getHomeAddress() {return homeAddress;}

    private  CustomerResource()
    {

    }

    public  CustomerResource (Builder builder)
    {
        resid=builder.resid;
        firstName=builder.firstName;
        lastName=builder.lastName;
        cellnumber=builder.cellnumber;
        email=builder.email;
        homeAddress=builder.homeAddress;
    }

    public static class Builder{

        private Long resid;
        private String firstName;
        private String lastName;
        private String cellnumber;
        private String email;
        private String homeAddress;

        public Builder(String firstName) {
            this.firstName = firstName;
        }

        public Builder resid(Long resid) {
            this.resid = resid;
            return this;
        }

        public Builder lastName(String value){
            this.lastName=value;
            return this;
        }

        public Builder cellnumber(String cellnumber)
        {
            this.cellnumber=cellnumber;
            return this;
        }

        public Builder email(String email)
        {
            this.email=email;
            return  this;
        }

        public Builder homeAddress(String homeAddress)
        {
            this.homeAddress=homeAddress;
            return this;
        }

        public Builder copy(CustomerResource value){
            this.resid=value.getResid();
            this.firstName=value.getFirstName();
            this.lastName=value.getLastName();
            this.cellnumber=value.getCellnumber();
            this.email=value.getEmail();
            this.homeAddress=value.getHomeAddress();
            return this;
        }

        public CustomerResource build(){
            return new CustomerResource(this);
        }

    }

}
