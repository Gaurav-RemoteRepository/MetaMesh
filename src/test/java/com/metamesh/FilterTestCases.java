package com.metamesh;

import java.util.List;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.metamesh.base.TestBase;
import com.metamesh.keywords.UIKeywords;
import com.metamesh.pages.HomePage;
import com.metamesh.pages.IndianJerseyPage;
import com.metamesh.pages.ProductDescriptionPage;
import com.metamesh.util.Locator;
import com.metamesh.util.WaitFor;

import org.testng.Assert;

public class FilterTestCases extends TestBase {
	@Test // 01 (KDF)
	public void verifyListOfProductsWhenMenFilterIsAppliedForLevis() {

		UIKeywords.enterText(Locator.HOMEPAGE_SEARCHBAR, "Levis" + Keys.ENTER);
		WaitFor.elementToBeClickable(Locator.FILTER_MEN, "css");
		UIKeywords.clickOnElement(Locator.FILTER_MEN);
		List<String> productDescriptions = UIKeywords.getTexts(Locator.PRODUCT_DESCRIPTION);
		for (String productDescription : productDescriptions) {
			Assert.assertTrue(productDescription.contains("Men"));
		}
	}

	@Test // 02 (POM)
	public void verifyListOfProductsWhenMenFilterIsAppliedForLevisPOM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Levis");

		ProductDescriptionPage prodDescription = new ProductDescriptionPage();

		prodDescription.waitForMenFilterToBeClickable(); // wait used

		prodDescription.selectMenFilter();
		List<String> descriptions = prodDescription.getProductDescriptions();

		SoftAssert softly = new SoftAssert();// soft assert
		for (String description : descriptions) {
			softly.assertTrue(description.contains("Men"), "Product description: " + description);

		}

		softly.assertAll();
	}

	@Test // 03
	public void verifyListOfProductsWhenBrandFilterIsAppliedForIndianJerseyPOM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();
		List<String> details = indianJ.getjerseyDetails();

		SoftAssert softly = new SoftAssert();// soft assert
		for (String detail : details) {
			softly.assertTrue(detail.contains("Cricket"), "Jersey description: " + detail);

		}

		softly.assertAll();

	}

	@Test // 04
	public void verifyBrandNameWhenBrandFilterAppliedForAdidasPOMM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();

	}

	@Test // 05
	public void verifySizeWhenProductOpendInNewTabPOM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();
		
		indianJ.selectAdidas();
		
		indianJ.switchWindow();
		
		indianJ.waitForSizeToBeClickable(); // wait used
		indianJ.selectSize();
		}

	@Test // 06
	public void verifyProductAddedToBagPOM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();
		
		indianJ.selectAdidas();
		
		indianJ.switchWindow();
		
		indianJ.waitForSizeToBeClickable(); // wait used
		indianJ.selectSize();
		
		indianJ.selectAddToBag();
		
	}

	@Test // 07
	public void verifyProductAddedInCartPOM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();
		
		indianJ.selectAdidas();
		
		indianJ.switchWindow();
		
		indianJ.waitForSizeToBeClickable(); // wait used
		indianJ.selectSize();
		
		indianJ.selectAddToBag();
		
		indianJ.selectCart();
	
	}

	@Test // 08
	public void verifyProductSummaryAddedInCartPOM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();
		
		indianJ.selectAdidas();
		
		indianJ.switchWindow();
		
		indianJ.waitForSizeToBeClickable(); // wait used
		indianJ.selectSize();
		
		indianJ.selectAddToBag();
		
		indianJ.selectCart();
		
		indianJ.getSummaryDetails();
	}

	@Test // 09
	public void verifyListOfIncreasedProductQuantityPOM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();
		
		indianJ.selectAdidas();
		
		indianJ.switchWindow();
		
		indianJ.waitForSizeToBeClickable(); // wait used
		indianJ.selectSize();
		
		indianJ.selectAddToBag();
		
		indianJ.selectCart();
		
		indianJ.increaseQuantity();
		
		indianJ.selectQuantity();
		
		indianJ.finalQuantity();
		
	}

	@Test // 10
	public void verifyTotalAmountWhenDiscountCouponAppliedToIncreasedQuantity() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();
		
		indianJ.selectAdidas();
		
		indianJ.switchWindow();
		
		indianJ.waitForSizeToBeClickable(); // wait used
		indianJ.selectSize();
		
		indianJ.selectAddToBag();
		
		indianJ.selectCart();
		
		indianJ.increaseQuantity();
		
		indianJ.selectQuantity();
		
		indianJ.finalQuantity();
		
		indianJ.waitForSelectCouponToBeClickable(); // wait used
		indianJ.selectCoupon();
		
		indianJ.waitForApplyCouponToBeClickable();  // wait used
		indianJ.applyCoupon();
		
		indianJ.getTotalAmountSummary();
		
		
	}
}