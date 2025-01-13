package Tests;

import java.time.Duration;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPageValidation {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_drivers\\chromedriver.exe");
		
		driver.navigate().to("https://app-staging.nokodr.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement signUpLink = driver.findElement(By.linkText("Sign up"));
		signUpLink.click();
		Thread.sleep(2000);
		WebElement Email = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/abx-sign-up/div/div/div[2]/span/abx-tabs/div/div/abx-tab[1]/div/div/abx-form/div/div/abx-container/div/div/div/span[1]/abx-layout-item/div/abx-field/div/div/div/div[1]/abx-email/input"));
		String useremail = "sonamsigh@gmail.com";
		
		Email.sendKeys(useremail);
		WebElement checkbox = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/abx-sign-up/div/div/div[2]/span/abx-tabs/div/div/abx-tab[1]/div/div/abx-form/div/div/abx-container/div/div/div/span[2]/abx-layout-item/div/abx-field/div/div/div/div[1]/abx-checkbox/div/label/span"));
		checkbox.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement proceed = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/abx-modal/section/div/div/abx-sign-up/div/div/div[2]/span/div[2]/abx-button/button/abx-mergetext/div")));
		proceed.click();
		
		if (isValidEmail(useremail)) {
			System.out.println("The email format is valid.");
		} else {
			System.out.println("The email format is invalid.");
			WebElement error_Message = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[6]/section/abx-toaster/div/div/div[1]/div/h2")));
			System.out.println("Error for invalid email: " + error_Message.getText());
		}
	
		WebDriverWait verification_wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement verification_code_field = verification_wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/abx-modal/section/div/div/verification-code/abx-form/abx-field/div/div/div[1]/div[1]/abx-text/input")));
		Scanner verification_code = new Scanner(System.in);
		System.out.print("Please enter the verification code from your email: ");
		String verification_code_input = verification_code.nextLine();
		verification_code_field.sendKeys(verification_code_input);
		WebElement verify_button = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/verification-code/div/div[2]/div/abx-button/button/abx-mergetext/div"));
		verify_button.click();
		Thread.sleep(2000);
		WebElement firstname = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/user-details/abx-form/abx-field[1]/div/div/div[1]/div[1]/abx-text/input"));
		firstname.sendKeys("Sonam");
		Thread.sleep(2000);
		WebElement lastname = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/user-details/abx-form/abx-field[2]/div/div/div[1]/div[1]/abx-text/input"));
		lastname.sendKeys("singh");
		Thread.sleep(2000);
		WebElement pass_word = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/user-details/abx-form/abx-field[3]/div/div/div/div[1]/abx-password/div/div[1]/input"));
		String passwords = "Sonam@1996";
		if (isValidPassword(passwords)) {
			System.out.println("Password meets the strength requirements.");
		} else {
			System.out.println("Password does not meet the strength requirements.");
		}
		pass_word.sendKeys(passwords);
		Thread.sleep(2000);
		WebElement confirm_password = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/user-details/abx-form/abx-field[3]/div/div/div/div[1]/abx-password/div/div[2]/input"));
		confirm_password.sendKeys("Sonam@1996");
		Thread.sleep(2000);
		
		if (!pass_word.equals(confirm_password)) {
			System.out.println("Passwords do not match.");
		} else {
			System.out.println("Passwords mathes");
		}

		Thread.sleep(2000);

		WebElement Register_click = driver.findElement(By.xpath(
				"/html/body/abx-modal/section/div/div/user-details/div/div[2]/div/abx-button[2]/button/abx-mergetext/div"));
		Register_click.click();
		System.out.println("Account created successfully!");

	}

	
	private static boolean isValidEmail(String useremail) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(useremail);
		return matcher.matches();
	}

	private static boolean isValidPassword(String passwords) {
		
		String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#\\$%^&*])[A-Za-z\\d!@#\\$%^&*]{8,}$";
		Pattern pattern = Pattern.compile(passwordRegex);
		Matcher matcher = pattern.matcher(passwords);
		return matcher.matches();
	}
}