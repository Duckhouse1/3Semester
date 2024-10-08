package AP.Hashing.dictionarySomHashMap;

import java.util.Objects;

public class Bil {
    private int registreringsnummer;
    private String mærke;
    private String model;
    private String farve;

    public Bil(int registreringsnummer, String mærke, String model, String farve) {
        this.registreringsnummer = registreringsnummer;
        this.mærke = mærke;
        this.model = model;
        this.farve = farve;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bil bil = (Bil) o;
        return registreringsnummer == bil.getRegistreringsnummer() && Objects.equals(mærke, bil.getMærke())
                && Objects.equals(model, bil.getModel()) && Objects.equals(farve, bil.getFarve());
    }

    @Override
    public int hashCode() {
        return Objects.hash(registreringsnummer, mærke, model, farve);
    }

    public int getRegistreringsnummer() {
        return registreringsnummer;
    }

    public void setRegistreringsnummer(int registreringsnummer) {
        this.registreringsnummer = registreringsnummer;
    }

    public String getMærke() {
        return mærke;
    }

    public void setMærke(String mærke) {
        this.mærke = mærke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFarve() {
        return farve;
    }

    public void setFarve(String farve) {
        this.farve = farve;
    }

    @Override
    public String toString() {
        return "Bil{" +
                "registreringsnummer=" + registreringsnummer +
                ", mærke='" + mærke + '\'' +
                ", model='" + model + '\'' +
                ", farve='" + farve + '\'' +
                '}';
    }
}
