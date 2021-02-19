package com.letskodeit.teachable.listenerspackage;

import org.testng.*;

public class CustomListener2 implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("<><><><> onTestStart ----> Test Name: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("<><><><> onTestSuccess ----> Test Name: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("<><><><> onTestFailure ----> Test Name: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("<><><><> onTestSkipped ----> Test Name: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("<><><><> onTestFailedButWithinSuccessPercentage ----> Test Name: " + result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("<><><><> onTestFailedWithTimeout ----> Test Name: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("<><><><> BEFORE XML Test Tag onStart ----> Context: " + context.toString());

        ITestNGMethod methods[] = context.getAllTestMethods();
        System.out.println("Test methods to be executed in this test tag: ");

        for(ITestNGMethod iTestNGMethod : methods)
            System.out.println(iTestNGMethod.getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("<><><><> AFTER XML Test Tag onFinish ----> Context: " + context.toString());
    }

}
