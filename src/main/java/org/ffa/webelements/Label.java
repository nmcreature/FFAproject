package org.ffa.webelements;

import static org.ffa.framework.Wait.untilVisible;

import org.openqa.selenium.WebElement;

// For testing purposes Label methods are broken
public class Label extends Element{

	public Label(WebElement wrappedElement) {
		super(wrappedElement);
	}

	/**
	 * Clicks label
	 *
	 * @return {@code String} element's text
	 */
/*	@Step("Click label")
	public void click(){
		clickWhenPresent(getWrappedElement());
		getLogger().info("Label '" + getName() + "' was clicked");
	}

	/**
	 * Gets text of specified label
	 *
	 * @return {@code String} element's text
	 */
	//@Step("Get text from label")
	public String getText() {
		if (untilVisible(getWrappedElement()) != null) {
			String text =  getWrappedElement().getText();
			return text;
		} else {
			return "";
		}
	}

	//@Step("Get label font size")
	public String getFontSize(){
		String fontSize =  getWrappedElement().getCssValue("font-size");
		return fontSize;
	}

//	@Step("Get label font family")
	public String getFontFamily(){
		String fontFamily =  getWrappedElement().getCssValue("font-family");
		return fontFamily;
	}
	
//	@Step("Get label font style")
	public String getFontStyle(){
		String fontStyle =  getWrappedElement().getCssValue("font-style");
		return fontStyle;
	}

	//@Step("Get label font weight")
	public String getFontWeight(){
		String fontWeight =  getWrappedElement().getCssValue("font-weight");
		return fontWeight;
	}
	
	public String fontInfo(){
		String fontInfo = "Text: " + getText() + "\n" + 
				"Size: " + getFontSize() + "\n" + 
				"Family: " + getFontFamily() + "\n" + 
				"Style: " + getFontStyle() + "\n" + 
				"Weight: " + getFontWeight();
		return fontInfo;
	}
}
