package DIS.ScreenScraping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://valutakurser.dk ");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = br.readLine()) != null) {

            String danskCurrency = line.substring(line.indexOf("currencyName\": Danske kroner"),line.indexOf("actualValue\":100"));
            String amerikansCurrency = line.substring(line.indexOf("currencyName\": Danske kroner",line.indexOf("actualValue\":682.33")));
            System.out.println("DKK: " + danskCurrency);
            System.out.println("USD" + amerikansCurrency);
//            System.out.println(line);
        }
    }
}
