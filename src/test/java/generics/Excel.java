package generics;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	/******* Getting Total Number of Rows *******/

	public static int getRowCount(String xlPath, String sheet) {
		int rowcount = 0;
		try 
		{
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			rowcount = wb.getSheet(sheet).getLastRowNum();

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return rowcount;
	}

	/******* Getting value of cell *******/

	public static String getCellValue(String xlPath, String sheet, int row,	int cell) 
	{
		String str = "";
		try 
		{
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			System.out.println("row: " + row + "  cell: " + cell);
			str = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
		return str;
	}
}