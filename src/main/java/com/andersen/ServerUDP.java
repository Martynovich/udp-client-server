package com.andersen;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerUDP {
	public static void main(String[] args) throws IOException {
		DatagramSocket serverSocket = new DatagramSocket(1050);
        byte[] receiveData = new byte[512];
        byte[] sendData = new byte[512];
        while(true)
           {
              DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
              serverSocket.receive(receivePacket);
              String sentence = new String( receivePacket.getData());
              System.out.println("RECEIVED: " + sentence);
              InetAddress IPAddress = receivePacket.getAddress();
              int port = receivePacket.getPort();
              sentence = sentence.substring(0, 5);
              String request = sentence + " from server.";
              sendData = request.getBytes();
              DatagramPacket sendPacket =
              new DatagramPacket(sendData, sendData.length, IPAddress, port);
              serverSocket.send(sendPacket);
           }
	}

}
