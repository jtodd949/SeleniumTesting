package parameterization;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testparamexcel {

	static String projpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static int getRowCount() {
		int rowcount =0;
		try {
			projpath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook("C:\\Users\\jordan.todd\\eclipse-workspace\\SeleniumTesting\\excel\\userpw.xlsx");
			workbook.getSheet("Sheet1");
			rowcount = sheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		System.out.println("rows " + rowcount);
		return rowcount;
	}
	
	public static int getColCount() {
		int colcount = 0;
		try {
			projpath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projpath + "\\excel\\userpw.xlsx");
			workbook.getSheet("Sheet1");
			colcount = sheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		System.out.println("cols " + colcount);
		return colcount;
	}

	public static String getCellData(int row, int col) {
		String cell = null;
		try {
			projpath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projpath + "\\excel\\userpw.xlsx");
			workbook.getSheet("Sheet1");
			cell = sheet.getRow(row).getCell(col).getStringCellValue();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		System.out.println(cell);
		return cell;
	}

	@DataProvider
	public static Object[][] getData() {
		Object[][] data = new Object[getRowCount()][getColCount()];
		
		for (int rowNum=1; rowNum<=getRowCount(); rowNum++) {
			for (int colNum = 0; colNum<getColCount(); colNum++) {
				data[rowNum][colNum] = getCellData(rowNum,colNum);
			}
		}
		return data;
	}

	@Test(dataProvider = "getData")
	public void testData(String username, String password) {
		System.out.println(username + " --- " + password);

	}
}
