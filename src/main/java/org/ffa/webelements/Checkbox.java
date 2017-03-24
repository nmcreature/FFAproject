package org.ffa.webelements;


import org.openqa.selenium.WebElement;

public class Checkbox extends Element {

	public Checkbox(WebElement wrappedElement) {
		super(wrappedElement);
	}

	private void select() {
		if (!isSelected()) {
			getWrappedElement().click();
		}
	}

	private void deselect() {
		if (isSelected()) {
			getWrappedElement().click();
		}
	}

	/**
	 * Sets checkbox to 'checked' or 'unchecked' depending on initial state.
	 *
	 * @param value {@code String} representing the checkbox initial state.
	 */
	public void set(boolean value) {
		if (value) {
			select();
		} else {
			deselect();
		}
	}
}
