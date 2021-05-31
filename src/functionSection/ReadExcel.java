package functionSection;

//Import Section

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {

	//Create void Method with IOException
	public void leerExcel(String strFilePath, String strFileName, String strSheetName) throws IOException
	{
		//Create an object of File class to open xlsx file
		File objFile = new File(strFilePath + "\\" + strFileName);
		
		//Create an object of FileInputStream class to read excel file
		FileInputStream objInputData = new FileInputStream(objFile);
		
		//Define Woorkbook object as NULL
		Workbook objWorkbook = null;
		
		//Find the file extension by splitting file name in substring and getting only extension name
		String fileExtensionName = strFileName.substring(strFileName.indexOf("."));
		
		//Check condition if the file is XLSX file
		if(fileExtensionName.equals(".xlsx"))
		{
			//if it is xlsx file then create object of XSSFWorkbook class
			objWorkbook = new XSSFWorkbook(objInputData);
		}else{
			//If it is XLS then create the object of HSSFWorkbook class
			objWorkbook = new HSSFWorkbook(objInputData);
		}
		
		//Read sheet inside the workbook by its name
		Sheet objSheet = objWorkbook.getSheet(strSheetName);
		
		//Find the total number of rows in the excel file
		int iRowCount = objSheet.getLastRowNum()-objSheet.getFirstRowNum();
		
		//Create a loop over all the rows of excel file to read it
		
		for(int iCounter = 0; iCounter < iRowCount + 1; iCounter++)
		{
			//Set the row one by one
			Row iRow = objSheet.getRow(iCounter);
			
			//Loop to print the values in the cell
			for(int j = 0; j < iRow.getLastCellNum(); j++)
			{
				//Print Excel data in console
				System.out.print(iRow.getCell(j).getStringCellValue()+" || ");
			}
			
			//Space in the cell
			System.out.println();
		}			
	}
	
	//Main function is calling readExcel function to read data from excel file
	public static void main(String...strings) throws IOException{
		
		//Create an object of ReadExcelFile class
		ReadExcel objExcelFile = new ReadExcel();
		
		//Prepare the path of Excel file
		//String filePath = System.getProperty("user.dir")+ "\\src\\functionSection";
		String filePath = System.getProperty("user.dir")+ "\\src\\dataStorage";
		
		//Call read file method of the class to read data
		objExcelFile.leerExcel(filePath, "testExcel.xlsx", "information");
	}
	
	public void loadData(String strExcelName) throws IOException{

		//Variable Declaration
		String filePath = "\\src\\dataStorage\\";
		
		//Adding the Correct Format to the value
		strExcelName = strExcelName+".xlsx";
		
		//Create an object of ReadExcelFile class
		ReadExcel objExcelFile = new ReadExcel();
		
		//Prepare the path of Excel File
		filePath = System.getProperty("user.dir") + filePath;
		
		//Call read File method of the class to read data
		objExcelFile.leerExcel(filePath, strExcelName, "information");
	}
	
	//Send info as String
	public String setData(String strExcelName) throws IOException{

		//Variable Declaration
		String filePath = "\\src\\dataStorage\\";
		
		//Adding the Correct Format to the value
		strExcelName = strExcelName+".xlsx";
		
		//Create an object of ReadExcelFile class
		ReadExcel objExcelFile = new ReadExcel();
		
		//Prepare the path of Excel File
		filePath = System.getProperty("user.dir") + filePath;
		
		//Call read File method of the class to read data
		objExcelFile.leerExcel(filePath, strExcelName, "information");
		String Value = "exit";
		return Value;
	}
	
	public void loadData2(String strExcelName) throws IOException{

		//Variable Declaration
		String filePath = "\\src\\dataStorage\\";
		
		//Adding the Correct Format to the value
		strExcelName = strExcelName+".xlsx";
		
		//Create an object of ReadExcelFile class
		ReadExcel objExcelFile = new ReadExcel();
		
		//Prepare the path of Excel File
		filePath = System.getProperty("user.dir") + filePath;
		
		//Call read File method of the class to read data
		//objExcelFile.leerExcel2(filePath, strExcelName, "information");
	}
	
	//As a Object
	//public static Object leerExcel2(String strFilePath, String strFileName, String strSheetName) throws IOException
	public static Object [][] leerExcel(String strExcelName) throws IOException
	{
		
		//Variable Declaration
		String filePath = "\\src\\dataStorage\\";
				
		//Adding the Correct Format to the value
		String strFileName = strExcelName+".xlsx";
				
		//Create an object of ReadExcelFile class
		//ReadExcel objExcelFile = new ReadExcel();
				
		//Prepare the path of Excel File
		filePath = System.getProperty("user.dir") + filePath;
				
		//Create an Array object to storage the information
		String [][] arrTable = null;
		
		//Create an object of File class to open xlsx file
		File objFile = new File(filePath + "\\" + strFileName);
		
		//Create an object of FileInputStream class to read excel file
		FileInputStream objInputData = new FileInputStream(objFile);
		
		//Define Woorkbook object as NULL
		Workbook objWorkbook = null;
		
		//Find the file extension by splitting file name in substring and getting only extension name
		String fileExtensionName = strFileName.substring(strFileName.indexOf("."));
		
		//Check condition if the file is XLSX file
		if(fileExtensionName.equals(".xlsx"))
		{
			//if it is xlsx file then create object of XSSFWorkbook class
			objWorkbook = new XSSFWorkbook(objInputData);
		}else{
			//If it is XLS then create the object of HSSFWorkbook class
			objWorkbook = new HSSFWorkbook(objInputData);
		}
		
		//Read sheet inside the workbook by its name
		Sheet objSheet = objWorkbook.getSheet("Sheet1");//Default Sheet1
		
		//Find the total number of rows in the excel file
		int iRowCount = objSheet.getLastRowNum()-objSheet.getFirstRowNum();
		//int iRowCount = objSheet.getLastRowNum();
		
		//Find the total number of columns in the excel file
		int iColCount = objSheet.getRow(0).getLastCellNum();
		
		//Define the array information
		arrTable = new String[iRowCount][iColCount];
		
		//Create a loop over all the rows of excel file to read it
		for(int iCounter = 0; iCounter < iRowCount; iCounter++)
		{
			//Set the row one by one
			Row iRow = objSheet.getRow(iCounter+1);
			
			//Loop to print the values in the cell
			for(int jCounter = 0; jCounter < iRow.getLastCellNum(); jCounter++)
			{
				//Print Excel data in console
				//System.out.print(iRow.getCell(jCounter).getStringCellValue()+" || ");
				arrTable[iCounter][jCounter] = iRow.getCell(jCounter).getStringCellValue();
				System.out.println(" Data stored -> " + arrTable[iCounter][jCounter]);
			}
			
			//Space in the cell
			System.out.println();
		}
		return (arrTable);			
	}
}
