package TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * TCP协议发送数据
 * 1、创建发送端的Socket对象,这一步如果成功，就说明连接已经建立成功了
 * 2、获取输出流，写数据
 * 3、释放资源
 *
 * tcp协议一定要先开服务器
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //创建发送端的Socket对象
        //Socket(InetAddress address,int port)
        //Socket(String host,int port)
        //Socket s = new Socket(InetAddress.getByName("192.168.43.31"),12345);
        Socket s = new Socket("192.168.43.31",12345);

        //获取输出流
        OutputStream os = s.getOutputStream();
        os.write("hello，tcp 我来了".getBytes());

        //释放资源
        s.close();

    }
}
