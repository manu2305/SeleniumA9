package com.crm.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcelFile {
public static  String  readexcel(String s,int row,int colom) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\VtigerA9.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet(s);
	String data = sheet.getRow(row).getCell(colom).toString();
	return data;
}
}
