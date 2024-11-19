package AP.DesignPattern.SingleTon;

public class PersonAdminstrationApp {
    public static void main(String[] args) {
        PersonAdminstration personAdminstration = PersonAdminstration.getInstance();

        personAdminstration.addPerson(new Person("Dennis",25,"DK"));

        System.out.println(personAdminstration.getPersoner());
    }
}
