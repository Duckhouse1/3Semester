package DIS.Talk_SocketOpgave.TCP;

import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {

    public static void main(String[] args) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(5789);
        System.out.println("Serveren venter på klient");

        Socket connectionSocket = welcomeSocket.accept(); //Dette man kalder three handshake (SYN -> ,  <- ACN/SYN , ACN ->)
        System.out.println("Klient forbundet til Server");

        TalkReadTraad læseTraad = new TalkReadTraad(connectionSocket);
        TalkWriteTraad writeTraad = new TalkWriteTraad(connectionSocket);

        læseTraad.start();
        writeTraad.start();

//              Samme opgave men uden traade
//        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
//        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
//        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
//        boolean løkke = true;
//        while (løkke) {
//
//            String clientBesked = inFromClient.readLine();
//            System.out.println(clientBesked);
//            System.out.println("Skriv noget tilbage:");
//            String tilCLient = inFromUser.readLine();
//            if (tilCLient.equalsIgnoreCase("Farvel")){
//                løkke = false;
//                connectionSocket.close();
//            }
//            outToClient.writeBytes(tilCLient+'\n');
//
//
//        }
    }

}

