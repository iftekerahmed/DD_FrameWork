package dataDriven_01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Utilitis.ExcelUtil;

public class ReadExcelData_Application {
	WebDriver driver;

	@Test
	public void readDataApplication() throws Exception {
		{

			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://demo.automationtesting.in/Register.html");

			ExcelUtil obj = new ExcelUtil("C:\\Users\\Ifte\\elips2020\\DD_FrameWork\\TestData\\HalfEbayTestData.xlsx");
			int rowc = obj.rowCount("Sheet1");
			for (int i = 1; i <rowc;i++) {
			
			
			String fnam = obj.getData("Sheet1", i, "firstname");
			System.out.println(fnam);
			String lnam = obj.getData("Sheet1", i, "lastname");
			System.out.println(lnam);
			String address = obj.getData("Sheet1", i, "address");
			System.out.println(address);
			String email = obj.getData("Sheet1", i, "email");
			System.out.println(email);
			String phone = obj.getData("Sheet1", i, "phone");
			System.out.println(phone);
			String gender = obj.getData("Sheet1", i, "gender");
			System.out.println(gender);
			String hobbies = obj.getData("Sheet1", i, "hobbies");
			System.out.println(hobbies);
			String coun = obj.getData("Sheet1", i, "county");
			System.out.println(coun);
			String day = obj.getData("Sheet1", i, "day");
			System.out.println(day);

			String month = obj.getData("Sheet1", i, "month");
			System.out.println(month);
			String year = obj.getData("Sheet1", i, "year");
			System.out.println(year);
			String password = obj.getData("Sheet1", i, "password");
			System.out.println(password);

			driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(fnam);
			driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lnam);
			driver.findElement(By.tagName("textarea")).sendKeys(address);
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);			
			driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(phone);
			//input[@value='Male'] 
			driver.findElement(By.xpath("//input[@value='FeMale']")).click();
			//driver.findElement(By.xpath("//input[@value="+"'"+gender+"'"+"]")).click();		
			//driver.findElement(By.xpath("//label[contains(text(),"+"'"+hobbies+"'"+"]/..input")).click();
			
			driver.findElement(By.xpath("//input[@value='Cricket']")).click();

			Select country = new Select(driver.findElement(By.xpath("//select[@id='countries']")));
			country.selectByVisibleText(coun);

			Select year_main = new Select(driver.findElement(By.id("yearbox")));
			year_main.selectByVisibleText(year);

			Select month_main = new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")));
			month_main.selectByVisibleText(month);

			Select day_main = new Select(driver.findElement(By.id("daybox")));
			day_main.selectByVisibleText(day);

			Select pass_main = new Select(driver.findElement(By.id("firstpassword")));
			pass_main.selectByVisibleText(password);

			Select pass_main2 = new Select(driver.findElement(By.id("secondpassword")));
			pass_main.selectByVisibleText(password);

			driver.findElement(By.id("submitbtn")).click();
			obj.writeData("Sheet1", 1, "status", "pass");
			}

	}
}}
