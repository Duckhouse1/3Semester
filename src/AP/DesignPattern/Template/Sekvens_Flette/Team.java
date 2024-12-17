package AP.DesignPattern.Template.Sekvens_Flette;



public class Team implements Comparable<Team>{
    private String name;
    private Weekday weekday;

    public Team(String name, Weekday weekday) {
        this.name = name;
        this.weekday = weekday;
    }

    public String getName() {
        return name;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public String toString(){
        return weekday +  " - " + name;
    }

    @Override
    public int compareTo(Team o) {
        int comp = weekday.compareTo(o.getWeekday());
        if (comp==0){
            comp = name.compareTo(name);
        }
        return comp;
    }
}
