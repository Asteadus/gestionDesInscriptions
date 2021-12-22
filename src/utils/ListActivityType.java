package utils;

import java.util.Optional;

import model.ActivityType;

public interface ListActivityType {
    ActivityType addActivityType(String name, Boolean resgistrationRequired);
    ActivityType get(String name);
    Optional<ActivityType> remove(String name);
    ActivityType updateActivityType(String name);

    
}
