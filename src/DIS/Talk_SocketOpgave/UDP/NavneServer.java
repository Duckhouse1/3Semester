package DIS.Talk_SocketOpgave.UDP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class NavneServer {
    private Map<String,String> clientMap = new HashMap<>();
    private static Socket connectionSocket;

    public NavneServer(Socket connectionSocket) throws IOException {
        this.connectionSocket = connectionSocket;
        clientMap.put("CLemen","10.10.138.146");
        clientMap.put("Emil","10.10.138.166");
        clientMap.put("Dennis","10.10.131.195");
    }

    public void getIP() throws IOException {
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream writeToClient = new DataOutputStream(connectionSocket.getOutputStream());

        String navn = inFromClient.readLine();

        String ip = clientMap.getOrDefault(navn, "Unknown host");

        writeToClient.writeBytes(ip + "\n");
    }

    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(6798);
        System.out.println("Serveren venter på klient");

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
        serverSocket.receive(receivePacket);
        String sentence = new String(receivePacket.getData());
        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();


        NavneServer server = new NavneServer(connectionSocket);
        server.getIP();
    }
}
