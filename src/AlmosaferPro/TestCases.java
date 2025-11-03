package AlmosaferPro;

import java.util.List;
import java.lang.module.Configuration;
import java.time.Duration;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
public class TestCases extends Parameters{
	@BeforeTest
	public void mysetup() {
		
		ConfigurationToAccess();
	}
	
	
	
	@Test(priority = 1)
	public void CheckTheDefaultLanguageIsEnglish() {
		String ActualLanguage= driver.findElement(By.tagName("html")).getDomAttribute("lang");
		Assert.assertEquals(ActualLanguage, ExpectedEnglishLanguage);
	}
	
	@Test(priority = 2)
	public void CheckTheDefaultCurrency() {
		String ActualCurrency=driver.findElement(By.xpath("//div[@data-testid='Header__CurrencySelector']")).getText();
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
		System.out.println(ActualCurrency);
	
	}
	
	@Test(priority = 3)
	public void CheckTheMobileNumber() {
		String ActualMobileNumber=driver.findElement(By.xpath("//div[@style='direction:ltr;order:1']")).getText();
		System.out.println(ActualMobileNumber);
		Assert.assertEquals(ActualMobileNumber, ExpectedobileNumber);
		
	
	}
	
	@Test(priority = 4)
	public void CheckQitafLogo() {

		WebElement TheFooter= driver.findElement(By.tagName("footer"));
		WebElement ThecontainerDiv= TheFooter.findElement(By.className("alm-desktop-1mqexmc-acceptedCards"));
		WebElement QitafLogo= ThecontainerDiv.findElement(By.cssSelector("img[alt='qitaf']"));
		boolean ActualQitafLogoDisplay= QitafLogo.isDisplayed();
		System.out.println(ActualQitafLogoDisplay);
		Assert.assertEquals(ActualQitafLogoDisplay, ExpectedQitafLogoDisplay);

	
	}
	
	@Test(priority = 5)
	public void CheckHotelIsNotSelected() {

		WebElement HotelTab= driver.findElement(By.id("tab-hotels"));
		String ActualValueForHotelTab= HotelTab.getDomAttribute("aria-selected");
		Assert.assertEquals(ActualValueForHotelTab, ExpectedValueForHotelTab);
	
	}
	
	
	

	@Test(priority = 6)
	public void CheckReturnDate() {
		
		WebElement arrivalInput = driver.findElement(By.xpath("//div[@data-testid='testIdPickerPrefix__DatePicker__DepartureDate']//input"));

		String ActualDate = arrivalInput.getDomAttribute("value");
		
		String ActualDepartureDay = ActualDate.split(", ")[1].split(" ")[0];
		System.out.println(ActualDepartureDay);
		System.out.println(Tomorrow);
		Assert.assertEquals(ActualDepartureDay, Tomorrow);
		
		
	}
	
	
	@Test(priority = 7)
	public void CheckDepartureDate() {
		
		WebElement arrivalInput = driver.findElement(By.xpath("//div[@data-testid='testIdPickerPrefix__DatePicker__ArrivalDate']//input"));

		String ActualDate = arrivalInput.getDomAttribute("value");
//		List<WebElement> simpler = driver.findElements(
//				  By.tagName("div")
//				);
		String ActualReturnDay = ActualDate.split(", ")[1].split(" ")[0];
		System.out.println(ActualReturnDay);
		System.out.println(ReturnDay);
		Assert.assertEquals(ActualReturnDay, ReturnDay);
		
		
	
	}
	
	@Test(priority = 8)
	public void RandomlyChangeWebsiteLanguage() throws InterruptedException {
		
		driver.get(Websites[RandomIndexForWebsite]);
		WebElement HotelTab= driver.findElement(By.id("tab-hotels"));
		HotelTab.click();
		WebElement SearchInput= driver.findElement(By.id("DesktopSearchWidget_Destination_InputField_Test_Id"));

		if(driver.getCurrentUrl().contains("en")) {
			String ActualLanguage= driver.findElement(By.tagName("html")).getDomAttribute("lang");
			Assert.assertEquals(ActualLanguage, ExpectedEnglishLanguage);
			SearchInput.sendKeys(EnglishCities[RandomEnglishCity]);
			
			List<WebElement> options = driver.findElements(By.xpath("//div[@style][contains(@style,'cursor: pointer')]"));
			options.get(0).click();

		

		
		}else {
			String ActualLanguage= driver.findElement(By.tagName("html")).getDomAttribute("lang");
			Assert.assertEquals(ActualLanguage, ExpectedArabicLanguage);
			SearchInput.sendKeys(ArabicCities[RandomArabicCity]);
			List<WebElement> options = driver.findElements(By.xpath("//div[@style][contains(@style,'cursor: pointer')]"));
			options.get(0).click();

		
		}
		WebElement element = driver.findElement(By.id("mui-4"));
		element.click();
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.cssSelector("div.MuiTypography-root.MuiTypography-body1.__ds__comp"));

		int randomIndex = rand.nextInt(2);
		options.get(randomIndex).click();
		WebElement SearchButton= driver.findElement(By.cssSelector(".MuiTypography-root.MuiTypography-heading3SemBld.__ds__comp"));
		SearchButton.click();
		Thread.sleep(15000);
		WebElement Results= driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']"));
		System.out.println(Results.getText() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		boolean ActualResult = Results.getText().contains("stays") || Results.getText().contains("مكان");
		Assert.assertEquals(ActualResult, ExpectedResult);
				
	}
	

}
