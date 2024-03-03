package org.yandrut;

import org.testng.annotations.Test;
import selenium.DriverProvider;
import selenium.pages.HomePage;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HomePageTest extends BaseTest {

    @Test(description = "Verify that allows to submit a contact form")
    public void allowsToSubmitContactForm() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.clickOnContactUs();
        page.typeName("Test");
        page.typeEmail("test@test.com");
        page.typeMessage("This is an autotest");
        page.submitForm();
        String expectedMessage = "Thank you! Your submission has been received!";
        String actualMessage = page.getSubmitFormMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test(description = "Verify that allows to redirect to Tech Expertise page")
    public void redirectsToTechExpertise() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.navigateToTechExpertise();
        String expected = "Tech expertise";
        String actual = page.getWebsiteTitle();

        assertEquals(expected, actual);
    }

    @Test(description = "Verify that allows to click through industries list")
    public void allowsToSwitchIndustriesList() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.clickThroughIndustriesElements();
        boolean allVisible = page.verifyAllElementsVisible();

        assertTrue(allVisible);
    }

    @Test(description = "Verify that allows to redirect to About Us page")
    public void redirectsToAboutUs() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.navigateToAboutUs();
        String expected = "About Us";
        String actual = page.getWebsiteTitle();

        assertEquals(expected, actual);
    }

    @Test(description = "Verify that allows to redirect to LinkedIn page")
    public void redirectsToLinkedIn() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.navigateToLinkedIn();
        page.waitForWebsiteToBeOpenedAndSwitchToNewTab("https://www.linkedin.com/company/codeseek/", 1);
        String expected = "CodeSeek | LinkedIn";
        String actual = page.getWebsiteTitle();

        assertEquals(expected, actual);
    }

    @Test(description = "Verify that allows to redirect to Clutch page")
    public void redirectsToClutch() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.navigateToClutch();
        page.waitForWebsiteToBeOpenedAndSwitchToNewTab("https://clutch.co/profile/codeseek#highlights", 1);
        String expected = "CodeSeek Reviews | 7 Client Reviews | Clutch.co";
        String actual = page.getWebsiteTitle();

        assertEquals(expected, actual);
    }

    @Test(description = "Verify that allows to redirect to Upwork page")
    public void redirectsToUpwork() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.navigateToUpwork();
        page.waitForWebsiteToBeOpenedAndSwitchToNewTab("https://www.upwork.com/agencies/codeseek/", 1);
        String expected = "CodeSeek | Upwork";
        String actual = page.getWebsiteTitle();

        assertEquals(expected, actual);
    }
}