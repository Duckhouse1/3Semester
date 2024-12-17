package AP.DesignPattern.adapter.adresseadapter;

public class Kunde {
	private String navn;
	private int kundeNr;
	private String gadeNavn;
	private int husNr;
	private String byNavn;
	private int postNr;

	public Kunde(){
		super();
	}
	public Kunde(String navn, int kundeNr, String gadeNavn, int husNr,
			String byNavn, int postNr) {
		super();
		this.navn = navn;
		this.kundeNr = kundeNr;
		this.gadeNavn = gadeNavn;
		this.husNr = husNr;
		this.byNavn = byNavn;
		this.postNr = postNr;
	}
	public String getByNavn() {
		return byNavn;
	}
	public String getGadeNavn() {
		return gadeNavn;
	}
	public int getHusNr() {
		return husNr;
	}
	public int getKundeNr() {
		return kundeNr;
	}
	public String getNavn() {
		return navn;
	}
	public int getPostNr() {
		return postNr;
	}
}
