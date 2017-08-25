package com.cassca.utils;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cassca.constants.Calculation;
public class ParseExcel {
	private static LinkedHashMap<String,String> map =new LinkedHashMap();
	public static Map parseExcel_1(){
		File directory = new File("");
        String courseFile = null;
        try{
        	courseFile = directory.getCanonicalPath();
        }catch(IOException e){
        	e.printStackTrace();
        }
        File file = new File(courseFile+Calculation.EXCEL_PATH_NAME);
		try(InputStream is = new FileInputStream(file);){
			Workbook wb = new XSSFWorkbook(is);
			 Sheet sheet = wb.getSheetAt(0);
			// 得到总行数
			int rowNum = sheet.getLastRowNum();
			for (int i = 1; i <= rowNum; i++) {
				Row row = sheet.getRow(i);
				map.put(row.getCell(0).toString(), row.getCell(1).toString());
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return map;
	}
	public static void main(String[] args) {
		System.out.println(parseExcel_1());
	}
}
