package AP.DesignPattern.adapter.spiritusadapter;

public class app {
    public static void main(String[] args) {
        Spiritus whisky = new Spiritus(199,"Whisky");

        SpiritusAdapter whiskyAdapter = new SpiritusAdapter(whisky);

        System.out.println(whiskyAdapter.beregnMoms());
    }
}
