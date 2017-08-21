package com.cassca.utils;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ParseExcel {
	private static Map<String,String> map =new HashMap();
	public static void parseExcel_1(String returnFilePath) throws IOException{
		File f = new File(returnFilePath);
		InputStream is = new FileInputStream(f);
		 Workbook wb = new XSSFWorkbook(is);
		 Sheet sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		Row row = sheet.getRow(0);
		//得到列数
		int colNum = row.getPhysicalNumberOfCells();
		for (int i = 0; i < rowNum; i++) {
			map.put(row.getCell(0).toString(), row.getCell(1).toString());
		}
		
	}
	public Map getHashMap(){
		return this.map;
	}
	
	
}
