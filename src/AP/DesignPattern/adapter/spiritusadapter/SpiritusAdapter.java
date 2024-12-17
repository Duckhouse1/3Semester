package AP.DesignPattern.adapter.spiritusadapter;

public class SpiritusAdapter extends Vare{
    private Spiritus spiritusvare;

    public SpiritusAdapter(Spiritus spiritus) {
        super(spiritus.getPrisen(),spiritus.getBetgenelse());
        this.spiritusvare = spiritus;
    }


    @Override
    public double beregnMoms() {
        return spiritusvare.hentMoms();
    }

    @Override
    public int getPris() {
        return spiritusvare.getPrisen();
    }

    @Override
    public void setPris(int pris) {
        spiritusvare.setPrisen(pris);
    }

    @Override
    public String getNavn() {
        return spiritusvare.getBetgenelse();
    }

    @Override
    public void setNavn(String navn) {
        spiritusvare.setBetgenelse(navn);
    }
}
