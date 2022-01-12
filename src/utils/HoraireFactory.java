package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.ActivityHoraire;

public class HoraireFactory implements ListHoraireType {
    private List<ActivityHoraire> activityList;

    public HoraireFactory() {
        this.activityList = new ArrayList<>();
    }

    public List<ActivityHoraire> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<ActivityHoraire> activityList) {
        this.activityList = activityList;
    }

    @Override
    public ActivityHoraire addActivityHoraire(ActivityHoraire model) {
        activityList.add(model);
        return model;
    }

    @Override
    public ActivityHoraire get(String name) {
        ActivityHoraire horaireTypeByName = null;
        for(ActivityHoraire horaireType : activityList){
            if (horaireType.getName().equalsIgnoreCase(name)){
                horaireTypeByName = horaireType;
            }
        }
        return horaireTypeByName;
    }

    @Override
    public ActivityHoraire remove(ActivityHoraire model) {
        //Optional<ActivityHoraire> findHoraireToRemove = activityList.stream().filter(d -> d.getName().equalsIgnoreCase(model.getName())).findAny();
        activityList.remove(model);
        return model;
    }

    @Override
    public ActivityHoraire updateActivityHoraire(ActivityHoraire model) {
        // TODO Auto-generated method stub
        return null;
    }


    
    
}
