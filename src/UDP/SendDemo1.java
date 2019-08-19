package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SendDemo1 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        byte[] bys = "Hello World".getBytes();
        DatagramPacket dp = new DatagramPacket(bys,bys.length, InetAddress.getByName("192.168.43.31"),12345);
        ds.send(dp);
        ds.close();
    }
}
