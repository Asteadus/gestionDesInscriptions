package utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.ActivityHoraire;
import model.ActivityType;

public class DataSerialize implements Serializable {
    
    public List<ActivityType> dataSerializeList = new ArrayList<>();
    public List<ActivityHoraire> dataSerializeListHoraire = new ArrayList<>();
    
}
