package com.autumn.chat.server.net;    

import java.net.Socket;

import com.autumn.chat.server.ui.MainWindow;

/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-11-30 下午11:02:39
 */
public class ClientKeeper extends Thread{
	private Socket sock;
	public ClientKeeper(Socket socket){
		this.sock = socket;
		MainWindow.getInstance().addInfo("收到消息");
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
		MainWindow.getInstance().addInfo("1");
	}
}
  
