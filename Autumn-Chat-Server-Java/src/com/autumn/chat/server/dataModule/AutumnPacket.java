package com.autumn.chat.server.dataModule;    

import java.io.Serializable;

/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-11-30 下午10:56:12
 */
/**
 * 系统底层类-信息传输父类
 *
 */
public class AutumnPacket implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ip地址
	 */
	private String ip;
	/**
	 * id标示
	 */
	private String id;
	/**
	 * 消息内容
	 */
	private String Message;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
}
  
