package org.yandrut;

import org.testng.annotations.Test;
import selenium.DriverProvider;
import selenium.pages.HomePage;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HomePageTest extends BaseTest {

    @Test
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

    @Test
    public void redirectsToTechExpertise() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.navigateToTechExpertise();
        String expected = "Tech expertise";
        String actual = page.getWebsiteTitle();

        assertEquals(expected, actual);
    }

    @Test
    public void allowsToSwitchIndustriesList() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.clickThroughIndustriesElements();
        boolean allVisible = page.verifyAllElementsVisible();

        assertTrue(allVisible);
    }

    @Test
    public void redirectsToAboutUs() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.navigateToAboutUs();
        String expected = "About Us";
        String actual = page.getWebsiteTitle();

        assertEquals(expected, actual);
    }

    @Test
    public void redirectsToLinkedIn() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.navigateToLinkedIn("https://www.linkedin.com/company/codeseek/");
        String expected = "CodeSeek | LinkedIn";
        String actual = page.getWebsiteTitle();

        assertEquals(expected, actual);
    }

    @Test
    public void redirectsToClutch() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.navigateToClutch("https://clutch.co/profile/codeseek#highlights");
        String expected = "CodeSeek Reviews | 7 Client Reviews | Clutch.co";
        String actual = page.getWebsiteTitle();

        assertEquals(expected, actual);
    }

    @Test
    public void redirectsToUpwork() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.navigateToUpwork("https://www.upwork.com/agencies/codeseek/");
        String expected = "CodeSeek | Upwork";
        String actual = page.getWebsiteTitle();

        assertEquals(expected, actual);
    }
}