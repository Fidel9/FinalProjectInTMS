package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import readProperties.ConfigProvider;


@Log4j2
public class BillingTest extends BaseTest {

    @Test(priority = 1)
    public void checkCurrentSubscriptionsPlanNextChargesInBillingPage() {
        log.info("Позитивный тест. Поиск счета и проверяе сумму на счете");
        BillingPage checkSubscriptionsPlan = new LoginPage(driver)
                .open()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .openBillingPage();

        Assert.assertEquals(checkSubscriptionsPlan.getNextCharge(), "$0");
        log.info(checkSubscriptionsPlan.getNextCharge() + " На счету $0");
    }

    @Test(priority = 2)
    public void checkCurrentSubscriptionPlanInBillingPage() {
        log.info("Позитивный тест. Проверяем что подписка бесплатная");
        BillingPage checkSubscriptionsPlan = new LoginPage(driver)
                .open()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .openBillingPage();

        Assert.assertEquals(checkSubscriptionsPlan.getCurrentSubscriptionPlan(), "Free");
        log.info(checkSubscriptionsPlan.getCurrentSubscriptionPlan() + " Подписка бесплатна");

    }

    @Test(priority = 3)
    public void checkOpenPaymentWindowInPageBillingPage() {
        log.info("Позитивный тест. На поиск карты оплаты");
        PaymentPage paymentPage = new LoginPage(driver)
                .open()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .openBillingPage()
                .openPaymentMethods()
                .openPaymentWindow();

        Assert.assertEquals(paymentPage.getTitleWindowPayments(), "Add new payment method");
        log.info(paymentPage.getTitleWindowPayments() + " Карта надена и желательна проверка если есть возможность");

    }

    @Test(priority = 4)
    public void checkBillingHistoryAmount() {
        log.info("Позитивный тест.Проверяем платежную историю");
        BillingHistoryPage billingHistoryPage = new LoginPage(driver)
                .open()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .openBillingPage()
                .openBillingHistory();

        Assert.assertEquals(billingHistoryPage.getAmountBillingHistory(), "$0.00");
        log.info(billingHistoryPage.getAmountBillingHistory() + " $0.00");
    }

    @Test(priority = 5)
    public void checkBillingHistoryStatus() {
        log.info("Позитивный тест.Проверяем  платежный статус");
        BillingHistoryPage billingHistoryPage = new LoginPage(driver)
                .open()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .openBillingPage()
                .openBillingHistory();

        Assert.assertEquals(billingHistoryPage.getStatusBillingHistory(), "Paid");
        log.info(billingHistoryPage.getStatusBillingHistory() + " Оплачено");
    }
}
