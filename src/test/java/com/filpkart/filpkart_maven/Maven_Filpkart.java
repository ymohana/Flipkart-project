package com.filpkart.filpkart_maven;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Maven_Filpkart {
	
	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",

		"C:\\Users\\Yamini\\eclipse-workspace\\filpkart_maven\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

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

		WebElement click = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));

		click.click();

		WebElement searchmobile = driver.findElement(By.xpath("//input[@class='_3704LK']"));

		searchmobile.sendKeys("iphone");

		WebElement searchclick = driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));

		searchclick.click();

		String s = "iphone";

		WebElement iphones = driver.findElement(By.xpath("//span[text()='iphone']"));

		if (s.equals(iphones)) {

		System.out.println("search iphone and getting results iphone is launched correctly");

		}

		WebElement mobile1 = driver.findElement(By.xpath("//div[text()='APPLE iPhone 12 mini (Black, 64 GB)']"));

		mobile1.click();

		List<String> windowhandling = new ArrayList<>(driver.getWindowHandles());

		//String parentwindow = driver.getWindowHandle();

		//Set<String> childwindow = driver.getWindowHandles();

		//for (String st: childwindow) {

		// driver.switchTo().window(st);

		//

		//}

		driver.switchTo().window(windowhandling.get(1));

		WebElement mobileclick1 = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));

		mobileclick1.click();

		driver.switchTo().window(windowhandling.get(0));

		WebElement mobile2 = driver.findElement(By.xpath("//div[text()='APPLE iPhone 13 (Midnight, 128 GB)']"));

		mobile2.click();

		List<String> windowhandling1 = new ArrayList<>(driver.getWindowHandles());

		driver.switchTo().window(windowhandling1.get(2));

		WebElement mobileclick2 = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));

		mobileclick2.click();

		driver.switchTo().window(windowhandling1.get(0));

		WebElement totalcart = driver.findElement(By.xpath("//span[text()='Cart']"));

		totalcart.click();

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

		driver.quit();

		}

		}
	


