package vue;

import java.util.Scanner;

import model.ActivityType;



public class ActivityTypeVue {
    private Scanner scanner = new Scanner(System.in);

    public String saisirActivity (){
        
        System.out.println("Entrez un nom d'activité");
        String activity = scanner.nextLine();

        return activity;
    }

    public String saisirActivityValidation (){
        System.out.println("Voulez-vous l'ajouter? O/N");
        String validationActivity = scanner.nextLine();
        return validationActivity;
    }

}
