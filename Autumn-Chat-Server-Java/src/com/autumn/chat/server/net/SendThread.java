package com.autumn.chat.server.net;    

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.autumn.chat.server.dataModule.AutumnPacket;

/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-11-30 ÏÂÎç11:33:49
 */
public class SendThread implements Runnable{
	private List<AutumnPacket> waitingForSendAutumnPackets;
	private ClientKeeper clientKeeper;
	private boolean flag=false;
	public SendThread(ClientKeeper clientKeeper){
		waitingForSendAutumnPackets = new ArrayList<AutumnPacket>();
		this.clientKeeper = clientKeeper;
		
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run() {
		while (flag) {
			BufferedOutputStream netOut;
			try {
				netOut = new BufferedOutputStream(clientKeeper.getSock().getOutputStream());
				ObjectOutputStream oos = new ObjectOutputStream(netOut);
				oos.writeObject(getWaitingForSendAutumnPackets());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<AutumnPacket> getPackets(){
		return waitingForSendAutumnPackets;
	}
	
	public synchronized AutumnPacket getWaitingForSendAutumnPackets(){
		AutumnPacket autumnPacket = getPackets().get(0);
		getPackets().remove(0);
		return autumnPacket;
	}
	
	public void send(AutumnPacket autumnPacket){
		getPackets().add(autumnPacket);
	}
	
}
  
