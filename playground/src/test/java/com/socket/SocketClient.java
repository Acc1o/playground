package com.socket;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author ：THEFU
 * @date ：Created in 2022/3/10 15:09
 * @description：客户端\发送发
 * @version: 1.0
 */
public class SocketClient {

    @Test
    public void client() throws IOException {
        Socket socket = new Socket("localhost",8088);

        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        printStream.write("客户端发送信息".getBytes(StandardCharsets.UTF_8));
        printStream.flush();

        socket.shutdownOutput();

        printStream.close();
        outputStream.close();
        socket.close();


    }
}
