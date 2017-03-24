package org.ffa.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

import static org.ffa.framework.Utilities.jsSelect;

public class Radio extends Element{

	public Radio(WebElement wrappedElement) {
		super(wrappedElement);
	}

	public List<WebElement> getButtons() {
		String radioName = getWrappedElement().getAttribute("name");

		String xpath;
		if (radioName == null) {
			xpath = "self::* | following::input[@type = 'radio'] | preceding::input[@type = 'radio']";
		} else {
			xpath = String.format(
					"self::* | following::input[@type = 'radio' and @name = '%s'] | " +
							"preceding::input[@type = 'radio' and @name = '%s']",
							radioName, radioName);
		}

		return getWrappedElement().findElements(By.xpath(xpath));
	}

	/**
	 * Returns selected radio button.
	 *
	 * @return {@code WebElement} representing selected radio button or {@code null} if no radio buttons are selected.
	 */
	public WebElement getSelectedButton() {
		return getButtons().stream()
				.filter(WebElement::isSelected)
				.findAny()
				.orElseThrow(() -> new NoSuchElementException("No selected button"));
	}

	/**
	 * Indicates if radio group has selected button.
	 *
	 * @return {@code true} if radio has selected button and {@code false} otherwise.
	 */
	public boolean hasSelectedButton() {
		return getButtons().stream()
				.anyMatch(WebElement::isSelected);
	}

	/**
	 * Selects first radio button that has a value matching the specified argument.
	 *
	 * @param value The value to match against.
	 */
	public void selectByValue(String value) {
		try{
		Optional<WebElement> matchingButton = getButtons().stream()
				.filter(b -> value.equals(b.getAttribute("value")))
				.findFirst();
		
			selectButton(matchingButton
					.orElseThrow(() -> new NoSuchElementException(
							String.format("Cannot locate radio button with value: %s", value))));
		}
		catch(Exception e){
		}
	}

	/**
	 * Selects a radio button by the given index.
	 *
	 * @param index Index of a radio button to be selected.
	 */
	public void selectByIndex(int index) {
		List<WebElement> buttons = getButtons();

		if (index < 0 || index >= buttons.size()) {
			throw new NoSuchElementException(String.format("Cannot locate radio button with index: %d", index));
		}

		selectButton(buttons.get(index));
	}

	/**
	 * Selects a radio button if it's not already selected.
	 *
	 * @param button {@code WebElement} representing radio button to be selected.
	 */
	private void selectButton(WebElement button) {
		if (!button.isSelected()) {
			jsSelect(button);
			//  button.click();
		}
	}

	public String getText() {
		return  getWrappedElement().getText();
	}
}

