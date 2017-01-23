package com.andersen;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP {
	
	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket = new DatagramSocket();
			InetAddress address = InetAddress.getByName("localhost");
			String request = "Hello";
			byte[] sendData = request.getBytes();
			byte[] receiveData = new byte[512];
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, 1050);
			datagramSocket.send(sendPacket);
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			datagramSocket.receive(receivePacket);
			String stringFromServer = new String(receivePacket.getData());
			System.out.println(stringFromServer);
			datagramSocket.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}


