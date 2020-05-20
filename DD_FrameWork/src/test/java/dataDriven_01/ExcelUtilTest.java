package dataDriven_01;

import org.testng.annotations.Test;

import Utilitis.ExcelUtil;

public class ExcelUtilTest {
	@Test
	public void ExDataTest() throws Exception {

		ExcelUtil obj = new ExcelUtil("C:\\Users\\Ifte\\elips2020\\DD_FrameWork\\TestData\\data.xlsx");

		System.out.println(obj.getData(0, 0, 0));	
		

	}

}
