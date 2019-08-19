package SocketTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args)throws IOException {
        ServerSocket ss = new ServerSocket(23456);

        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(
                s.getInputStream()));

        //封装文本文件数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));

        String line = null;
        while((line = br.readLine())!= null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        s.close();
    }
}
