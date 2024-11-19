package AP.DesignPattern.SingleTon;

public class Person {
    private String navn;
    private int alder;
    private String Land;

    public Person(String navn, int alder, String land) {
        this.navn = navn;
        this.alder = alder;
        Land = land;
    }

    public String getNavn() {
        return navn;
    }

    public int getAlder() {
        return alder;
    }

    public String getLand() {
        return Land;
    }

    @Override
    public String toString() {
        return "Navn:" + navn +" Alder:" + alder +" Land:" + Land;
    }
}
