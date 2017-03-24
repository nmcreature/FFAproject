package org.ffa.webelements;

import org.ffa.framework.Wait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.concurrent.TimeUnit;

import static org.ffa.framework.BrowserFactory.getDriver;
import static org.ffa.framework.Wait.forAttributeIsLoaded;
import static org.ffa.framework.Wait.untilVisible;

public class Element extends TypifiedElement {

	public Element(WebElement wrappedElement) {
		super(wrappedElement);
	}


	protected String getElementName(String name){
		return name;
	}
	
	/**
	 * Checks if element is displayed or not
	 *
	 * @return {@code boolean} true if element is displaying
	 */
	public boolean isDisplayed() {
		if (untilVisible(getWrappedElement()) != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if element is selected or not
	 *
	 * @return {@code boolean} true if element is selected
	 */
	public boolean isSelected() {
		if (untilVisible(getWrappedElement()) != null) {
			return getWrappedElement().isSelected();
		} else {
			return false;
		}
	}

	/**
	 * Wait for element is not attached to the DOM
	 *
	 * @return {@code boolean} true if element is not attached to the DOM anymore
	 */
	public boolean waitElementDisappear(String xpath) {
		return Wait.untilNotVisible(xpath);
	}


	public String getAttribute(String attribute) {
		try{
			if (forAttributeIsLoaded(getWrappedElement(), attribute)) {
				return getWrappedElement().getAttribute(attribute);
			} else {
				return "";
			}
		}
		catch(Exception e){
			return "";
		}
	}
	
	public boolean hasAttribute(String name) {
		try {
			String value = getWrappedElement().getAttribute(name);
			if(value != null) {
				return true;
			}else {
				return false;
			}
		}catch(WebDriverException e){
			return false;
		}
	}

	public String getBackgroundColor(){
		String background =  getWrappedElement().getCssValue("background-color");
		return background;
	}
	
	public boolean exists() { 
		try {
			new WebDriverWait(getDriver(), 1).pollingEvery(100, TimeUnit.MILLISECONDS).until(ExpectedConditions.visibilityOf(getWrappedElement()));
		}catch(NoSuchElementException e) {
			return false;
		}catch (TimeoutException e) {
			return false;
		}
		return true;
	}

}