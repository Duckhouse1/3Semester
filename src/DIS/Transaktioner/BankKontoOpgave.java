package DIS.Transaktioner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class BankKontoOpgave {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Indtast regNr du vil tage fra:");
        String regFra = inLine.readLine();
        System.out.println("Indtast kontoNr du vil tage fra:");
        String kontoFra = inLine.readLine();
        System.out.println("Indtast regNr du vil sende til:");
        String regTil = inLine.readLine();
        System.out.println("Indtast konto du vil sende til:");
        String kontoTil = inLine.readLine();
        System.out.println("Indtast beløb:");
        int beløb = inLine.read();

        Connection minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLExpress;databaseName=master;user=sa;password=erder1;");
        Statement statement = minConnection.createStatement();


        ResultSet resultSetRegFra = statement.executeQuery("SELECT * FROM Konto K where K.regNr=" + regFra + "and K.ktoNr =" + kontoFra);

        ResultSet resultSetRegTil = statement.executeQuery("SELECT * FROM Konto K where K.regNr=" + regTil +"and K.ktoNr =" + kontoTil);

        if (resultSetRegFra != null){
            if (resultSetRegTil != null){
                if (beløb >= resultSetRegFra.getInt(4)){
                    int FraKontoNyeBeløb = resultSetRegFra.getInt(4) - beløb;
                    int TilKontoNyeBeløb = resultSetRegTil.getInt(4) + beløb;

                }
            }
        }
    }
}
