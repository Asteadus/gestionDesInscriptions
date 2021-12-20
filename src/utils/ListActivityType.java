package utils;

import model.ActivityType;

public interface ListActivityType {
    ActivityType addActivityType(String name, Boolean resgistrationRequired);
    ActivityType get(String name);
    ActivityType remove(String name);

    
}
