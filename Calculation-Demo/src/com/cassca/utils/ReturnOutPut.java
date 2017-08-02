package com.cassca.utils;
import java.io.File;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.filechooser.FileSystemView;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.cassca.ret.ReturnConstant;

public class ReturnOutPut {
	public static String outPutReturn(List<String> list,String fileName){
		if (ReturnConstant.I18ARNAME.equals(fileName)) {
			
		}else if(ReturnConstant.I18ENGNNAME.equals(fileName)){
			return doOutPutReturn(list, fileName);
		}
		return "SUCCESS";
	}
	
	public static String doOutPutReturn(List<String> list,String fileName){
		int i=0;
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File com=fsv.getHomeDirectory();    //这便是读取桌面路径的方法了
		String deskPath=com.getPath();
		String directory_name=deskPath+File.separatorChar+ReturnConstant.FILENAME+DateFormatUtils.format(new Date(), "yyyy-MM-dd-HH:mm:ss").trim();
		File directory= new File(directory_name);
		File file_name=null;
		if (!directory.exists()) {
			
			directory.mkdir();
		}
		file_name=new File(directory+fileName);
		try(
				OutputStream os=new FileOutputStream(file_name);
				BufferedOutputStream buf=new BufferedOutputStream(os);
				){
			
			for (String i18n_str : list) {
				buf.write(i18n_str.getBytes());
			}
		}catch(IOException e){
			e.printStackTrace();
			i=-1;
		}
		
		return i==-1?"FAILED":"SUCCESS";
		
		
	}
	
	public static void main(String[] args) {
		
	}
}
