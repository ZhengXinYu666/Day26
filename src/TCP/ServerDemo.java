package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP协议接收数据：
 * 1、创建接收端的Socket对象
 * 2、监听客户端,返回一个对应的Socket对象
 * 3、获取输入流，读取数据，显示在控制台
 * 4、释放资源
 */
public class ServerDemo {
    public static void main(String[] args)throws IOException {
        //创建Socket对象
        ServerSocket ss = new ServerSocket(12345);

        //监听客户端,返回一个对应的Socket对象
        Socket s = ss.accept();//监听并接受到此套接字的链接，该方法在连接串入职前一直阻塞

        //获取输入流
        InputStream is = s.getInputStream();

        byte[] bys = new byte[1024];
        int len = is.read(bys);//阻塞式方法
        String str = new String(bys,0,len);
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip);
        System.out.println(str);


        //释放资源
        s.close();
    }
}
