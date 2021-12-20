package model;

import java.io.Serializable;
import java.util.List;

public class ActivityType implements Serializable {
    private String name;
    private boolean registration;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isRegistration() {
        return registration;
    }
    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    public ActivityType(String name, boolean registration) {
        this.name = name;
        this.registration = registration;
        
    }
    public ActivityType() {
        super();
    }
    @Override
    public String toString() {
        return "ActivityType"+ ", name=" + name + ", registration=" + registration + "]";
    }
    
}
