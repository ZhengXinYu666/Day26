package UploadPicture;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);

        Socket s = ss.accept();

        //封装通道内流
        BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
        //封装图片文件
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("mn.jpg"));

        byte[] bys = new byte[1024];
        int len = 0;
        while((len=bis.read(bys))!= -1){
            bos.write(bys,0,len);
        }
        //给一个反馈
        OutputStream os = s.getOutputStream();
        os.write("图片上传成功".getBytes());

        bos.close();
        s.close();

    }
}
