package dataDriven_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import Utilitis.ExcelUtil;

public class removeSheet {
	@Test
	public void removeSheet1() throws Exception {

		ExcelUtil obj = new ExcelUtil("C:\\Users\\Ifte\\elips2020\\DD_FrameWork\\TestData\\data.xlsx");

		int index = obj.getsheetIndex("Sheet3");
		obj.removesheetIndex(index);

	}

}
