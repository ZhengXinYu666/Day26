package Demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(12345);
        while (true) {
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys, bys.length);
            ds.receive(dp);
            String ip = dp.getAddress().getHostAddress();
            String s = new String(dp.getData(), 0, dp.getLength());
            System.out.println("from" + ip + "传输的数据是:" + s);
        }
    }
}