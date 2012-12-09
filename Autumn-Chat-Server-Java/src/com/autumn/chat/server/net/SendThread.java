package com.autumn.chat.server.net;    

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.autumn.chat.dataModule.AutumnPacket;
import com.autumn.chat.server.ui.MainWindow;

/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-11-30 下午11:33:49
 */
public class SendThread implements Runnable{
	private List<AutumnPacket> waitingForSendAutumnPackets;
	private Socket socket;
	private ClientKeeper clientKeeper;
	private boolean flag=false;
	public SendThread(ClientKeeper clientKeeper,boolean flag){
		waitingForSendAutumnPackets = new ArrayList<AutumnPacket>();
		this.clientKeeper = clientKeeper;
		socket = clientKeeper.getSock();
		this.flag = flag;
		MainWindow.getInstance().addInfo(socket.getInetAddress().getHostAddress(),"启动"+socket.getInetAddress().getHostAddress()+"发送线程");
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run() {
		while (flag) {
			if(getPackets().size()>0){
			BufferedOutputStream netOut;
				try {
					netOut = new BufferedOutputStream(clientKeeper.getSock().getOutputStream());
					ObjectOutputStream oos = new ObjectOutputStream(netOut);
					oos.writeObject(getWaitingForSendAutumnPackets());
					oos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
				}
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
	
	public void stop(){
		this.flag = false;
	}
	
}
  
