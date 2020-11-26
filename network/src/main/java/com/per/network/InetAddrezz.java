package com.per.network;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description: TODO
 * @Author: lys
 * @Date: 2020-11-12 15:02
 * @Version: 1.3.*
 */
public class InetAddrezz {

    public static void main(String[] args) throws IOException {


        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println("inetAddress = " + inetAddress);//inetAddress = www.baidu.com/180.101.49.12

        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        System.out.println("loopbackAddress = " + loopbackAddress);//loopbackAddress = localhost/127.0.0.1

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("localHost = " + localHost);//localHost = WIN-HMTNBKG48RF/192.168.0.136

        //测试是否可以达到该地址
        boolean b = inetAddress.isReachable(1000);
        System.out.println(b);

        //InetAddress address = InetAddress.getByAddress("180.101.49.12");
    }
}
