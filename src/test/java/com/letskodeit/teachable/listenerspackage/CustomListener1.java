package com.letskodeit.teachable.listenerspackage;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

public class CustomListener1 implements IInvokedMethodListener {


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
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

    }
}
