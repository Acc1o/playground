package com.socket;

import javafx.beans.binding.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

/**
 * @author ：THEFU
 * @date ：Created in 2022/3/10 15:16
 * @description：
 * @version: 1.0
 */
public class SocketThread extends Thread {
    private Socket socket = null;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run() {
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            String info = null;

            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("我是服务器：客户端说：" + info);
            }
            socket.shutdownInput();

        } catch (Exception e) {
            logger.error("发送出现错误 》》", e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
