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
    private ActivityTypeFactory factory;
    public List<ActivityType> activityList;
    public  DataStore<DataSerialize> myDataDataStore;

    public ActivityTypeController(ActivityType model, ActivityTypeVue vue) {
        this.model = model;
        this.vue = vue;
        this.factory = new ActivityTypeFactory();
        //this.activityList = new ArrayList<>();
        myDataDataStore = new DataStore<>("ActivitypeList.ser", DataSerialize::new);
        this.activityList = myDataDataStore.getData().dataSerializeList;
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
        Boolean nameValidation = false;
        if (vue.saisirActivityValidation().equalsIgnoreCase("o")){
            if (factory.get(name) == null){
                nameValidation = true;
                ActivityType addActivityType = factory.addActivityType(name, nameValidation);
                activityList.add(addActivityType);
                factory.setActivityList(activityList);
            }
        }
        
        return factory.getActivityList();
    }

    public void AddListTofile(List<ActivityType> activityTypes){
        
        
    }


    
   

    

    
}
