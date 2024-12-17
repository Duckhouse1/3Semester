package AP.DesignPattern.adapter.spiritusadapter;

public class ElVare extends Vare {
    public ElVare(int pris, String navn) {
        super(pris, navn);
    }

    @Override
    public double beregnMoms() {
        return getPris()*0.3;
    }
}
