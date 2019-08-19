package Upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UpdteServer {
    public static void main(String[] args)throws IOException {
        ServerSocket ss = new ServerSocket(11111);

        Socket s = ss.accept();

        //封装通道内的流
        BufferedReader br = new BufferedReader(new InputStreamReader(
                s.getInputStream()
        ));

        BufferedWriter bw = new BufferedWriter(new FileWriter("copy.txt"));

        String line = null;
        while((line = br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }


        //给出反馈
        BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(
                s.getOutputStream()
        ));
        bwServer.write("文件上传成功");
        bwServer.newLine();
        bwServer.flush();



        bw.close();
        s.close();
    }
}
