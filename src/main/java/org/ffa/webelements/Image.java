package org.ffa.webelements;

import org.openqa.selenium.WebElement;

public class Image extends Element{

	public Image(WebElement wrappedElement) {
		super(wrappedElement);	
	}	
	
	public void click() {
		getWrappedElement().click();
	}
	
	public String getSrcAttribute(){
		return getWrappedElement().getAttribute("src");
	}
}