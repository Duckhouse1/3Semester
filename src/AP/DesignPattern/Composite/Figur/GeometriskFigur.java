package AP.DesignPattern.Composite.Figur;

public abstract class GeometriskFigur {
    private String navn;

    public GeometriskFigur(String navn) {
        this.navn = navn;
    }
    public abstract void addFigur(GeometriskFigur geometriskFigur);

    public abstract double getAreal();
    public void tegn(){
        System.out.println(navn);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
