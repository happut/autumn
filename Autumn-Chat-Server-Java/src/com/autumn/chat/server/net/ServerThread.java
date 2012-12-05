package com.autumn.chat.server.net;    

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.StartDocument;

import com.autumn.chat.server.dataModule.AutumnPacket;

/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-11-30 下午11:02:29
 */
public class ServerThread extends Thread{
	private String ip;
	private int port;
	private ServerSocket ss;
	private List<ClientThread> clients;
	boolean flag;	
	public ServerThread(int listenPort) {
		clients = new ArrayList<ClientThread>();
		flag = true;
	}
	
	@Override
	public void run(){
		try {
			// 初始化套接字
			ss = new ServerSocket(getPort());
			while (flag) {
				clients.add(new ClientThread(ss.accept()));
			}
		} catch (SocketException e) {
			e.printStackTrace();
			System.out.println("建立套接字错误");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("接收错误");
		}		
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getPort() {
		return port;
	}
	
	public ServerThread getInstance(){
		return this;
	}
	
	public void dealMessage(AutumnPacket autumnPacket) {
		System.out.println("收到的消息为："+autumnPacket.getMessage());
	}
	
	public void stopServer(){
		flag = false;
	}
}
  
