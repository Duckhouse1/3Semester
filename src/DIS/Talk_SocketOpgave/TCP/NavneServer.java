package DIS.Talk_SocketOpgave.TCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
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
        ServerSocket welcomeSocket = new ServerSocket(6798);
        System.out.println("Serveren venter på klient");

        Socket connectionSocket = welcomeSocket.accept();
        System.out.println("Klient forbundet");

        NavneServer server = new NavneServer(connectionSocket);
        server.getIP();
    }
}
