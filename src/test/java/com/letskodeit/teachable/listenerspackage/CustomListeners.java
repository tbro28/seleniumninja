package com.letskodeit.teachable.listenerspackage;

import org.testng.*;

public class CustomListeners implements IInvokedMethodListener, ITestListener, ISuiteListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println(">>>>> Listener beforeInvocation" + testResult.getName() + " - " + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println(">>>>> Listener afterInvocation" + testResult.getName() + " - " + testResult.getTestName() + " - " + method.getTestMethod().getMethodName());
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) { }


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


    @Override
    public void onStart(ISuite suite) {
        System.out.println(">>>>> SUITE Listener --- onStart: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println(">>>>> SUITE Listener --- onFinish: " + suite.getName());
    }


}
