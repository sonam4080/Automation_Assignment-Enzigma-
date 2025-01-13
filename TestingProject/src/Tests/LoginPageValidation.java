package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageValidation {

	WebDriver driver = new ChromeDriver();

	public void operbrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_drivers\\chromedriver.exe");
		
		driver.navigate().to("https://app-staging.nokodr.com/");
		driver.manage().window().maximize();

	}

	public void testValidLogin() throws InterruptedException {
		Thread.sleep(2000);
		WebElement user_name = driver.findElement(By.name("username"));
		user_name.sendKeys("sonam3890rajput@gmail.com");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pass_word = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/login/abx-auth-container/div/div[2]/div/abx-login/div/abx-tabs/div/div/abx-tab[1]/div/div/abx-tabs/div/div/abx-tab[1]/div/div/abx-form/div/div/abx-container/div/div/div/span[2]/abx-layout-item/div/abx-field/div/div/div/div[1]/abx-password/div/div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(pass_word));
		pass_word.sendKeys("Avinash@1998");
		Thread.sleep(2000);
		WebElement password_show = driver.findElement(By.xpath("//*[@id=\"showButton\"]"));
		password_show.click();
		Thread.sleep(2000);
		WebElement Login = driver.findElement(By.xpath("//div[@title='Log In']"));
		Login.click();
		WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("dashboard")));
		assertTrue(dashboard.isDisplayed(), "Dashboard should be visible after login");

	}

	public void testInvalidLoginWithIncorrectUsername() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement error_Message = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[6]/section/abx-toaster/div/div")));
		String expected_Text = "Invalid Email or Password";
		String error_Text = error_Message.getText();
		assertTrue(error_Message.isDisplayed(), "Error message not displayed. Invalid username.");
		assertEquals(expected_Text, error_Text, "Error message text does not match.");
	}

	public void testInvalidLoginWithBlankFields() throws InterruptedException

	{
		Thread.sleep(2000);
		WebElement user_name = driver.findElement(By.name("username"));
		user_name.sendKeys("");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pass_word = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/login/abx-auth-container/div/div[2]/div/abx-login/div/abx-tabs/div/div/abx-tab[1]/div/div/abx-tabs/div/div/abx-tab[1]/div/div/abx-form/div/div/abx-container/div/div/div/span[2]/abx-layout-item/div/abx-field/div/div/div/div[1]/abx-password/div/div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(pass_word));
		pass_word.sendKeys("");
		Thread.sleep(2000);
		WebElement Login = driver.findElement(By.xpath("//div[@title='Log In']"));
		Login.click();
		WebElement error_Message = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[6]/section/abx-toaster/div/div")));
		assertTrue(error_Message.isDisplayed(), "Error message not displayed. Invalid username.");
		assertEquals("Please enter email", error_Message.getText(), "Error message text does not match.");
	}

	public void testInvalidLoginWithSpecialCharacters() throws InterruptedException

	{
		Thread.sleep(2000);
		WebElement user_name = driver.findElement(By.name("username"));
		user_name.sendKeys("user!@#");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pass_word = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/login/abx-auth-container/div/div[2]/div/abx-login/div/abx-tabs/div/div/abx-tab[1]/div/div/abx-tabs/div/div/abx-tab[1]/div/div/abx-form/div/div/abx-container/div/div/div/span[2]/abx-layout-item/div/abx-field/div/div/div/div[1]/abx-password/div/div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(pass_word));
		pass_word.sendKeys("password@123");
		Thread.sleep(2000);
		WebElement Login = driver.findElement(By.xpath("//div[@title='Log In']"));
		Login.click();
		WebElement error_Message = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[6]/section/abx-toaster/div/div")));
		assertTrue(error_Message.isDisplayed(), "Error message not displayed. Invalid username.");
		assertEquals("Please enter a valid email", error_Message.getText(), "Error message text does not match.");
	}

	public void testPasswordLengthValidation() throws InterruptedException

	{
		Thread.sleep(2000);
		WebElement user_name = driver.findElement(By.name("username"));
		user_name.sendKeys("ashwini");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pass_word = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/login/abx-auth-container/div/div[2]/div/abx-login/div/abx-tabs/div/div/abx-tab[1]/div/div/abx-tabs/div/div/abx-tab[1]/div/div/abx-form/div/div/abx-container/div/div/div/span[2]/abx-layout-item/div/abx-field/div/div/div/div[1]/abx-password/div/div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(pass_word));
		pass_word.sendKeys("password");
		Thread.sleep(2000);
		WebElement Login = driver.findElement(By.xpath("//div[@title='Log In']"));
		Login.click();
		WebElement error_Message = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[6]/section/abx-toaster/div/div")));
		assertTrue(error_Message.isDisplayed(), "Error message not displayed. Invalid username.");
		assertEquals("Password must be at least 8 characters", error_Message.getText(),
				"Error message text does not match.");
	}

	public void testPasswordFormatValidation() throws InterruptedException

	{
		Thread.sleep(2000);
		WebElement user_name = driver.findElement(By.name("username"));
		user_name.sendKeys("ashwini");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pass_word = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/login/abx-auth-container/div/div[2]/div/abx-login/div/abx-tabs/div/div/abx-tab[1]/div/div/abx-tabs/div/div/abx-tab[1]/div/div/abx-form/div/div/abx-container/div/div/div/span[2]/abx-layout-item/div/abx-field/div/div/div/div[1]/abx-password/div/div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(pass_word));
		pass_word.sendKeys("password");
		Thread.sleep(2000);
		WebElement Login = driver.findElement(By.xpath("//div[@title='Log In']"));
		Login.click();
		WebElement error_Message = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[6]/section/abx-toaster/div/div")));
		assertTrue(error_Message.isDisplayed(), "Error message not displayed. Invalid username.");
		assertEquals("Password must contain at least one number and one special character", error_Message.getText(),
				"Error message text does not match.");
	}

	public void closebrowser() {

		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {

		LoginPageValidation object = new LoginPageValidation();
		object.operbrowser();
		// object.testValidLogin();
		// object.testInvalidLoginWithIncorrectUsername();
		// object.testInvalidLoginWithBlankFields();
		// object.testInvalidLoginWithSpecialCharacters();
		// object.testPasswordLengthValidation();
		object.testPasswordFormatValidation();
		object.closebrowser();

	}

}
