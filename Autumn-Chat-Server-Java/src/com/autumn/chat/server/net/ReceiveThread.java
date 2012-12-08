package com.autumn.chat.server.net;    

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.autumn.chat.dataModule.AutumnPacket;
import com.autumn.chat.server.ui.MainWindow;


/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-11-30 ÏÂÎç11:35:19
 */
public class ReceiveThread implements Runnable{
	private Socket socket;
	private ClientKeeper clientKeeper;
	private boolean flag=false;
	public ReceiveThread(ClientKeeper clientKeeper,boolean flag){
		this.clientKeeper = clientKeeper;
		this.flag = flag;
		socket = clientKeeper.getSock();
		Thread t = new Thread(this);
		t.start();
		System.out.println("con");
	}
	public void run() {
		System.out.println(flag);
			try {
				BufferedInputStream netIn = new BufferedInputStream(socket.getInputStream());
				ObjectInputStream oos = new ObjectInputStream(netIn);
				while (flag) {
					AutumnPacket au = (AutumnPacket) oos.readObject();
					dealPacket(au);
				}
				oos.close();
				netIn.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	public void dealPacket(AutumnPacket autumnPacket){
		MainWindow.getInstance().addInfo("id="+autumnPacket.getId());
		MainWindow.getInstance().addInfo("ip="+autumnPacket.getIp());
		MainWindow.getInstance().addInfo("type="+autumnPacket.getType());
		MainWindow.getInstance().addInfo("message="+autumnPacket.getMessage());
	}
}
  
