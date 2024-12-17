package DIS.Sikkerhed.PasswordOpgave;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.*;

public class Gui extends Application {
	Button btnLogin, btnOpret, btnscene2;
	Label lblbrugernavn, lblPassword, lblBesked;
	Label lblscene2, lblInfoBruger;
	GridPane pane1, pane2;
	Scene scene1, scene2;
	Stage thestage;	
	private PasswordField password = new PasswordField();
	private String saltString;
	private static TextField brugernavn = new TextField();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		thestage = primaryStage;
		
		btnLogin = new Button("Log in");
		btnOpret = new Button("Opret");
		btnscene2 = new Button("Tilbage til log in");
		btnLogin.setOnAction(e -> ButtonClicked(e));
		btnOpret.setOnAction(e -> ButtonClicked(e));
		btnscene2.setOnAction(e -> ButtonClicked(e));
		lblbrugernavn = new Label("Navn");
		lblPassword = new Label("Password");
		lblBesked = new Label("Hello World");

		lblscene2 = new Label("Du er nu logget ind");
		lblInfoBruger = new Label("Bruger info");
		
		pane1 = new GridPane();
		pane2 = new GridPane();
		pane1.setVgap(10);
		pane2.setVgap(10);
		
		pane1.setStyle("-fx-background-color: yellow;-fx-padding: 10px;");
		pane2.setStyle("-fx-background-color: lightgreen;-fx-padding: 10px;");

		pane1.setPadding(new Insets(5));
		pane1.setHgap(10);
		pane1.setVgap(10);

		pane1.add(lblbrugernavn, 0, 0);
		pane1.add(brugernavn, 0, 1, 2, 1);
		pane1.add(lblPassword, 0, 2);
		pane1.add(password, 0, 3, 2, 1);
		pane1.add(btnLogin, 0, 4);
		pane1.add(btnOpret, 1, 4);
		pane1.add(lblBesked, 0, 5);

		pane2.setPadding(new Insets(5));
		pane2.setHgap(10);
		pane2.setVgap(10);
		
		pane2.add(lblInfoBruger, 0, 0);
		pane2.add(btnscene2, 0, 1);

		scene1 = new Scene(pane1, 200, 200);
		scene2 = new Scene(pane2, 200, 200);

		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene1);
		primaryStage.show();
	}

	public void ButtonClicked(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			//TODO
			thestage.setScene(scene2);

		} else if (e.getSource() == btnOpret) {
			//TODO
			byte[] salt = new byte[0];
			try {
				hashPW(password.getText(), salt);
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}

			System.out.println("Oprettet");
		} else {
			lblBesked.setText("");
			password.clear();
			brugernavn.clear();
			thestage.setScene(scene1);

		}
	}
	public void hashPW(String password , byte[] salt) throws SQLException {
		SecureRandom random = new SecureRandom();
		salt = new byte[16];
		random.nextBytes(salt);
		System.out.println("salt" + salt);
		//saltString = salt.toString();
		System.out.println(salt);
		try {
			MessageDigest md = MessageDigest.getInstance("SHA3-384");
			System.out.println("md" +md);
			md.update(salt);
			byte[] hashedPassword = md.digest(password.getBytes());

			Connection minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLExpress;databaseName=master;user=sa;password=erder1;");
			String sql = "insert into bruger values(?,?,?) ";// preparedStatement
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();

			prestmt.setString(1,brugernavn.getText().trim());
			prestmt.setString(2, hashedPassword.toString());
			prestmt.setBytes(3, salt);

			prestmt.executeUpdate();

		} catch (NoSuchAlgorithmException ex) {
			throw new RuntimeException(ex);
		}
	}

}
