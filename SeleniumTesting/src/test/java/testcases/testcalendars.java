package testcases;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testcalendars {
	
	static int targetDay=0,	targetMonth=0, targetYear=0;
	static int currentDay=0, currentMonth=0, currentYear=0;
	static int jumpMonthBy=0;
	static boolean increment=true;
	
	public static void getCurrentDayMonthYear() {
		Calendar cal = Calendar.getInstance();
		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH)+1;
		currentYear = cal.get(Calendar.YEAR);
	}
	
	public static void getTargetDayMonthYear(String date) {
		int firstIndex = date.indexOf("/");
		int lastIndex = date.lastIndexOf("/");
		String day = date.substring(0,firstIndex);
		targetDay = Integer.parseInt(day);
		String month = date.substring(firstIndex+1,lastIndex);
		targetMonth = Integer.parseInt(month);
		String year = date.substring(lastIndex+1,date.length());
		targetYear = Integer.parseInt(year);
	}
	
	public static void CalcMonthDif() {
		if ((targetMonth-currentMonth) > 0) {
			jumpMonthBy = targetMonth-currentMonth;
		}else {
			jumpMonthBy = currentMonth-targetMonth;
			increment = false;
		}
	}

	public static void main(String[] args) throws InterruptedException {

		String dateToSet = "16/08/2021";
		
		getCurrentDayMonthYear();
		System.out.println("Current Day: " + currentDay);
		System.out.println("Current Month: " + currentMonth);
		System.out.println("Current Year: " + currentYear);
		
		getTargetDayMonthYear(dateToSet);
		System.out.println();
		System.out.println("Target Day: " + targetDay);
		System.out.println("Target Month: " + targetMonth);
		System.out.println("Target Year: " + targetYear);
		
		CalcMonthDif();
		System.out.println();
		System.out.println(jumpMonthBy);
		System.out.println(increment);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://way2automation.com/way2auto_jquery/datepicker.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		
		for (int i=0; i<jumpMonthBy;i++) {
			if (increment) {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
			} else {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
			}
			Thread.sleep(1000);
		}
		
		driver.findElement(By.linkText(Integer.toString(targetDay))).click();
	}

}
