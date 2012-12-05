package com.autumn.chat.server.net;    

import java.net.Socket;

import com.autumn.chat.server.ui.MainWindow;

/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-11-30 обнГ11:02:39
 */
public class ClientThread extends Thread{
	private Socket sock;
	public ClientThread(Socket socket){
		this.sock = socket;
		this.start();
	}
	public Socket getSock() {
		return sock;
	}
	public void setSock(Socket sock) {
		this.sock = sock;
	}
	
	@Override
	public void run(){
		MainWindow.getInstance().getInfo().setText("1");
	}
}
  
