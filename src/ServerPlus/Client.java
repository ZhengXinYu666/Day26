package ServerPlus;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",11111);

        //封装本本文件
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        //封装通道内流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                s.getOutputStream()
        ));
        String line = null;
        while((line = br.readLine())!= null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //Socket提供了一个终止功能
        s.shutdownOutput();

        //接收反馈
        BufferedReader brClient = new BufferedReader(new InputStreamReader(
                s.getInputStream()
        ));
        String client = brClient.readLine();
        System.out.println(client);



        bw.close();
        s.close();

    }
}

