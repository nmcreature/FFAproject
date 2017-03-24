package org.ffa.framework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.ffa.framework.BrowserFactory.getDriver;

public class WaitingConditions {

	public static ExpectedCondition<WebElement> clickWhenReady(
			final WebElement element) {
		return new ExpectedCondition<WebElement>() {

			public ExpectedCondition<WebElement> visibilityOfElement =
					ExpectedConditions.visibilityOf(element);

			@Override
			public WebElement apply(WebDriver driver) {
				try {
					WebElement element = visibilityOfElement.apply(driver);
					element.click();
					return element;
				}
				catch (NullPointerException e) {
					return null;
				}
				catch (WebDriverException e) {
					return null;
				}
			}

			@Override
			public String toString() {
				return "element to be clickable: " + element;
			}
		};
	}

	public static ExpectedCondition<Boolean> elementIsExpanded(
			final WebElement element) {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return !element.getAttribute("class").contains("expanding");
			}
		};
	}

	public static ExpectedCondition<Boolean> elementIsActive(
			final WebElement element) {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return element.getAttribute("class").contains("active");
			}
		};
	}

	public static ExpectedCondition<Boolean> newTabOrUrlChange(String url) {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((BrowserActions.getWindowsCount() > 1) | (!getDriver().getCurrentUrl().equals(url)));
			}
		};
	}

	public static ExpectedCondition<Boolean> jqueryIsLoaded() {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) ((JavascriptExecutor) getDriver()).executeScript
						("return $.active == 0");
			}
		};
	}

	public static ExpectedCondition<WebElement> invisibilityOfAnElement(
			final WebElement element) {
		return new ExpectedCondition<WebElement>() {

			@Override
			public WebElement apply(WebDriver webDriver) {
				try {
					if (element.isDisplayed()) {
						return null;
					}
				} catch (Exception e) {/**/}
				return element;
			}

			@Override
			public String toString() {
				return "invisibility of  element " + element;
			}
		};
	}

	public static ExpectedCondition<Boolean> urlAppears() {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return !driver.getCurrentUrl().equals("about:blank");
			}
		};
	}

	public static ExpectedCondition<Boolean> numberOfTabsToBe(int numberOfTabs) {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (driver.getWindowHandles().size() == numberOfTabs);
			}
		};
	}

	public static ExpectedCondition<Boolean> elementChanges(WebElement element){
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					if(element.isDisplayed()) {
						return false;
					}else {
						return true;
					}
				} catch(StaleElementReferenceException e){
					return true;
				}
			}
		};
	}

	public static ExpectedCondition<Boolean> textAppears(
			final WebElement element) {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return !element.getText().trim().equals("");
			}
		};
	}

	public static ExpectedCondition<WebElement> elementToBeClickable(WebElement element){
			    return new ExpectedCondition<WebElement>() {

			      public ExpectedCondition<WebElement> visibilityOfElement =
			        ExpectedConditions.visibilityOf(element);

			      @Override
			      public WebElement apply(WebDriver driver) {
			        try {
			        	WebElement element = visibilityOfElement.apply(driver);
			          if (element != null && element.isEnabled()) {
			            return element;
			          } else {
			            return null;
			          }
			        } catch (StaleElementReferenceException e) {
			          return null;
			        }
			      }

			      @Override
			      public String toString() {
			        return "element to be clickable: " + element;
			      }
			    };
	}
	
	public static ExpectedCondition<Boolean> elementDoesntMove(WebElement element){
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				Point firstPoint = element.getLocation();
				Utilities.sleep(10);
				Point secondPoint = element.getLocation();
				return firstPoint.equals(secondPoint);
			}
		};
	}

}
