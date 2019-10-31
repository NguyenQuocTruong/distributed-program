package exampleThread.socketTCP;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTCP extends Socket {
    public ClientTCP(String host, int port) throws IOException {
        super(host, port);
    }
}
