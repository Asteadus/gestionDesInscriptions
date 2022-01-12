package utils;


import java.util.Optional;

import model.ActivityHoraire;

public interface ListHoraireType {
    ActivityHoraire addActivityHoraire(ActivityHoraire model);
    ActivityHoraire get(String name);
    ActivityHoraire remove(ActivityHoraire model);
    ActivityHoraire updateActivityHoraire(ActivityHoraire model);

    
}
