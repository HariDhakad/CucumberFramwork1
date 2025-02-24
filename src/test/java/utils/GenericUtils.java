package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

// re-usable methods
public class GenericUtils {
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver  = driver;
	}
	
	public void switchWindowToChild() {
		Set<String> s1= driver.getWindowHandles();// it gives total count of windows open with automation
		// this two window is stored in s1 collection object
		// now iterate this s1
		Iterator <String> i1= s1.iterator();
		//i1 object is responsible for iterations
		//initially i1 pointing to null and by the help of i1.next() method it pointing to zeroth index window
		// then again i1.next() method pointing to child window i.e. next index or 1st index
		
		String parentWindow=i1.next();
		String childWindow=i1.next();
		driver.switchTo().window(childWindow); // now using method we are on at child window

	}
	
	

}
