package org.ffa.webelements;

import static org.ffa.framework.Wait.clickWhenPresent;

import org.openqa.selenium.WebElement;


public class Button extends Element {

	public Button(WebElement wrappedElement) {
		super(wrappedElement);
	}
	


	/**
	 * Clicks a button with specified locator.
	 *
	 */
	public void click() {
		clickWhenPresent(getWrappedElement());
	}

	public String getText() {
		return getWrappedElement().getText();
	}
}