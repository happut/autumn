package com.autumn.pic.merge;

import java.util.List;

import javax.swing.JPanel;

/**
 * @author Happut-WangFei
 * @version
 * @time 2013-1-14 обнГ11:29:02
 */
public class ListPanel extends JPanel {
	public List<ListItemPanel> list;
	private static ListPanel instance;

	public ListPanel() {
		instance = this;
	}

	public static ListPanel getInstance() {
		if (instance == null) {
			instance = new ListPanel();
		}
		return instance;
	}
}
