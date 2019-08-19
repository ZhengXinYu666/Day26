package Server;

import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args)throws IOException {
        //创建客户端对象
        Socket s = new Socket("192.168.43.31",9999);

        //获取输出流
        OutputStream os = s.getOutputStream();
        os.write("今天天气不错，适合睡觉".getBytes());

        //获取输入流
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String client = new String(bys,0,len);
        System.out.println("client:"+client);

        s.close();

    }
}
