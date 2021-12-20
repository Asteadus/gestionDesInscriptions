import java.util.Arrays;
import java.util.List;

import controller.ActivityTypeController;
import model.ActivityType;
import vue.ActivityTypeVue;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Ce code permet la gestion des inscriptions");
        ActivityTypeController activityTypeController = new ActivityTypeController(new ActivityType(), new ActivityTypeVue());
        
        List<ActivityType> activitypeList = activityTypeController.getActivityVue();
        
        System.out.println(activitypeList);

        for (ActivityType s : activityTypeController.activityList){
            System.out.println(s);
        } 
        activityTypeController.myDataDataStore.save();
      
    }
}
