package AP.DesignPattern.Composite.Figur;

public class Rektangel extends GeometriskFigur{
    private int længde;
    private int bredde;
    public Rektangel(String navn,int længde, int bredde) {
        super(navn);
        this.længde = længde;
        this.bredde = bredde;
    }

    @Override
    public void addFigur(GeometriskFigur geometriskFigur) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getAreal() {
        return 0;
    }

    public int getLængde() {
        return længde;
    }

    public void setLængde(int længde) {
        this.længde = længde;
    }

    public int getBredde() {
        return bredde;
    }

    public void setBredde(int bredde) {
        this.bredde = bredde;
    }
}
