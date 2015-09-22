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
public class Customer implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String firstName;
        private String lastName;
        private String cellnumber;
        private String email;
        private String homeAddress;

        private Customer ()
        {

        }
        public Long getId() {
            return id;
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

        public Customer(Builder builder){
            id=builder.id;
            firstName=builder.firstName;
            lastName=builder.lastName;
            cellnumber=builder.cellnumber;
            email=builder.email;
            homeAddress=builder.homeAddress;

        }

        public static class Builder{
            private Long id;
            private String firstName;
            private String lastName;
            private String cellnumber;
            private String email;
            private String homeAddress;



            public Builder(String firstName) {
                this.firstName = firstName;
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

            public Builder copy(Customer value){
                this.id=value.getId();
                this.firstName=value.getFirstName();
                this.lastName=value.getLastName();
                this.cellnumber=value.getCellnumber();
                this.email=value.getEmail();
                this.homeAddress=value.getHomeAddress();
                return this;
            }

            public Customer build(){
                return new Customer(this);
            }
        }


        @Override
        public String toString() {
            return "Customer{" +
                    "email='" + email + '\'' +
                    ", homeAddress='" + homeAddress + '\'' +
                    ", cellnumber='" + cellnumber + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", id=" + id +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Customer)) return false;

            Customer customer = (Customer) o;

            if (!cellnumber.equals(customer.cellnumber)) return false;
            if (!email.equals(customer.email)) return false;
            if (!firstName.equals(customer.firstName)) return false;
            if (!homeAddress.equals(customer.homeAddress)) return false;
            if (!id.equals(customer.id)) return false;
            if (!lastName.equals(customer.lastName)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = id.hashCode();
            result = 31 * result + firstName.hashCode();
            result = 31 * result + lastName.hashCode();
            result = 31 * result + cellnumber.hashCode();
            result = 31 * result + email.hashCode();
            result = 31 * result + homeAddress.hashCode();
            return result;
        }
    }


