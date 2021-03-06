import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CopyExcel {
	String cellValue;
	static int row=1;
	public CopyExcel(String cellValue){
		this.cellValue = cellValue;
	}
	
	private static final String FILE_NAME = "C:/Users/janarn/Desktop/Data.xlsx";
    private static final String FILE_NAME1 = "C:/Users/janarn/Desktop/Data2.xlsx";
    
    
    public static void copyData(){
    	Workbook workbook1=null;
    	Workbook workbook2=null;
    	
    	List<List<CopyExcel>> list=new ArrayList<List<CopyExcel>>(); 
    	
    	try {
			FileInputStream excelFile1 = new FileInputStream(new File(FILE_NAME));
			FileInputStream excelFile2 = new FileInputStream(new File(FILE_NAME1));
			
			workbook1 = new XSSFWorkbook(excelFile1);
			workbook2 = new XSSFWorkbook(excelFile2);
			Sheet datatypeSheet1 =workbook1.getSheet("Datatypes in Java");
			Sheet datatypeSheet2 =workbook2.getSheet("Sheet3"); 
			Iterator<Row> iterator = datatypeSheet1.iterator();
            
            
            while (iterator.hasNext()) {
            	//String rowname="row"+row;

                Row currentRow = iterator.next();
                List<CopyExcel> rowname1=new ArrayList<CopyExcel>();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                   
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                    	System.out.print(currentCell.getStringCellValue()+" ");
                    	rowname1.add(new CopyExcel(currentCell.getStringCellValue()));
                       
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                    	System.out.print(String.valueOf(currentCell.getNumericCellValue()+" "));
                    	rowname1.add(new CopyExcel(String.valueOf(currentCell.getNumericCellValue())));
                
                }
                }
                System.out.println();
                list.add(rowname1);
            }
            System.out.println();
            int rowNum = datatypeSheet2.getLastRowNum()+1;
            
     	   for(List<CopyExcel> str: list){
     		  Row row = datatypeSheet2.createRow(rowNum++);
     		 int colNum = 0;
     			for(CopyExcel a:str){
     				 Cell cell = row.createCell(colNum++);
     				System.out.println(a.cellValue);
     				
                        cell.setCellValue((String) a.cellValue);
                        System.out.println(a.cellValue); 
                        System.out.println(a.cellValue);
                        System.out.println(a.cellValue);
                   
     				
     			}
     	   }
     	  FileOutputStream outputStream = new FileOutputStream(FILE_NAME1);
     	 workbook2.write(outputStream);
     	workbook2.close();
          
     	   
     	   
           
            
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	
    }

	public static void main(String[] args) {
		copyData();

	}

}
