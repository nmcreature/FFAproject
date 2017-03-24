package org.ffa.webelements;

import org.openqa.selenium.WebElement;
import static org.ffa.framework.Wait.untilVisible;

public class TextInput extends org.ffa.webelements.Element {

	public TextInput(WebElement wrappedElement) {
		super(wrappedElement);
	}

	/**
	 * Enters given chars sequence into the input field.
	 *
	 * @param keys Sequence of  characters to enter into the text field
	 */
	public void sendKeys(String keys) {
		if(keys != null){
			if (untilVisible(getWrappedElement()) != null) {
				getWrappedElement().clear();
				getWrappedElement().sendKeys(keys);
			} else {
			}
		}
	}

	public void clear() {
		if (untilVisible(getWrappedElement()) != null) {
			getWrappedElement().clear();
		} else {
		}
	}

}
