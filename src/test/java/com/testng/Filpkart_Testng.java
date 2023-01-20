package com.testng;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Filpkart_Testng {
	
	WebDriver driver = null;
	private static ChromeOptions desiredOption() {

		ChromeOptions option = new ChromeOptions();

		option.addArguments("start-maximized");

		return option;

		}
	@BeforeTest
		private void browserLaunch() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(desiredOption());
}

@Test(priority = 0)
	private void urllaunch() {
		
		String title = "flipkart";

		String url = "https://www.flipkart.com/";

		driver.get(url);

		String title1 = driver.getTitle();

		System.out.println(title1);

		if (url.contains(title)) {

		System.out.println("launch the url correctly");

		} else {

		System.out.println("not a launch the url correctly");

		}
		
}

@Test(priority = 1)
private void searchproduct() throws InterruptedException {
	
	Thread.sleep(3000);
		WebElement click = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));

		click.click();
		Thread.sleep(3000);

		WebElement searchmobile = driver.findElement(By.xpath("//input[@class='_3704LK']"));

		searchmobile.sendKeys("iphone");

		WebElement searchclick = driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));

		searchclick.click();		
}

@Test(priority = 2)
private void mobilephone() throws InterruptedException {
	

         String s = "iphone";

		WebElement iphones = driver.findElement(By.xpath("//span[text()='iphone']"));

		if (s.equals(iphones)) {

		System.out.println("search iphone and getting results iphone is launched correctly");

		}

	Thread.sleep(1000);
		WebElement mobile1 = driver.findElement(By.xpath("//div[text()='APPLE iPhone 12 mini (Black, 64 GB)']"));

		mobile1.click();
		Thread.sleep(3000);

		List<String> windowhandling = new ArrayList<>(driver.getWindowHandles());

		//String parentwindow = driver.getWindowHandle();

		//Set<String> childwindow = driver.getWindowHandles();

		//for (String st: childwindow) {

		// driver.switchTo().window(st);

		//

		//}

		driver.switchTo().window(windowhandling.get(1));
		Thread.sleep(3000);

		WebElement mobileclick1 = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));

		mobileclick1.click();

		driver.switchTo().window(windowhandling.get(0));

		Thread.sleep(3000);
		WebElement mobile2 = driver.findElement(By.xpath("//div[text()='APPLE iPhone 13 (Midnight, 128 GB)']"));

		mobile2.click();
		Thread.sleep(3000);

		List<String> windowhandling1 = new ArrayList<>(driver.getWindowHandles());

		driver.switchTo().window(windowhandling1.get(2));

		WebElement mobileclick2 = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));

		mobileclick2.click();
		Thread.sleep(3000);

		driver.switchTo().window(windowhandling1.get(0));
		
}

@Test(priority = 3)
private void addtocart() throws InterruptedException {

		WebElement totalcart = driver.findElement(By.xpath("//span[text()='Cart']"));

		totalcart.click();
Thread.sleep(2000);
		WebElement iphone12 = driver.findElement(By.xpath(

		"//div[@class='zab8Yh _10k93p']//descendant::div[@class='_3fSRat']//child::span[@class='_2-ut7f _2xc6hH']"));

		System.out.println(" first product Price" + iphone12.getText());

		String fp = iphone12.getText();

		String substring4 = fp.substring(1);

		String replaceAll4 = substring4.replaceAll(",", "");

		int firstproductprice = Integer.parseInt(replaceAll4);

		System.out.println("first product price iphone: " + firstproductprice);

		WebElement iphone12mini = driver

		.findElement(By.xpath("//div[@class='_3fSRat']//descendant::div[@class='_2-uG6-']"

		+ "//following::a[text()='APPLE iPhone 12 mini (Black, 64 GB)']//"

		+ "following::span[@class='_2-ut7f _2xc6hH']"));

		System.out.println("second product price" + iphone12mini.getText());

		String sp = iphone12mini.getText();

		String substring5 = sp.substring(1);

		String replaceAll5 = substring5.replaceAll(",", "");

		int secondproductprice = Integer.parseInt(replaceAll5);

		System.out.println("second product price iphone: " + secondproductprice);

		WebElement totalprice = driver.findElement(By.xpath(

		"//div[@class='_1YokD2 _3Mn1Gg col-4-12 _78xt5Y']//descendant::div[@class='_I_XQO']//descendant::div[@class='Ob17DV']//descendant::div[@class='_24KATy']//div[text()='Price (2 items)']//ancestor::div[@class='Ob17DV']//span"));

		System.out.println("Total Price" + totalprice.getText());

		String tp = totalprice.getText();

		String substring3 = tp.substring(1);

		String replaceAll3 = substring3.replaceAll(",", "");

		int totalpriceoftwoiteams = Integer.parseInt(replaceAll3);

		System.out.println("Total price of two items Iphone 12 and 13: " + totalpriceoftwoiteams);

		if (totalpriceoftwoiteams == firstproductprice + secondproductprice) {

		System.out.println("*********Both prices are equal************");

		}

		//driver.quit();

		}
@AfterClass
private void closebrowser() {
	driver.quit();

}

		}
	


	
