package AP.DesignPattern.SingleTon;

import java.util.HashSet;
import java.util.Set;

public class PersonAdminstration {
    private static PersonAdminstration personAdminstration;
    private static Set<Person> personer;

    private PersonAdminstration(){

    }
    public static PersonAdminstration getInstance(){
        if (personAdminstration == null){
            personAdminstration = new PersonAdminstration();
            personer = new HashSet<>();
        }
        return personAdminstration;
    }
    public void addPerson(Person person){
        personer.add(person);
    }

    public Set<Person> getPersoner() {
        return personer;
    }
    public void remove(Person person){
        personer.remove(person);
    }

    @Override
    public String toString() {
        return personer +" ";
    }
}
