package selenium.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.DriverWaiter;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static selenium.DriverWaiter.*;
public class HomePage {

    private final WebDriver driver;
    private final By CONTACT_US_BUTTON = By.cssSelector(".button-main.transperen-bg.w-button");
    private final By NAME_INPUT = By.xpath("//*[@id='name-2']");
    private final By EMAIL_INPUT = By.cssSelector("input#email-3.text-field.w-input");
    private final By MESSAGE_INPUT = By.xpath("//*[@id='email-2']");
    private final By SUBMIT_BUTTON = By.xpath("//*[@id='email-form-modal']/input");
    private final By SUCCESS_MESSAGE = By.xpath("//*[@id='modal-window']/div[1]/div[2]/div/div[1]/div");
    private final By TECH_EXPERTISE_LINK = By.xpath("//*[@id='w-node-_4a3d37bb-8b08-8b51-b0c3-1a60b1be2859-9eacc504']/div/div/div[1]/div[2]/div/a");
    private final By ABOUT_US_LINK = By.xpath("//*[@id='w-node-aac51932-b8ac-3bc5-3f00-baa3153c97f8-9eacc504']/div/div/div[1]/div[2]/a");
    private final By LINKEDIN_PAGE = By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/a[1]");
    private final By CLUTCH_PAGE = By.xpath("//*[@id='w-node-_952a1435-9794-8df5-c752-63dd13b280aa-09262569']/div[2]/div/div[1]/a");
    private final By UPWORK_PAGE = By.xpath("//*[@id='w-node-_952a1435-9794-8df5-c752-63dd13b280aa-09262569']/div[2]/div/div[2]/a");
    private final By INDUSTRIES_LIST = By.xpath("//div[@class='dropdown-toggle w-dropdown-toggle']");
    private final By PARAGRAPH_LIST = By.xpath("//p[@class='paragraph-3']");
    private static final Logger log = LogManager.getLogger(HomePage.class);
    private int counter = 0;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnContactUs() {
        log.info("Click on contact us");
        WebElement contactButton = driver.findElement(CONTACT_US_BUTTON);
        waitForElementToBeClickable(contactButton);
        contactButton.click();
    }

    public boolean formatIsValid(String text) {
        log.info("Check format of: " + text);
        return Objects.nonNull(text) && !text.isEmpty() && text.length() <= 256;
    }

    public void typeName(String name) {
        log.info("Type in name");
        WebElement nameInput = driver.findElement(NAME_INPUT);
        waitForElementToBeVisible(nameInput);

        if (formatIsValid(name)) {
            nameInput.sendKeys(name);
        }
    }

    public void typeEmail(String email) {
        log.info("Type in email");
        WebElement emailInput = driver.findElement(EMAIL_INPUT);
        waitForElementToBeVisible(emailInput);

        if (formatIsValid(email)) {
            emailInput.sendKeys(email);
        }
    }

    public void typeMessage(String email) {
        log.info("Type in message");
        WebElement messageInput = driver.findElement(MESSAGE_INPUT);
        waitForElementToBeVisible(messageInput);

        if (formatIsValid(email)) {
            messageInput.sendKeys(email);
        }
    }

    public void submitForm() {
        log.info("Submit form");
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public String getSubmitFormMessage() {
        log.info("Get submit form message");
        waitForElementToBeVisible(driver.findElement(SUCCESS_MESSAGE));
        return driver.findElement(SUCCESS_MESSAGE).getText();
    }

    public void navigateToTechExpertise() {
        log.info("Navigate to tech expertise");
        driver.findElement(TECH_EXPERTISE_LINK).click();
    }

    public void navigateToAboutUs() {
        log.info("Navigate to about us");
        driver.findElement(ABOUT_US_LINK).click();
    }

    public void navigateToLinkedIn() {
        log.info("Navigate to LinkedIn: ");
        driver.findElement(LINKEDIN_PAGE).click();
    }

    public void navigateToClutch() {
        log.info("Navigate to Clutch");
        driver.findElement(CLUTCH_PAGE).click();
    }

    public void navigateToUpwork() {
        log.info("Navigate to Upwork");
        driver.findElement(UPWORK_PAGE).click();
    }

    public void waitForWebsiteToBeOpenedAndSwitchToNewTab(String url, int windowIndex) {
        switchToWindowHandleAtIndex(windowIndex, "Switch to new tab");
        DriverWaiter.waitForWebsiteToBeOpened(url);
    }

    public void switchToWindowHandleAtIndex(int index, String additionalInfo) {
        log.info("Switch to window handle at index: " + index + " : " + additionalInfo);
        Set<String> windowHandles = driver.getWindowHandles();
        driver.switchTo().window((String) windowHandles.toArray()[index]);
    }

    public String getWebsiteTitle() {
        log.info("Get website title");
        return driver.getTitle();
    }

    public void clickThroughIndustriesElements() {
        log.info("Click through industries elements");
        List<WebElement> paragraphList = driver.findElements(PARAGRAPH_LIST);
        List<WebElement> industriesList = driver.findElements(INDUSTRIES_LIST);

        for (int i = 0; i < industriesList.size(); i++) {
            industriesList.get(i).click();
            waitForElementToBeVisible(paragraphList.get(i));

            if (paragraphList.get(i).isDisplayed()) {
                counter++;
            } else {
                throw new RuntimeException("Element" + industriesList.get(i).getText() + " was not selected");
            }
        }
    }

    public boolean verifyAllElementsVisible() {
        log.info("Verify all elements visible");
        return counter == driver.findElements(INDUSTRIES_LIST).size();
    }
}