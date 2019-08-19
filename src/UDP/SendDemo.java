package UDP;

import java.io.IOException;
import java.net.*;

/**
 * UDP协议发送数据：
 *
 * 1、创建发送端的Socket对象
 * 2、创建数据并把数据打包
 * 3、调用Socket对象的发送方法发送数据包
 * 4、释放资源
 */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        //创建Socket对象
        DatagramSocket ds = new DatagramSocket();
        //创建数据并把数据打包
        //创建数据
        byte[] bys = "hello UDP，我来了".getBytes();
        //长度
        int length = bys.length;
        //IP地址对象
        InetAddress address = InetAddress.getByName("192.168.43.31");
        //端口
        int port = 12345;
        //造数据
        DatagramPacket dp = new DatagramPacket(bys,length,address,port);
        //调用Socket对象的发送方法发送数据包
        //public void send(DatagramPacket p)
        ds.send(dp);
        //释放资源
        ds.close();
    }
}
