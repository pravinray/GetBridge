package com.sevadevelopment.instructure.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageSections extends BasePageObject {

	@FindBy(xpath = "//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div/section[1]/button")
	WebElement section1stLearnMore;

	@FindBy(xpath = "//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div/section[3]/div[3]/button")
	WebElement section3rdCustomerStories;

	@FindBy(xpath = "//*[@id=\"home-blue-page\"]/a")
	WebElement section4thSeeFeatures;

	@FindBy(xpath = "//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div/section[4]/div/div/div[1]/button")
	WebElement viewInfographic1stCol;

	@FindBy(xpath = "//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div/section[4]/div/div/div[2]/button")
	WebElement viewInfographic2ndCol;

	@FindBy(xpath = "//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div/section[4]/div/div/div[3]/button")
	WebElement viewEbook;

	public HomePageSections(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnSection1stLearnMoreBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(section1stLearnMore));
		section1stLearnMore.click();
	}

	public void clickOnSection3rdCustomerStoriesBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(section3rdCustomerStories));
		section3rdCustomerStories.click();
	}

	public void clickOnSection4thSeeFeaturesBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(section4thSeeFeatures));
		section4thSeeFeatures.click();
	}

	public void clickOnViewInfographic1stColBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(viewInfographic1stCol));
		viewInfographic1stCol.click();
	}

	public void clickOnViewInfographic2ndColBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(viewInfographic2ndCol));
		viewInfographic2ndCol.click();
	}

	public void clickOnViewEbook3rdColBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(viewEbook));
		viewEbook.click();
	}

}
