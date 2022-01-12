package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import model.ActivityHoraire;
import model.ActivityType;
import utils.DataSerialize;
import utils.DataStore;
import utils.HoraireFactory;
import utils.ListActivityType;
import vue.HoraireVue;

public class HoraireController {
    private ActivityHoraire model;
    

    private HoraireVue vue;
    public HoraireFactory factory;
    public List<ActivityHoraire> horaireList;
    public List<ActivityType> activityList;

    


    public HoraireController(ActivityHoraire model, HoraireVue vue, DataStore<DataSerialize> myDataStore) {
        this.model = model;
        this.vue = vue;
        factory = new HoraireFactory();
        factory.setActivityList(myDataStore.getData().dataSerializeListHoraire);
        this.horaireList = factory.getActivityList();

        activityList = myDataStore.getData().dataSerializeList;
    }
    public ActivityHoraire getModel() {
        return model;
    }
    public void setModel(ActivityHoraire model) {
        this.model = model;
    }
    public HoraireVue getVue() {
        return vue;
    }
    public void setVue(HoraireVue vue) {
        this.vue = vue;
    }



    public List<ActivityHoraire> getHoraireVue(){
        String name = vue.askUser("Entrez un nom d'activité");
        String startDateString = vue.askUser("Entrez une date de début et heure de début (dd/MM/yyyy hh:mm) : ");
        String endDateString = vue.askUser("Entrer une date et heure de fin (dd/MM/yyyy hh:mm) : ");
        int activityTypeId = Integer.parseInt(vue.askUserActivityType("Entrer le numéro du type d'activité choisi : ", activityList))-1;
        vue.setError(null);
        String error = "";
        ActivityHoraire activityHoraire2Display = null;
       
        LocalDateTime startDate = null;
        LocalDateTime endDate = null;

        if(startDateString.matches("(\\d{2}\\/\\d{2}\\/\\d{2}) (\\d{2}:\\d{2})")){
            startDate = LocalDateTime.parse(startDateString, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
        }
        else
            error += "La date et l'heure de début ne respecte pas le format ! ";

        if(endDateString.matches("(\\d{2}\\/\\d{2}\\/\\d{2}) (\\d{2}:\\d{2})")){
            endDate = LocalDateTime.parse(endDateString, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
        }
        else
            error += "La date et l'heure de fin ne respecte pas le format ! ";

        ActivityType activityType = null;
        while(activityType == null){
            try{
                activityType = activityList.get(activityTypeId);
            }
            catch(IndexOutOfBoundsException ex){
                System.out.println("Aucun type d'activité ! ");
                activityTypeId = Integer.parseInt(vue.askUserActivityType("Entrer le numéro du type d'activité choisi : ", activityList))-1;
            }
        }

        if(startDate != null && endDate != null && !name.isBlank() && activityType != null){

            model.setStart(startDate);
            model.setEnd(endDate);
            model.setName(name);
            model.setActivityType(activityType);

            activityHoraire2Display = factory.addActivityHoraire(model);

        }
        else
            error += "Données saisies incorrectes ! ";
        
        vue.setError("Erreur : " + error);
        return factory.getActivityList();
    }

    public List<ActivityHoraire> removeHoraire(){
        String name = vue.askUser("Quel activité voulez-vous supprimer");
        Boolean nameValidation = false;
        setModel(factory.get(name));
       
        if (vue.askUser("Êtes-vous sûr?").equalsIgnoreCase("o")){
            if (model != null){
                nameValidation = true;
                factory.remove(model);
                
            }
        }
        
        return factory.getActivityList();
    }
}
