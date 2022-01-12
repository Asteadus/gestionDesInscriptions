package model;
import java.io.Serializable;
import java.time.LocalDateTime;

public class ActivityHoraire implements Serializable {
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private ActivityType activityType;

    public ActivityHoraire(String name, LocalDateTime start, LocalDateTime end, ActivityType activityType) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.activityType = activityType;
    }
    
    public ActivityHoraire() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    @Override
    public String toString() {
        return "AcitivityHoraire [activityType=" + activityType + ", end=" + end + ", name=" + name + ", start=" + start
                + "]";
    }
    
}
