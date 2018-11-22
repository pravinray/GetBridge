package com.sevadevelopment.utility;


import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class WebDriverListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            System.out.println("Test Method BeforeInvocation is started. " + Thread.currentThread().getId());
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browser");
            boolean isGrid = Boolean.parseBoolean(method.getTestMethod().getXmlTest().getLocalParameters().get("isGrid"));
            try {
                SeleniumDriverFactory.setDriver(browserName,isGrid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
       /* if (method.isTestMethod()) {
            System.out.println("Test Method AfterInvocation is started. " + Thread.currentThread().getId());
            WebDriver driver = SeleniumDriverFactory.getDriver();
            if (driver != null) {
                driver.quit();
            }
        }*/
    }
}
