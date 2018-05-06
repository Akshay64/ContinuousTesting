package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SlimClass {
	public WebDriver driver;
	public JavascriptExecutor js;
	
	public SlimClass(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;

	}

	public void highlightElement(WebElement ele){
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", ele,
				"background:yellow; border:2px solid red;");
		try {
			Thread.sleep(250);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", ele, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void moveToElement(WebElement ele) {
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		highlightElement(ele);
	}

	public void setText(WebElement ele, String text) {
		moveToElement(ele);
		ele.sendKeys(text);
	}

	public void setKeys(WebElement ele, Keys key) {
		moveToElement(ele);
	}

	public void clickOnElement(WebElement ele) {
		moveToElement(ele);
		ele.click();
	}

	public String getTextFromElement(WebElement ele) {
		moveToElement(ele);
		return ele.getText();
	}

	public void getURL(String url) {
		driver.get(url);
	}

}
