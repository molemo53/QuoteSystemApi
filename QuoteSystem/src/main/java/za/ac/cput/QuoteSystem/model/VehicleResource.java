package za.ac.cput.QuoteSystem.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/09/18.
 */
public class VehicleResource extends ResourceSupport {

    private Long resId;
    private String make;
    private String model;


    private VehicleResource()
    {

    }

    public VehicleResource(Builder builder)
    {
        resId=builder.resId;
        make=builder.make;
        model=builder.model;

    }

    public Long getResId() {
        return resId;
    }

    public String getMake(){
        return make;
    }

    public String getModel() {
        return model;
    }



    public static class Builder {
        private Long resId;
        private String make;
        private String model;


        public Builder(String make) {
            this.make = make;
        }

        public Builder resId(Long resId) {
            this.resId = resId;
            return this;
        }

        public Builder make(String make){
            this.make=make;
            return this;
        }

        public Builder model(String value){
            this.model=value;
            return this;
        }



        public Builder copy(VehicleResource value){
            this.resId=value.getResId();
            this.make=value.getMake();
            this.model=value.getModel();
            return this;
        }

        public VehicleResource build()
        {
            return new VehicleResource(this);
        }
    }

}
