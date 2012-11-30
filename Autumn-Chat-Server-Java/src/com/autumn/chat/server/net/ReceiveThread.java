package com.autumn.chat.server.net;    

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
	private ClientThread clientThread;
	private boolean flag=false;
	public ReceiveThread(ClientThread clientThread){
		waitingForReadAutumnPackets = new ArrayList<AutumnPacket>();
		this.clientThread = clientThread;
		
		
		Thread t = new Thread(this);
		t.start();
	}
	public void run() {
		while (flag) {
			BufferedInputStream netOut;
			try {
				netOut = new BufferedInputStream(clientThread.getSock().getInputStream());
				ObjectInputStream oos = new ObjectInputStream(netOut);
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
  
