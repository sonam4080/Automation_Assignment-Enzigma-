package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordValidation {

	WebDriver driver = new ChromeDriver();

	public void operbrowserforgotPassword() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_drivers\\chromedriver.exe");
		
		driver.navigate().to("https://app-staging.nokodr.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement forgotPasswordLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.linkText("Forgot Password?")));
		forgotPasswordLink.click();

	}

	public void Blankemailtest() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement user_name = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/abx-forgot-password/div/div/div/abx-tabs/div/div/abx-tab[1]/div/div/abx-form/div/div/abx-container/div/div/div/span/abx-layout-item/div/abx-field/div/div/div/div[1]/abx-email/input"));
		WebElement proceed_button = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/abx-forgot-password/div/div/div/div/div[2]/div/abx-button[2]/button/abx-mergetext/div"));
		user_name.clear();
		proceed_button.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement error_Message = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[6]/section/abx-toaster/div/div/div[1]/div/h2")));
		System.out.println("Error for blank email: " + error_Message.getText());
	}

	public void invalidemailtest() throws InterruptedException {
	
		Thread.sleep(2000);
		WebElement user_name = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/abx-forgot-password/div/div/div/abx-tabs/div/div/abx-tab[1]/div/div/abx-form/div/div/abx-container/div/div/div/span/abx-layout-item/div/abx-field/div/div/div/div[1]/abx-email/input"));
		user_name.sendKeys("invalid");
		WebElement proceed_button = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/abx-forgot-password/div/div/div/div/div[2]/div/abx-button[2]/button/abx-mergetext/div"));
		Thread.sleep(2000);
		proceed_button.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement invalid_error_Message = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[6]/section/abx-toaster/div/div/div[1]/div/h2")));
		System.out.println("Error for invalid email format: " + invalid_error_Message.getText());
	}

	public void nonregistermailtest() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement user_name = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/abx-forgot-password/div/div/div/abx-tabs/div/div/abx-tab[1]/div/div/abx-form/div/div/abx-container/div/div/div/span/abx-layout-item/div/abx-field/div/div/div/div[1]/abx-email/input"));
		WebElement proceed_button = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/abx-forgot-password/div/div/div/div/div[2]/div/abx-button[2]/button/abx-mergetext/div"));
		user_name.clear();
		user_name.sendKeys("testnonregister@gmail.com");
		proceed_button.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement testnonregister = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[6]/section/abx-toaster/div/div/div[1]/div/h2")));
		System.out.println("Error for non-register email format: " + testnonregister.getText());
	}

	public void registermailtest() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement user_name = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/abx-forgot-password/div/div/div/abx-tabs/div/div/abx-tab[1]/div/div/abx-form/div/div/abx-container/div/div/div/span/abx-layout-item/div/abx-field/div/div/div/div[1]/abx-email/input"));
		WebElement proceed_button = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/abx-forgot-password/div/div/div/div/div[2]/div/abx-button[2]/button/abx-mergetext/div"));
		user_name.clear();
		user_name.sendKeys("sonam3890rajput@gmail.com");
		proceed_button.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement success_Message = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[6]/section/abx-toaster/div/div/div[1]/div/h2")));
		System.out.println("success email message: " + success_Message.getText());
	}

	public void closebrowser() throws InterruptedException {

		Thread.sleep(10000);
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {

		ForgotPasswordValidation object = new ForgotPasswordValidation();
		object.operbrowserforgotPassword();
		// object.Blankemailtest();
		// object.invalidemailtest();
		object.nonregistermailtest();
		object.registermailtest();
		object.closebrowser();

	}

}