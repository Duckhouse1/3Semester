package AP.Tidskompleksitet.AlgoritmeOpgaver;

import java.util.Arrays;

public class BigO_og_Algoritmer {
    //Opgave 1
    //Hvad er størrelsesordenen af tidskompleksiteten (Store O) af nedenstående
    //metode ?
    //Spørgsmål a = O(n^2)
    //Spørgsmål b = 0(n^3)

    //Opgave 2
    //T(isStringHello)n = O(1)
    //T(CheckString)n = O(n)
    //T(MethodA)n = O(n^2)
    //T(PrivatMethodA) = O(n)
    //T(MethodB) = O(n logn)

    public static double[] prefixAverage(int[] inputTal) {
        double[] talListe = new double[inputTal.length];
        double sum = 0;
        for (int i = 0; i <inputTal.length; i++) {
            sum += inputTal[i];
            talListe[i] = sum / (i+1);
        }
        return talListe;
    }

    public static void main(String[] args) {
        int[] array = {5, 10, 5, 6, 4, 9, 8};

        System.out.println(Arrays.toString(prefixAverage(array)));
    }
}
