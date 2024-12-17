package AP.DesignPattern.adapter.adresseadapter;

public class TestAdapter {

	
	public static void main(String[] args) {
		 Kunde k1 = new Kunde("Margrethe", 1001, "Læsøgade", 4, "Århus", 8000);
	        Kunde k2 = new Kunde("Torben", 1002, "Samsøgade", 6, "Højbjerg", 8270);
	        
	        Adresse ad1 = new KundeToAdresseAdapter(k1);
	        Adresse ad2 = new KundeToAdresseAdapter(k2);
	        
	        System.out.println(ad1.getVejOgHusNr());
	        System.out.println(ad1.getPostNrOgByNavn());
	        System.out.println(ad1.getLandeKode());
	        System.out.println();
	        System.out.println(ad2.getVejOgHusNr());
	        System.out.println(ad2.getPostNrOgByNavn());
	        System.out.println(ad2.getLandeKode());

	}

}
