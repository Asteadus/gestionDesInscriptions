package vue;

import java.util.Scanner;

import model.ActivityType;



public class ActivityTypeVue {
    private Scanner scanner = new Scanner(System.in);

    public String saisirActivity (){
        
        System.out.println("Entrez un nom d'activité à ajouter");
        String activity = scanner.nextLine();

        return activity;
    }

    public String saisirActivityValidation (){
        System.out.println("L'inscription demande-t-elle une inscription?");
        String validationActivity = scanner.nextLine();
        return validationActivity;
    }

    public String removeActivity (){
        
        System.out.println("Entrez un nom d'activité à supprimer");
        String activity = scanner.nextLine();

        return activity;
    }

    public String removeActivityValidation (){
        System.out.println("Voulez-vous vraiment le supprimer? O/N");
        String validationActivity = scanner.nextLine();
        return validationActivity;
    }

}
