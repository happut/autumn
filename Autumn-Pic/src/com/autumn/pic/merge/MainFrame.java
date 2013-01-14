/*
 * @(#)mainFrame.java 2013-1-14 ����01:09:37
 * Autumn-Pic
 * Copyright 2013 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.autumn.pic.merge;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * mainFrame
 * @author wfei
 * @version 1.0
 *
 */
public class MainFrame extends JFrame {
    /**
     * 
     */
    public MainFrame() {
        setJMenuBar(buildMenu());
        windowOption();
        JPanel jp = new JPanel();
        jp.setPreferredSize(new Dimension(100,100));
    }
    
    /**
     * �趨���ڲ���
     */
    private void windowOption() {
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    private JMenuBar buildMenu(){
        JMenuBar jbr  = new JMenuBar(); 
        JMenu jb = new JMenu("�ļ�");
        
        JMenuItem addPic = new JMenuItem("����ͼƬ");
        JMenuItem exit = new JMenuItem("�˳�");
        
        jb.insert(addPic,0);
        jb.insertSeparator(1);
        jb.insert(exit,2);
        jbr.add(jb);
        return jbr;
    }
}
