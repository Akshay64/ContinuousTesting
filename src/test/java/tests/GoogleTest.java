package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class GoogleTest extends DriverFactory{
  @Test
  public void f() {
	  sc.getURL("https://google.co.in");
	  sc.setText(getDriver().findElement(By.name("q")),"Mobiuso");
	  sc.setKeys(getDriver().findElement(By.name("q")),Keys.ENTER);

  }
  
}
