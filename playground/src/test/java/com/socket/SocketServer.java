package com.socket;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ：THEFU
 * @date ：Created in 2022/3/10 15:15
 * @description：服务端\接收方
 * @version: 1.0
 */
public class SocketServer {
    @Test
    public void serve() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);
        Socket socket = new Socket();
        while (true){
            socket = serverSocket.accept();

            SocketThread socketThread = new SocketThread(socket);
            socketThread.start();

        }
    }
}
