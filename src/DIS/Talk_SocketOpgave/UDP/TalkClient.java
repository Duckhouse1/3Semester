package DIS.Talk_SocketOpgave.UDP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TalkClient {
    public static void main(String[] args) throws Exception {

        Socket clientSocket = new Socket("localhost", 6798);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Indtast navn for IP addresse:");
        String navn = inFromUser.readLine();
        outToServer.writeBytes(navn + "\n");

        String serverResponse = inFromServer.readLine();
        System.out.println("IP addresse: " + serverResponse);

        Socket clemenServer = new Socket(serverResponse,6789);
        TalkWriteTraad skriveTraad = new TalkWriteTraad(clemenServer);
        TalkReadTraad læseTraad = new TalkReadTraad(clemenServer);

        skriveTraad.start();
        læseTraad.start();

        //Samme opgave men uden tråde  v
//        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
//        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
//        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        boolean løkke = true;
//        while (løkke) {
//
//            System.out.println("Skriv til server");
//
//            String sentence = inFromUser.readLine();
//            if (sentence.equalsIgnoreCase("Farvel")) {
//                løkke = false;
//                clientSocket.close();
//            }
//            outToServer.writeBytes(sentence + '\n');
//
//            String serverBesked = inFromServer.readLine();
//            System.out.println(serverBesked);
//
//        }

    }
}
