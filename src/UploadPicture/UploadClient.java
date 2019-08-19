package UploadPicture;

import java.io.*;
import java.net.Socket;

public class UploadClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 12345);

        //封装图片文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("林青霞.jpg"));
        //封装通道内的流
        BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());

        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
            bos.flush();
        }

        s.shutdownOutput();

        //读取反馈
        InputStream is = s.getInputStream();
        byte[] bys2 = new byte[1024];
        int len2 = is.read(bys2);
        String client;
        client = new String(bys2, 0, len2);
        System.out.println(client);

        bis.close();
        s.close();
    }
}

