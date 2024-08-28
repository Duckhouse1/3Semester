package DIS.Talk_SocketOpgave.UDP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TalkWriteTraad extends Thread {

    private Socket connectionsSocket;

    public TalkWriteTraad(Socket connectionsSocket) {
        this.connectionsSocket = connectionsSocket;
    }

    @Override
    public void run() {
        try {
            DataOutputStream outStream = new DataOutputStream(connectionsSocket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Skriv: ");
                String streng = input.readLine();
                outStream.writeBytes(streng + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
