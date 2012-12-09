package com.autumn.chat.server.ui;    

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.autumn.chat.server.net.ServerThread;

/** 
 * @author Happut-WangFei
 * @version 
 * @time 2012-12-5 ����09:02:01
 */
public class MainWindow extends JFrame{
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	private static MainWindow mainWindow;
	
	private JButton startButton;
	private JButton stopButton;
	private ServerThread serverThread;
	private Container container;
	private JTextField portText;
	
	private JTextArea infoArea;
	private JScrollPane infoScrollPane;
	private JPanel infoPanel;
	
	
	/**
	 * ������Ϣ����Ϣ��
	 * @param message
	 */
	public synchronized void addInfo(String ip,String message) {
		infoArea.setText(infoArea.getText()+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"("+ip+"):"+message+"\n");
	}
	private JPanel mainPanel;
	
	public MainWindow(){
		mainWindow = this;
		
		init();
		
		container.add(mainPanel,"North");
		container.add(infoPanel,"Center");
		
		windowOption();

	}
	/**
	 * �趨���ڲ���
	 */
	private void windowOption() {
		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	/**
	 * ��ȡ����ʵ��
	 * @return ���ش�����
	 */
	public static MainWindow getInstance() {
		if (mainWindow == null) {
			mainWindow = new MainWindow();
		}
		return mainWindow;
	}

	private void init() {
		portText = new JTextField(10);
		infoArea = new JTextArea();
		
		startButton = new JButton("�򿪷�����");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(portText.getText().equals("")){
					JOptionPane.showMessageDialog(getInstance(),"������˿ں�");
				}else {
					serverThread = new ServerThread(Integer.parseInt(portText.getText()));
					serverThread.start();
					startButton.setEnabled(false);
					stopButton.setEnabled(true);					
				}
			}
		});
		stopButton = new JButton("ֹͣ������");
		stopButton.setEnabled(false);
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serverThread.stopServer();
				startButton.setEnabled(true);
				stopButton.setEnabled(false);
			}
		});

		container = getContentPane();
		mainPanel = new JPanel();
		mainPanel.add(startButton);
		mainPanel.add(stopButton);
		mainPanel.add(portText);
		mainPanel.setBorder(BorderFactory.createTitledBorder("��������"));
		
		infoPanel = new JPanel();
		infoScrollPane = new JScrollPane(infoArea);
		infoScrollPane.setPreferredSize(new Dimension(500, 200));
		infoArea.setSize(300, 200);
		infoPanel.add(infoScrollPane);
		infoPanel.setBorder(BorderFactory.createTitledBorder("��Ϣ��"));
	}
	public static void main(String[] args) {
		new MainWindow();
	}
	
	
	public ServerThread getServerThread(){
		return serverThread;
	}
}
  
