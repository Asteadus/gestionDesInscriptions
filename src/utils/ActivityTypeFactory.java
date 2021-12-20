package utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.ActivityType;

public class ActivityTypeFactory implements ListActivityType{
    
    private List<ActivityType> activityList;

    public List<ActivityType> getActivityList() {
        return activityList;
    }
    public void setActivityList(List<ActivityType> activityList) {
        this.activityList = activityList;
    }
    @Override
    public ActivityType addActivityType(String name, Boolean registrationRequired){
        ActivityType ActivityType = new ActivityType(name, registrationRequired);
        return ActivityType;
    }

    @Override
    public ActivityType get(String name){
        ActivityType activityTypeByName = null;
        for(ActivityType activityType : activityList){
            if (activityType.getName().equalsIgnoreCase(name)){
                activityTypeByName = activityType;
            }
        }
        return activityTypeByName;
    }

    @Override
    public ActivityType remove(String name){
        return null;
    }
    public ActivityTypeFactory() {
        this.activityList = new ArrayList<>();
    }

    
    
}
