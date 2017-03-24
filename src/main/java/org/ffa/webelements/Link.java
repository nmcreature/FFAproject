package org.ffa.webelements;

import org.ffa.framework.BrowserActions;
import org.ffa.framework.WaitingConditions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static org.ffa.framework.BrowserFactory.getDriver;

public class Link extends Element {

	public Link(WebElement wrappedElement) {
		super(wrappedElement);
	}

	/**
	 * Clicks specified link if it is displayed
	 */
	public void click() {
		org.ffa.framework.Wait.clickWhenPresent(getWrappedElement());
	}


	/**
	 * Gets text of specified link
	 *
	 * @return {@code String} element's text
	 */
	public String getText() {
		if (org.ffa.framework.Wait.untilVisible(getWrappedElement()) != null) {
			return getWrappedElement().getText();
		} else {
			return "";
		}
	}

	/**
	 * Gets URL address of specified link
	 *
	 * @return {@code String} content of href attribute
	 */
	public String getUrl() {
		if (org.ffa.framework.Wait.untilVisible(getWrappedElement()) != null) {
			return getWrappedElement().getAttribute("href");
		} else {
			return "";
		}
	}

	public void waitUntilIsActive() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
				.withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(200, TimeUnit.MICROSECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		wait.until(WaitingConditions.elementIsActive(getWrappedElement()));
	}

	 public boolean isActive() {
		return getWrappedElement().getAttribute("class").contains("active");
	 }
}
