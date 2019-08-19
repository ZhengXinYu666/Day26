package Net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 如果一个类没有发偶早方法
 *
 * 1、成员全部是静态的（Math,Arrays,Coolections）
 * 2、单例设计模式(Runtime)
 * 3、类中有静态方法返回该类的对象(InetAddres)
 *
 *
 * InetAddress成员方法
 * public static InetAddress getByName(String host)
 * 根据主机名或者IP地址的对象
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("127.0.0.1");

        //获取两个东西：主机名+IP地址
        String name = address.getHostName();
        String ip = address.getHostAddress();
        System.out.println(name+"---"+ip);
    }
};
