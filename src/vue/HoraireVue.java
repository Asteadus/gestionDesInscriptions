package vue;
import java.util.List;
import java.util.Scanner;

import model.ActivityType;

public class HoraireVue {
    Scanner sc = new Scanner(System.in);

    private String error = null;

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public String askUser(String texte2Display) {
        System.out.println(texte2Display);
        return sc.nextLine();
    }
    public String askUserActivityType(String texte2Display, List<ActivityType> listActivityTypes) {
        
        int i = 1;
        System.out.println("(0) name : no changes");
        for (ActivityType activityType : listActivityTypes) {
            System.out.println("(" + (i++) + ") name : " + activityType.getName());
        }
        System.out.println(texte2Display);
        //System.out.println(listActivityTypes);
        return sc.nextLine();
    }
}
