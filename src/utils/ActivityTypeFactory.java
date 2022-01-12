package utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.ActivityType;

public class ActivityTypeFactory implements ListActivityType{
    
    private List<ActivityType> activityList;

    public ActivityTypeFactory() {
        this.activityList = new ArrayList<>();
    }
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
    public Optional<ActivityType> remove(String name){
        Optional<ActivityType> findActivityToRemove = activityList.stream().filter(d -> d.getName().equalsIgnoreCase(name)).findAny();
        return findActivityToRemove;
    }
    
    @Override
    public ActivityType updateActivityType(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    
    
}
