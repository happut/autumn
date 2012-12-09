package com.autumn.chat.server.net;    

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.net.ssl.SSLContext;

import com.autumn.chat.dataModule.AutumnPacket;
import com.autumn.chat.dataModule.Constants;
import com.autumn.chat.server.ui.MainWindow;


/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-11-30 下午11:35:19
 */
public class ReceiveThread implements Runnable{
	private Socket socket;
	private ClientKeeper clientKeeper;
	private boolean flag=false;
	public ReceiveThread(ClientKeeper clientKeeper,boolean flag){
		this.clientKeeper = clientKeeper;
		this.flag = flag;
		socket = clientKeeper.getSock();
		MainWindow.getInstance().addInfo(socket.getInetAddress().getHostAddress(),"启动"+socket.getInetAddress().getHostAddress()+"接收线程");
		Thread t = new Thread(this);
		t.start();
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
			} catch (EOFException e) {
				MainWindow.getInstance().addInfo(socket.getInetAddress().getHostAddress(),"发送端结束");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	public void dealPacket(AutumnPacket autumnPacket){
//		MainWindow.getInstance().addInfo(socket.getInetAddress().getHostAddress(),"id="+autumnPacket.getId()+"\n"+"ip="+autumnPacket.getIp()+"\n"+"type="+autumnPacket.getType()+"\n"+"message="+autumnPacket.getMessage()+"\n");
		switch (autumnPacket.getType()) {
		case Constants.TYPE_SYSTEM:
			dealSystemPacket(autumnPacket);
			break;
		case Constants.TYPE_CHAT:
			dealChatPacket(autumnPacket);
		default:
			break;
		}
	}
	
	public void stop(){
		this.flag = false;
	}
	
	private void dealSystemPacket(AutumnPacket autumnPacket) {
		String message = autumnPacket.getMessage();
		if (message.equals(Constants.SYSTEM_MESSAGE_ON)) {
			String serverIp = MainWindow.getInstance().getServerThread()
					.getServerSocket().getInetAddress().getHostName();
			clientKeeper.sendPacket(new AutumnPacket(Constants.SERVER_ID,
					serverIp, Constants.SYSTEM_MESSAGE_ON_CONFIRM,
					Constants.TYPE_SYSTEM));
		}else if(message.equals(Constants.SYSTEM_MESSAGE_OFF)){
			MainWindow.getInstance().getServerThread().dropClient(autumnPacket.getIp());
		}
	}

	private void dealChatPacket(AutumnPacket autumnPacket){
		
	}
}
  
