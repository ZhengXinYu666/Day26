package ServerPlus;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UserThread implements Runnable {

    private Socket s;

    public UserThread(Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(11111);
            Socket s = ss.accept();

            //封装通道内的流
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    s.getInputStream()
            ));

//            BufferedWriter bw = new BufferedWriter(new FileWriter("copy.txt"));
            //为了防止名称冲突
            String newName = System.currentTimeMillis()+".java";
            BufferedWriter bw = new BufferedWriter(new FileWriter(newName));


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
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
