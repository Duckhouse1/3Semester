package DIS.Talk_SocketOpgave.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TalkReadTraad extends Thread {
    private Socket connectionsSocket;

    public TalkReadTraad(Socket connectionsSocket) {
        this.connectionsSocket = connectionsSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connectionsSocket.getInputStream()));
            while (true) {

                String streng = inFromServer.readLine();
                if (streng.equalsIgnoreCase("Farvel")) {
                    connectionsSocket.close();
                }
                System.out.println(streng);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
