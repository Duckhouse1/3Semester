package DIS.DockerDatabaseConn;


import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] args) {
        try {
            Connection minConnection;
                  minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=MYDB;user=sa;password=abcDEF123#;");
            Statement stmt = minConnection.createStatement();

            ResultSet res = stmt.executeQuery("select B.titel\n" +
                    " FROM Bog B, Forfatter F\n" +
                    " where B.forfatterID = F.Id and F.navn = 'H.C. Andersen'");

            while (res.next()) {
                System.out.println(res.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
