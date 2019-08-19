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
public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        //创建Socket对象
        DatagramSocket ds = new DatagramSocket(10086);
        //创建数据包（接收容器）
        byte[] bys = new byte[1024];
        int length = bys.length;
        DatagramPacket dp = new DatagramPacket(bys,length);
        //接收
        ds.receive(dp);
        //解析数据包
        //获取对方的ip
        InetAddress address = dp.getAddress();
        String ip = address.getHostAddress();
        //获取数据缓冲区
        byte[] bys2 = dp.getData();
        //获取数据的实际长度
        int length2 = bys2.length;
        String s = new String(bys2,0,length2);
        System.out.println(ip+":"+s);
        //释放资源
        ds.close();
    }
}