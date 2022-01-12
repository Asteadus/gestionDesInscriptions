import java.util.Arrays;
import java.util.List;

import controller.ActivityTypeController;
import controller.HoraireController;
import model.ActivityHoraire;
import model.ActivityType;
import utils.DataSerialize;
import utils.DataStore;
import vue.ActivityTypeVue;
import vue.HoraireVue;

public class App {
    public static void main(String[] args) throws Exception {
        DataStore<DataSerialize> myDataDataStore;
        myDataDataStore = new DataStore<>("ActivitypeList.ser", DataSerialize::new);

        System.out.println("Ce code permet la gestion des inscriptions");
        ActivityTypeController activityTypeController = new ActivityTypeController(new ActivityType(), new ActivityTypeVue(), myDataDataStore);
        List<ActivityType> acitivityTypeList = activityTypeController.factory.getActivityList();
        HoraireController horaireController = new HoraireController(new ActivityHoraire(), new HoraireVue(), myDataDataStore);
        List<ActivityHoraire> horaireList = horaireController.factory.getActivityList();
        //List<ActivityType> activitypeList = activityTypeController.getActivityVue();
        
        //System.out.println(acitivityTypeList);

        for (ActivityHoraire s : horaireController.factory.getActivityList()){
            System.out.println(s);
        }


        //activityTypeController.getActivityVue();
        
        //horaireController.getHoraireVue();
       
        
        horaireController.removeHoraire();

        System.out.println(horaireList);

        myDataDataStore.save();
    }
}
