package com.autumn.chat.server.net;    

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.autumn.chat.dataModule.AutumnPacket;

/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-11-30 下午11:02:29
 */
public class ServerThread extends Thread{
	private String ip;
	private int port;
	private ServerSocket ss;
	private HashMap<String,ClientKeeper> clients;
	boolean flag=true;	
	public ServerThread(int listenPort) {
		clients = new HashMap<String, ClientKeeper>();
		port = listenPort;
	}
	
	@Override
	public void run(){
		try {
			// 初始化套接字
			ss = new ServerSocket(getPort());
			while (flag) {
				Socket s = ss.accept();
				clients.put(s.getInetAddress().getHostAddress(), new ClientKeeper(ss.accept()));
			}
		} catch (SocketException e) {
			e.printStackTrace();
			System.out.println("建立套接字错误");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("接收错误");
		}finally{
		}
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getPort() {
		return port;
	}
	
	public void stopServer(){
		flag = false;
	}
	
	public ServerSocket getServerSocket(){
		return ss;
	}
	
	public HashMap<String, ClientKeeper> getClients(){
		return clients;
	}
	
	public void dropClient(String ip){
		clients.get(ip).stopClient();
		clients.remove(ip);
	}
}
  
