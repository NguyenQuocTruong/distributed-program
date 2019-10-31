package exampleThread.UDP;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class DatagramServer {
    public static void main(String[] args) {
        DatagramPacket datapacket, returnpacket;
        int port = 2018;
        int len = 1024;
        ArrayList<Integer> chan = new ArrayList<>();
        ArrayList<Integer> le = new ArrayList<>();

        try {
            DatagramSocket datasocket = new DatagramSocket(port);
            byte[] buf = new byte[len];
            datapacket = new DatagramPacket(buf, buf.length);
            while (true) {
                try {
                    datasocket.receive(datapacket);

                    String str[] = new String(datapacket.getData()).split(" ");
                    int num ;

                    sort(str);

                    returnpacket = new DatagramPacket(
                            datapacket.getData(),
                            datapacket.getLength(),
                            datapacket.getAddress(),
                            datapacket.getPort());
                    datasocket.send(returnpacket);
                } catch (IOException e) {
                    System.err.println("E1 = " + e);
                }
            }
        } catch (SocketException se) {
            System.err.println("E2 = " + se);
        }
    }

    private static void sort(String[] str){
        ArrayList<String> chan = new ArrayList<>();
        ArrayList<String> le = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        int num;

        for(int i = 0; i < str.length; i++){
            num = Integer.parseInt(str[i]);
            if(num % 2 == 0)
                chan.add(str[i]);
            else
                le.add(str[i]);
        }

        if(chan.size() == le.size()){
            int length = chan.size() + le.size();
            for (int i = 0; i < length; i++){
                result.add(chan.get(i));
                result.add(le.get(i));
            }
        }

        for(int i = 0; i< result.size(); i++ ){
            System.out.println(result.get(i));
        }
    }
}

