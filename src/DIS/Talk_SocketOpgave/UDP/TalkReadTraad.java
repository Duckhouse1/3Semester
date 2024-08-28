package DIS.Talk_SocketOpgave.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TalkReadTraad extends Thread {
    private DatagramSocket connectionsDatagramSocket;

    public TalkReadTraad(DatagramSocket connectionDatagram) {
        this.connectionsDatagramSocket = connectionDatagram;
    }

    @Override
    public void run() {
        try {
            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                connectionsDatagramSocket.receive(receivePacket);

                String sentence = new String(receivePacket.getData());

                if (sentence.equalsIgnoreCase("Farvel")) {
                    connectionsDatagramSocket.close();
                }
                System.out.println(sentence);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
