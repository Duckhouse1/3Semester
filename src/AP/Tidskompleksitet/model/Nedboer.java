package model;

import javax.sound.midi.Soundbank;

public class Nedboer {
    public static void main(String[] args) {

        System.out.println(bedsteTreFerieUger());
        System.out.println(bedsteFerieUgerStart(3));
        System.out.println(ensNedboer());
    }
    private static int[] nedboerPrUge = { 20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13,
            15, 10, 9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12, 0, 2, 0, 0, 78, 0,
            0, 0, 34, 12, 34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18,
            19, 21, 32, 24, 13 };

    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i de tre uger
     *
     * @return
     */

    public static int bedsteTreFerieUger() {
        int ugeMedMindsNedbør = 1;
        double minNedbør = 1000;
        double samletNedbør = 0;
        for (int i = 0; i < nedboerPrUge.length-3; i++) {
            samletNedbør = nedboerPrUge[i] + nedboerPrUge[i+1] + nedboerPrUge[i+2];
            if (samletNedbør < minNedbør){
                minNedbør = samletNedbør;
                ugeMedMindsNedbør = i+1;
            }
        }
        return ugeMedMindsNedbør;
    }

    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i det "antal" uger, der er
     * angivet i paramtereren
     *
     * @return
     */

    public static int bedsteFerieUgerStart(int antal) {
        int ugeMedMindsNedbør = 1;
        double minNedbør = 1000;
        double samletNedbør = 0;
        for (int i = 0; i < nedboerPrUge.length-antal; i++) {
            samletNedbør += nedboerPrUge[i];
            if (i % antal == 0){
                if (samletNedbør < minNedbør){
                    ugeMedMindsNedbør = i - antal;
                    minNedbør = samletNedbør;
                }
                samletNedbør = 0;
            }
        }
        return ugeMedMindsNedbør;
    }

    /**
     * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis
     * den samme flest uger i træk
     *
     * @return
     */
    public static int ensNedboer() {
        int ugeNummeret = 1;
        int maxAntalITræk = 0;
        int antalITræk = 0;
        for (int i = 0; i < nedboerPrUge.length-1; i++) {
            if (nedboerPrUge[i] == nedboerPrUge[i+1]){
                antalITræk++;
                if (antalITræk > maxAntalITræk){
                    ugeNummeret = i+1;
                    maxAntalITræk = antalITræk;
                }
            } else {
                antalITræk = 0;
            }
        }
        return ugeNummeret;
    }
}
