package Demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SendThread implements Runnable{

    private DatagramSocket ds;

    public SendThread(DatagramSocket ds){
        this.ds = ds;
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while(true){
            try {
                if (!((line = br.readLine())!= null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if("886".equals((line))){
                break;
            }
            byte[] bys = line.getBytes();
//            DatagramPacket dp = new DatagramPacket(bys,bys.length,
//                    InetAddress.getByName("192.168.43.31"),12345);
            DatagramPacket dp = null;
            try {
                dp = new DatagramPacket(bys,bys.length,
                        InetAddress.getByName("192.168.43.255"),12306);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            try {
                ds.send(dp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ds.close();
    }
}
