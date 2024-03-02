package selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TechExpertisePage {
    private final WebDriver driver;
    private final By TABS_LIST = By.xpath("//a[@class='tab w-inline-block w-tab-link']");
    private final By LOGO_LINK = By.xpath("//body/div/div/div/a/img[1]");
    private static final Logger log = LogManager.getLogger(TechExpertisePage.class);
    private int counter;


    public TechExpertisePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openURL(String url) {
        log.info("OpenURL: " + url);
        driver.get(url);
    }

    public String getWebsiteTitle() {
        log.info("Get website title");
        return driver.getTitle();
    }


    public void clickThroughTabsList() {
        log.info("Click through tabs list");
        List<WebElement> tabs = driver.findElements(TABS_LIST);

        for (WebElement element : tabs) {
            element.click();
            String ariaSelectedValue = element.getAttribute("aria-selected");

            if (ariaSelectedValue.equals("true")) {
                counter++;
            }
        }
    }

    public boolean clicksThroughAllElements() {
        log.info("Clicks through all elements");
        return counter == driver.findElements(TABS_LIST).size();
    }

    public void clickOnLogoIcon() {
        driver.findElement(LOGO_LINK).click();
    }
}
