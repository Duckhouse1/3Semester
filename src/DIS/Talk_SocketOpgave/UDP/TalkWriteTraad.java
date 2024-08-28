package DIS.Talk_SocketOpgave.UDP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class TalkWriteTraad extends Thread {

    private DatagramSocket connectionDatagramSocket;

    public TalkWriteTraad(DatagramSocket connectionDatagram) {
        this.connectionDatagramSocket = connectionDatagram;
    }

    @Override
    public void run() {
        try {
            byte[] sendData = new byte[1024];
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            InetAddress IPAddress = InetAddress.getByName("localhost");
            int port = 9876;

            while (true) {
                System.out.println("Skriv: ");
                String streng = input.readLine();
                sendData = streng.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                connectionDatagramSocket.send(sendPacket);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
