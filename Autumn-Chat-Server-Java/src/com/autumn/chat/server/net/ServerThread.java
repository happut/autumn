package com.autumn.chat.server.net;    

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import com.autumn.chat.dataModule.AutumnPacket;

/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-11-30 ����11:02:29
 */
public class ServerThread extends Thread{
	private String ip;
	private int port;
	private ServerSocket ss;
	private List<ClientKeeper> clients;
	boolean flag=true;	
	public ServerThread(int listenPort) {
		clients = new ArrayList<ClientKeeper>();
		port = listenPort;
	}
	
	@Override
	public void run(){
		try {
			// ��ʼ���׽���
			ss = new ServerSocket(getPort());
			while (flag) {
				clients.add(new ClientKeeper(ss.accept()));
			}
		} catch (SocketException e) {
			e.printStackTrace();
			System.out.println("�����׽��ִ���");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("���մ���");
		}finally{
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
		System.out.println("�յ�����ϢΪ��"+autumnPacket.getMessage());
	}
	
	public void stopServer(){
		flag = false;
	}
}
  
