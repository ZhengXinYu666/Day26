package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP接收数据
 * 1、创建接收端Socket对象
 * 2、创建一个数据包（接收容器）
 * 3、接收数据
 * 4、调用Socket对象的接收方法接收数据
 * 5、解析数据并显示在控制台
 * 6、释放资源
 */
public class ReceiveDemo1 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(12345);
        byte[] bys = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bys,bys.length);
        ds.receive(dp);
        String ip = dp.getAddress().getHostAddress();
        String s = new String(dp.getData(),0,dp.getLength());
        System.out.println("from"+ip+"传输的数据是:"+s);
        //释放资源
        ds.close();
    }
}
