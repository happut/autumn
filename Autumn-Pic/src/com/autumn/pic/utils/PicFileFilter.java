package com.autumn.pic.utils;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * @author Happut-WangFei
 * @version
 * @time 2013-1-14 ÏÂÎç11:14:29
 */
public class PicFileFilter extends FileFilter {

	public boolean accept(File path) {
		if (FileUtils.getExtensionName(path).equals("gif")||FileUtils.getExtensionName(path).equals("jpg")
				|| path.isDirectory())
			return true;

		return false;
	}

	public String getDescription() {
		return "Í¼ÏñÎÄ¼þ";
	}
             

}
  
