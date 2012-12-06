package com.autumn.chat.server.net;    

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.autumn.chat.server.dataModule.AutumnPacket;


/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-11-30 ÏÂÎç11:35:19
 */
public class ReceiveThread implements Runnable{
	private List<AutumnPacket> waitingForReadAutumnPackets;
	private ClientKeeper clientKeeper;
	private boolean flag=false;
	public ReceiveThread(ClientKeeper clientKeeper){
		waitingForReadAutumnPackets = new ArrayList<AutumnPacket>();
		this.clientKeeper = clientKeeper;
		
		
		Thread t = new Thread(this);
		t.start();
	}
	public void run() {
		while (flag) {
			BufferedInputStream netIn;
			try {
				netIn = new BufferedInputStream(clientKeeper.getSock().getInputStream());
				ObjectInputStream oos = new ObjectInputStream(netIn);
				waitingForReadAutumnPackets.add((AutumnPacket) oos.readObject());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<AutumnPacket> getPackets(){
		return waitingForReadAutumnPackets;
	}
	
	public synchronized AutumnPacket receive(){
		AutumnPacket autumnPacket = getPackets().get(0);
		getPackets().remove(0);
		return autumnPacket;
	}
	
	public static void main(String[] args) {
	}
}
  
