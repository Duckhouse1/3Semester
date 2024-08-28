package DIS.Talk_SocketOpgave.UDP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class TalkClient {
    public static void main(String[] args) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");

//        byte[] sendData = new byte[1024];
//        byte[] receiveData = new byte[1024];
//
//        System.out.println("Indtast navn for IP addresse:");
//        String navn = inFromUser.readLine();
//        sendData = navn.getBytes();
//
//        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
//        clientSocket.send(sendPacket);
//
//        DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
//        clientSocket.receive(receivePacket);
//
//        String serverResponse = receiveData.toString();
//        System.out.println("IP addresse: " + serverResponse);

//        Socket clemenServer = new Socket(serverResponse,6789);
        TalkWriteTraad skriveTraad = new TalkWriteTraad(clientSocket);
        TalkReadTraad læseTraad = new TalkReadTraad(clientSocket);

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
