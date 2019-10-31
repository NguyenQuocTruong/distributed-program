package exampleThread.socketTCP;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerTCP extends ServerSocket  {
    public ServerTCP(int port) throws IOException {
        super(port);
    }
}

