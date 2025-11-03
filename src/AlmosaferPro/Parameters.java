package AlmosaferPro;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
	WebDriver driver= new ChromeDriver();

	Random rand= new Random();

	String TheDefaultURL="https://www.almosafer.com/en";
	String ExpectedEnglishLanguage= "en";
	String ExpectedArabicLanguage= "ar";


	String ExpectedCurrency= "SAR";
	String ExpectedobileNumber= "+966554400000";
	boolean ExpectedQitafLogoDisplay= true;
	String ExpectedValueForHotelTab="false";
	LocalDate date= LocalDate.now();
	int Today=date.getDayOfMonth();
	String Tomorrow= Integer.toString(date.plusDays(1).getDayOfMonth());
	String ReturnDay =Integer.toString(date.plusDays(2).getDayOfMonth());

	String[] Websites= {"https://www.almosafer.com/en", "https://www.almosafer.com/ar"};

	int RandomIndexForWebsite= rand.nextInt(Websites.length);

	String[] EnglishCities= {"Dubai","Jeddah","Riyadh"};
	int RandomEnglishCity=rand.nextInt(EnglishCities.length);

	String[] ArabicCities= {"جدة","دبي"};
	int RandomArabicCity=rand.nextInt(ArabicCities.length);
	
	boolean ExpectedResult=true;







	public void ConfigurationToAccess() {
		driver.get(TheDefaultURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement SuadiArabia= driver.findElement(By.id("mui-4"));
		
		SuadiArabia.click();
		
		
	}
}
