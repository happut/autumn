package com.autumn.pic.utils;    

import java.io.File;

/** 
 * @author Happut-WangFei
 * @version 
 * @time 2013-1-14 ÏÂÎç11:10:46
 */
public class FileUtils {
    public static String getExtensionName(File f) {   
    	String filename = f.getName();
        if ((filename != null) && (filename.length() > 0)) {   
            int dot = filename.lastIndexOf('.');   
            if ((dot >-1) && (dot < (filename.length() - 1))) {   
                return filename.substring(dot + 1);   
            }   
        }   
        return filename;   
    }  
}
  
