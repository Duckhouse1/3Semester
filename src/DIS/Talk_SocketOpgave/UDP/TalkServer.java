package DIS.Talk_SocketOpgave.UDP;

import java.net.*;

public class TalkServer {

    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
//        byte[] receiveData = new byte[1024];
//        byte[] sendData = new byte[1024];

//        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//        serverSocket.receive(receivePacket);

        TalkReadTraad læseTraad = new TalkReadTraad(serverSocket);
        TalkWriteTraad writeTraad = new TalkWriteTraad(serverSocket);

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

