package DIS.Transaktioner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class BankKontoOpg {
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
        //Her skal man lave ParseInt fordi man ikke læser integers på samme måde i en buffered reader
        int beløb = Integer.parseInt(inLine.readLine());

        Connection minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLExpress;databaseName=master;user=sa;password=erder1;");
        //Hver gang man executer en noget query skal den have sin egen statement, ellers lukker de ned før man kan arbejde med dem
        Statement stmtFra = minConnection.createStatement();
        Statement stmtTil = minConnection.createStatement();
        Statement stmtUpdate = minConnection.createStatement();

        ResultSet resultSetRegFra = stmtFra.executeQuery(
                "SELECT * FROM Konto WHERE regNr = " + regFra + " AND ktoNr = " + kontoFra);
        ResultSet resultSetRegTil = stmtTil.executeQuery(
                "SELECT * FROM Konto WHERE regNr = " + regTil + " AND ktoNr = " + kontoTil);

        if (resultSetRegFra.next() && resultSetRegTil.next()) {
            int saldoFra = resultSetRegFra.getInt("saldo");
            int saldoTil = resultSetRegTil.getInt("saldo");

            if (beløb <= saldoFra) {
                int fraKontoNyeBeløb = saldoFra - beløb;
                int tilKontoNyeBeløb = saldoTil + beløb;

                stmtUpdate.executeUpdate(
                        "UPDATE Konto SET saldo = " + fraKontoNyeBeløb +
                                " WHERE regNr = " + regFra + " AND ktoNr = " + kontoFra);
                stmtUpdate.executeUpdate(
                        "UPDATE Konto SET saldo = " + tilKontoNyeBeløb +
                                " WHERE regNr = " + regTil + " AND ktoNr = " + kontoTil);

                System.out.println("Transaktion gennemført! Der står nu på kontoNr: " + kontoTil + " beløb på: " + tilKontoNyeBeløb);
            } else {
                System.out.println("Ikke tilstrækkelig saldo på kontoen.");
            }
        } else {
            System.out.println("En eller begge konti blev ikke fundet.");
        }
        if (resultSetRegFra != null) resultSetRegFra.close();
        if (resultSetRegTil != null) resultSetRegTil.close();
        if (minConnection != null) minConnection.close();
    }
}
