package controller;

import java.util.ArrayList;
import java.util.List;

import model.ActivityType;
import utils.ActivityTypeFactory;
import utils.DataSerialize;
import utils.DataStore;
import utils.ListActivityType;
import vue.ActivityTypeVue;

public class ActivityTypeController{
    private ActivityType model;
    private ActivityTypeVue vue;
    public ActivityTypeFactory factory;
    public List<ActivityType> activityList;
    

    public ActivityTypeController(ActivityType model, ActivityTypeVue vue, DataStore<DataSerialize> myDataDataStore) {
        this.model = model;
        this.vue = vue;
        this.factory = new ActivityTypeFactory();
        this.activityList = new ArrayList<>();
        
        //this.activityList = myDataDataStore.getData().dataSerializeList;
        factory.setActivityList(myDataDataStore.getData().dataSerializeList);
        this.activityList = factory.getActivityList();

    }


    public ActivityTypeVue getVue() {
        return vue;
    }

    public void setVue(ActivityTypeVue vue) {
        this.vue = vue;
    }

    public ActivityType getModel() {
        return model;
    }

    public void setModel(ActivityType model) {
        this.model = model;
    }


    public List<ActivityType> getActivityVue(){
        String name = vue.saisirActivity();
        Boolean nameValidation = (vue.saisirActivityValidation().equalsIgnoreCase("o")?true:false);

        if (factory.get(name) == null && !(name.equalsIgnoreCase(""))){
            ActivityType addActivityType = factory.addActivityType(name, nameValidation);
            activityList.add(addActivityType);
            factory.setActivityList(activityList);
        }
        return factory.getActivityList();
    }

    public List<ActivityType> removeActivityVue(){
        String name = vue.removeActivity();
        Boolean nameValidation = false;
        if (vue.removeActivityValidation().equalsIgnoreCase("o")){
            if (factory.get(name) != null){
                nameValidation = true;
                ActivityType addActivityType = factory.remove(name).get();
                activityList.remove(addActivityType);
                factory.setActivityList(activityList);
            }
        }
        
        return factory.getActivityList();
    }

    public List<ActivityType> updateActivityTypes(){
        String name = vue.updateActivity();
        String nameModify = vue.updateActivityNewName();
        Boolean nameRegistration = (vue.saisirActivityValidation().equalsIgnoreCase("o")?true:false);

        Boolean nameValidation = false;
        ActivityType nameVerify = factory.get(name);
        
        if (vue.updateActivityValidation().equalsIgnoreCase("o")){
            if (factory.get(name) != null){
                nameValidation = true;
                nameVerify.setName(nameModify);
                nameVerify.setRegistration(nameRegistration);         
            }
        }  
        return activityList;
    }



    
   

    

    
}
