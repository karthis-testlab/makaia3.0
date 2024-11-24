package com.makaia.selenium.api.base;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.makaia.general.utils.Reporter;
import com.makaia.selenium.api.design.Browser;
import com.makaia.selenium.api.design.Element;
import com.makaia.selenium.api.design.Locators;
import static com.makaia.general.utils.PropertiesHandler.config;

public class SeleniumBase extends Reporter implements Browser, Element {	
	//SOLID 
	public void click(WebElement ele) {
		ele.click();
	}
	
	public void click(WebElement ele, String jsExpression) {
		getDriver().executeScript(jsExpression, ele);
	}
	
	public void type(WebElement ele, String data) {
		ele.sendKeys(data);
	}
	
	public void typeAndEnter(WebElement ele, String data) {
		ele.sendKeys(data, Keys.ENTER);
	}

	public String getElementText(WebElement ele) {
		return ele.getText();
	}
	
	public String getAttributeValue(WebElement ele, String value) {
		return ele.getAttribute(value);
	}
	
	public void dropdownSelectByValue(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByValue(value);
	}

	public void browserLaunch() {
		setDriver(config("makaia.browser.name"), Boolean.parseBoolean(config("makaia.browser.isheadless")));
		setWait();
	}

	public void browserLaunch(String browserName) {
		setDriver(browserName, false);
		setWait();
	}

	public void loadUrl(String url) {
		getDriver().get(url);
	}

	public WebElement locateElement(Locators locatorType, String value) {
		try {
			switch (locatorType) {
			case CLASS_NAME:
				return getDriver().findElement(By.className(value));
			case CSS_SELECTOR:
				return getDriver().findElement(By.cssSelector(value));
			case ID:
				return getDriver().findElement(By.id(value));
			case LINK_TEXT:
				return getDriver().findElement(By.linkText(value));
			case NAME:
				return getDriver().findElement(By.name(value));
			case PARTIAL_LINK_TEXT:
				return getDriver().findElement(By.partialLinkText(value));
			case TAG_NAME:
				return getDriver().findElement(By.tagName(value));
			case XPATH:
				return getDriver().findElement(By.xpath(value));
			default:
				System.err.println("Locator is not Valid");
				break;
			}
		} catch (NoSuchElementException e) {
			reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value + "\n"
					+ e.getMessage(), "fail");
		} catch (Exception e) {
			reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value + "\n"
					+ e.getMessage(), "fail");
		}
		return null;
	}

	public List<WebElement> locateElements(Locators locatorType, String value) {
		try {
			switch (locatorType) {
			case CLASS_NAME:
				return getDriver().findElements(By.className(value));
			case CSS_SELECTOR:
				return getDriver().findElements(By.cssSelector(value));
			case ID:
				return getDriver().findElements(By.id(value));
			case LINK_TEXT:
				return getDriver().findElements(By.linkText(value));
			case NAME:
				return getDriver().findElements(By.name(value));
			case PARTIAL_LINK_TEXT:
				return getDriver().findElements(By.partialLinkText(value));
			case TAG_NAME:
				return getDriver().findElements(By.tagName(value));
			case XPATH:
				return getDriver().findElements(By.xpath(value));
			default:
				System.err.println("Locator is not Valid");
				break;
			}
		} catch (NoSuchElementException e) {
			reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value + "\n"
					+ e.getMessage(), "fail");
		} catch (Exception e) {
			reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value + "\n"
					+ e.getMessage(), "fail");
		}
		return null;
	}

	public void close() {
		getDriver().close();
	}

	public void quit() {
		getDriver().quit();
	}

	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(getDriver().getScreenshotAs(OutputType.FILE),
					new File("./" + Reporter.folderName + "/images/" + number + ".jpg"));
		} catch (WebDriverException e) {
			reportStep("The browser has been closed." + e.getMessage(), "fail");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken " + e.getMessage(), "warning");
		}
		return number;
	}

}