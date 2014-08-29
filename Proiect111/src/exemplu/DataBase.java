package exemplu;


import java.io.File;
import java.io.IOException;

import jxl.*;
import jxl.write.*;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import jxl.CellType;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class DataBase {
	private String user1;
	private String pass1;
	private String role1;

	public void createExl() throws IOException, WriteException{
	     	     
	    try {
	    	String fileName = "D:\\File.xls";
    		WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
    		WritableSheet sheet = workbook.createSheet("Sheet1", 0);
	   
	
	        Label label1 = new Label(0,0,"Role");
		    sheet.addCell(label1);
		    
		    Label label2 = new Label(1,0,"Username");
		    sheet.addCell(label2);
		    
		    Label label3 = new Label(2,0,"Password");
		    sheet.addCell(label3);
		  
		    workbook.write();
    		workbook.close(); 
	    } catch (WriteException e) {
	    }
	}
	
	
    public void writeExl(String role1,String user1,String pass1) throws IOException, WriteException, BiffException
    {
    	this.role1=role1;
    	this.user1=user1;
    	this.pass1=pass1;
   
    	
    	try {
    		String fileName = "D:\\File.xls";
    		String fileName1 = "D:\\File1.xls";
    		Workbook existingWorkbook = Workbook.getWorkbook(new File(fileName));
    		WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(fileName1), existingWorkbook);
    		WritableSheet sheet = workbookCopy.getSheet("Sheet1");
    		
    	
    		
    		
    		Label label1 = new Label(0,1,role1);
    		sheet.addCell(label1);
    		
    		Label label2 = new Label(1,1,user1);
    		sheet.addCell(label2);
    		
    		Label label3 = new Label(2,1,pass1);
    		sheet.addCell(label3);
    		
    		 workbookCopy.write();
    		 
    		 workbookCopy.close();
    		 existingWorkbook.close();
    		
    	
    	}catch (WriteException e){
    		
    	}
    }
    	
    public String readExl(int j,int i) throws IOException
    {
       	String fileName = "D:\\File1.xls"; 
       	System.out.println("succes1"); 
    	   try {
    	      Workbook workbook = Workbook.getWorkbook(new File(fileName));
    	      Sheet sheet = workbook.getSheet(0);
    	      
    	          Cell cell = sheet.getCell(j, i);
    	          CellType type = cell.getType();
    	          if (type == CellType.LABEL) {
      	            return cell.getContents();
      	          }
    	      
    		workbook.close();
    	      
    	    } catch (BiffException e) {
    	      e.printStackTrace();
    	    }
		return null;
    }
}