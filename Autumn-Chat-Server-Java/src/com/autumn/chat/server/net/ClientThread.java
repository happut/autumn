package com.autumn.chat.server.net;    

import java.net.Socket;

/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-11-30 обнГ11:02:39
 */
public class ClientThread extends Thread{
	private Socket sock;
	public ClientThread(Socket socket){
		this.sock = socket;
	}
	public Socket getSock() {
		return sock;
	}
	public void setSock(Socket sock) {
		this.sock = sock;
	}
	
	
}
  
