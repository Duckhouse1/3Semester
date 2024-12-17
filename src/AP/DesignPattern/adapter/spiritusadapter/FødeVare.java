package AP.DesignPattern.adapter.spiritusadapter;

public class FødeVare extends Vare{
    public FødeVare(int pris, String navn) {
        super(pris, navn);
    }

    @Override
    public double beregnMoms() {
        return getPris()*0.05;
    }
}
