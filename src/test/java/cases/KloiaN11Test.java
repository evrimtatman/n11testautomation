package cases;

import com.test.n11.webpage.FacebookLoginPage;
import com.test.n11.webpage.N11BrandPage;
import com.test.n11.webpage.N11CosmeticPersonalCarePage;
import com.test.n11.webpage.N11FavoritePage;
import com.test.n11.webpage.N11HomePage;
import com.test.n11.webpage.N11LoginPage;
import com.test.n11.webpage.N11PerfumeDeodorantPage;
import com.test.n11.webpage.N11ProductDetailPage;
import com.test.n11.webpage.N11ProductListPage;
import common.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class KloiaN11Test {

    protected WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void initializeDriver(String browser) {
        if (browser.contains("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        if (browser.contains("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    @Parameters({"username", "password"})
    public void goN11HomePageAndLoginToFacebookViaGivenCredentials(String username, String password) {
        N11HomePage homePage = new N11HomePage(driver);
        homePage.goToHomePage();
        homePage.waitUntilTheLoginButtonAppears();
        homePage.clickLoginButton();

        N11LoginPage loginPage = new N11LoginPage(driver);
        loginPage.waitUntilTheLoginViaFacebookButtonAppears();
        loginPage.clickLoginViaFacebookButton();

        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.switchToFacebookLoginPage();
        facebookLoginPage.insertFacebookUsername(username);
        facebookLoginPage.insertFacebookPassword(password);
        facebookLoginPage.clickToFacebookLoginButton();
        homePage.waitUntilTheLogoutButtonAppears();
        Assert.assertTrue(homePage.verifyUserHasLoggedIn());
    }

    @Test
    @Parameters({"searchKey"})
    public void clickCosmeticAndPersonalCareSectionSelectSeventhProductFromListThenAddToMyFavorites(String searchKey) {
        N11HomePage homePage = new N11HomePage(driver);
        homePage.goToHomePage();
        homePage.waitUntilTheLogoutButtonAppears();
        homePage.goToCosmeticPersonalCare();
        homePage.waitUntilTheLogoutButtonAppears();

        N11CosmeticPersonalCarePage cosmeticPersonalCarePage = new N11CosmeticPersonalCarePage(driver);
        cosmeticPersonalCarePage.clickPerfumeDeodorantLink();
        cosmeticPersonalCarePage.waitUntilTheLogoutButtonAppears();

        N11PerfumeDeodorantPage perfumeDeodorantPage = new N11PerfumeDeodorantPage(driver);
        perfumeDeodorantPage.insertSearchKeywordToInputText(searchKey);
        perfumeDeodorantPage.clickSearchProductButton();
        perfumeDeodorantPage.waitUntilTheLogoutButtonAppears();

        N11ProductListPage productListPage = new N11ProductListPage(driver);
        productListPage.clickSeventhElementInProductList();
        productListPage.waitUntilTheLogoutButtonAppears();

        N11ProductDetailPage productDetailPage = new N11ProductDetailPage(driver);
        productDetailPage.clickWishListButton();
        productDetailPage.waitUntilTheAddToFavouriteWishListButtonAppears();
        productDetailPage.clickAddToFavouriteWishListButton();
        productDetailPage.clickApproveButton();
        String selectedProductName = productDetailPage.getSelectedProductName();
        productDetailPage.goToFavoritePage();
        productListPage.waitUntilTheLogoutButtonAppears();

        N11FavoritePage favoritePage = new N11FavoritePage(driver);
        String addedProductFullName = favoritePage.getAddedProductFullName();
        Assert.assertEquals(selectedProductName, addedProductFullName);
    }

    @Test
    public void writeFooterLinksToTxtFileAndCompareLinksUnderBrandsSection() {
        N11HomePage homePage = new N11HomePage(driver);
        homePage.goToHomePage();
        homePage.waitUntilTheLogoutButtonAppears();

        List<String> allLinksOnFooter = homePage.findAllLinksOnFooter();
        homePage.writeAllLinksOnFooterToTxtFile(allLinksOnFooter);
        homePage.goToBrandsPage();
        homePage.waitUntilTheLogoutButtonAppears();

        N11BrandPage brandPage=new N11BrandPage(driver);
        List<String> allLinksOnFooterOnBrandPage = brandPage.findAllLinksOnFooter();
        List<String> homePageFooterLinks = TestUtil.readFile();

        Assert.assertEquals(homePageFooterLinks,allLinksOnFooterOnBrandPage);

    }

}
